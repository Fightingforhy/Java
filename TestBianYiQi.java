
import java.util.*;



class Scanner {



    @SuppressWarnings("serial")

    public static class LexicalException extends Exception {



        int pos;



        public LexicalException(String message, int pos) {

            super(message);

            this.pos = pos;

        }



        public int getPos() {

            return pos;

        }



    }



    public static enum Kind {

        IDENTIFIER, INTEGER_LITERAL, BOOLEAN_LITERAL, STRING_LITERAL,

        KW_x/* x */, KW_X/* X */, KW_y/* y */, KW_Y/* Y */, KW_r/* r */,

        KW_R/* R */, KW_a/* a */, KW_A/* A */, KW_Z/* Z */, KW_DEF_X/* DEF_X */,

        KW_DEF_Y/* DEF_Y */, KW_SCREEN/* SCREEN */, KW_cart_x/* cart_x */, KW_cart_y/* cart_y */,

        KW_polar_a/* polar_a */, KW_polar_r/* polar_r */, KW_abs/* abs */, KW_sin/* sin */,

        KW_cos/* cos */, KW_atan/* atan */, KW_log/* log */, KW_image/* image */, KW_int/* int */,

        KW_boolean/* boolean */, KW_url/* url */, KW_file/* file */, OP_ASSIGN/* = */, OP_GT/* > */,

        OP_LT/* < */, OP_EXCL/* ! */, OP_Q/* ? */, OP_COLON/* : */, OP_EQ/* == */, OP_NEQ/* != */,

        OP_GE/* >= */, OP_LE/* <= */, OP_AND/* & */, OP_OR/* | */, OP_PLUS/* + */, OP_MINUS/* - */,

        OP_TIMES/* * */, OP_DIV/* / */, OP_MOD/* % */, OP_POWER/* ** */, OP_AT/* @ */,

        OP_RARROW/* -> */, OP_LARROW/* <- */, LPAREN/* ( */, RPAREN/* ) */, LSQUARE/* [ */,

        RSQUARE/* ] */, SEMI/* ; */, COMMA/* , */, EOF;

    }

    HashMap<String,Kind> map_keywords=new HashMap<String,Kind>();//建立关键词的表

    HashMap<Character,Kind> map_op=new HashMap<Character,Kind>();//建立运算符的表





    public static enum State {

        START, IN_DIGIT, IN_IDENT, IN_STRING, IN_COMMENT;

    }//这个是我们的状态机的五个状态：起始，数字，变量，字母，评论



    public class Token {

        public final Kind kind;

        public final int pos;

        public final int length;

        public final int line;

        public final int pos_in_line;//每一个token(指对象)，有五个属性

        public Token(Kind kind, int pos, int length, int line, int pos_in_line) {

            super();

            this.kind = kind;

            this.pos = pos;

            this.length = length;

            this.line = line;

            this.pos_in_line = pos_in_line;

        }



        public String getText() {

            if (kind == Kind.STRING_LITERAL) {

                return chars2String(chars, pos, length);

            } else

                return String.copyValueOf(chars, pos, length);

        }



        /**

         * To get the text of a StringLiteral, we need to remove the enclosing "

         * characters and convert escaped characters to the represented

         * character. For example the two characters \ t in the char array

         * should be converted to a single tab character in the returned String

         *

         * @param chars

         * @param pos

         * @param length

         * @return

         */

        private String chars2String(char[] chars, int pos, int length) {

            StringBuilder sb = new StringBuilder();

            for (int i = pos + 1; i < pos + length - 1; ++i) {// omit initial

                // and final "

                char ch = chars[i];

                if (ch == '\\') { // handle escape

                    i++;

                    ch = chars[i];

                    switch (ch) {

                        case 'b':

                            sb.append('\b');

                            break;

                        case 't':

                            sb.append('\t');

                            break;

                        case 'f':

                            sb.append('\f');

                            break;

                        case 'r':

                            sb.append('\r'); // for completeness, line termination

                            // chars not allowed in String

                            // literals

                            break;

                        case 'n':

                            sb.append('\n'); // for completeness, line termination

                            // chars not allowed in String

                            // literals

                            break;

                        case '\"':

                            sb.append('\"');

                            break;

                        case '\'':

                            sb.append('\'');

                            break;

                        case '\\':

                            sb.append('\\');

                            break;

                        default:

                            assert false;

                            break;

                    }

                } else {

                    sb.append(ch);

                }

            }

            return sb.toString();

        }



        /**

         * precondition: 这是一个数字

         *

         * 返回数字值

         */

        public int intVal() {

            assert kind == Kind.INTEGER_LITERAL;

            return Integer.valueOf(String.copyValueOf(chars, pos, length));

        }



        public String toString() {

            return "[" + kind + "," + String.copyValueOf(chars, pos, length) + "," + pos + "," + length + "," + line

                    + "," + pos_in_line + "]";

        }



        /**

         * Since we overrode equals, we need to override hashCode.

         * https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-

         *

         * Both the equals and hashCode method were generated by eclipse

         *

         */

        @Override

        public int hashCode() {

            final int prime = 31;

            int result = 1;

            result = prime * result + getOuterType().hashCode();

            result = prime * result + ((kind == null) ? 0 : kind.hashCode());

            result = prime * result + length;

            result = prime * result + line;

            result = prime * result + pos;

            result = prime * result + pos_in_line;

            return result;

        }



		/*

		 建立自己的equal函数，用于覆盖map的cha'zh

		 *

		 */

        @Override

        public boolean equals(Object obj) {

            if (this == obj)

                return true;

            if (obj == null)

                return false;

            if (getClass() != obj.getClass())

                return false;

            Token other = (Token) obj;

            if (!getOuterType().equals(other.getOuterType()))

                return false;

            if (kind != other.kind)

                return false;

            if (length != other.length)

                return false;

            if (line != other.line)

                return false;

            if (pos != other.pos)

                return false;

            if (pos_in_line != other.pos_in_line)

                return false;

            return true;

        }



        /**

         * used in equals to get the Scanner object this Token is associated

         * with.

         *

         * @return

         */

        private Scanner getOuterType() {

            return Scanner.this;

        }



    }



    /**

     * Extra character added to the end of the input characters to simplify the

     * Scanner.

     */

    static final char EOFchar = 0;



    /**

     * The list of tokens created by the scan method.

     */

    final ArrayList<Token> tokens;



    /**

     * An array of characters representing the input. These are the characters

     * from the input string plus and additional EOFchar at the end.

     */

    final char[] chars;



    /**

     * position of the next token to be returned by a call to nextToken

     */

    private int nextTokenPos = 0;



    Scanner(String inputString) {

        int numChars = inputString.length();

        this.chars = Arrays.copyOf(inputString.toCharArray(), numChars + 1); // input

        chars[numChars] = EOFchar;

        tokens = new ArrayList<Token>();

    }



    /**

     * Method to scan the input and create a list of Tokens.

     *

     * If an error is encountered during scanning, throw a LexicalException.

     *

     * @return

     * @throws LexicalException

     */



    public Scanner scan() throws LexicalException {

        /* 定义我们的关键词*/

        map_keywords.put("x",Kind.KW_x);

        map_keywords.put("X",Kind.KW_X);

        map_keywords.put("y",Kind.KW_y);

        map_keywords.put("Y",Kind.KW_Y);

        map_keywords.put("r",Kind.KW_r);

        map_keywords.put("R",Kind.KW_R);

        map_keywords.put("a",Kind.KW_a);

        map_keywords.put("A",Kind.KW_A);

        map_keywords.put("Z",Kind.KW_Z);

        map_keywords.put("DEF_X",Kind.KW_DEF_X);

        map_keywords.put("DEF_Y",Kind.KW_DEF_Y);

        map_keywords.put("SCREEN",Kind.KW_SCREEN);

        map_keywords.put("cart_x",Kind.KW_cart_x);

        map_keywords.put("cart_y",Kind.KW_cart_y);

        map_keywords.put("polar_a",Kind.KW_polar_a);

        map_keywords.put("polar_r",Kind.KW_polar_r);

        map_keywords.put("abs",Kind.KW_abs);

        map_keywords.put("sin",Kind.KW_sin);

        map_keywords.put("cos",Kind.KW_cos);

        map_keywords.put("atan",Kind.KW_atan);

        map_keywords.put("log",Kind.KW_log);

        map_keywords.put("image",Kind.KW_image);

        map_keywords.put("int",Kind.KW_int);

        map_keywords.put("boolean",Kind.KW_boolean);

        map_keywords.put("url",Kind.KW_url);

        map_keywords.put("file",Kind.KW_file);

        map_op.put('?', Kind.OP_Q);

        map_op.put(':', Kind.OP_COLON);

        map_op.put('&', Kind.OP_AND);

        map_op.put('|', Kind.OP_OR);

        map_op.put('+', Kind.OP_PLUS);

        map_op.put('@', Kind.OP_AT);

        map_op.put('%', Kind.OP_MOD);

        map_op.put(';', Kind.SEMI);

        map_op.put(',', Kind.COMMA);

        map_op.put('(', Kind.LPAREN);

        map_op.put(')', Kind.RPAREN);

        map_op.put('[', Kind.LSQUARE);

        map_op.put(']', Kind.RSQUARE);

        int pos = 0;

        int line = 1;

        int sum=0;

        String temp="";

        State state = State.START;

        int startPos = 1;

        int pos_temp=0;//自动状态机开始，在其中定义好每一个字符扫入后的状态转移路线。笨一点就用switch_case实现就可以了

        while (pos <= chars.length) {

            char ch=EOFchar;

            switch (state) {

                case START: { //开始态

                    ch = pos < chars.length ? chars[pos] : EOFchar;

                    switch (ch) {

                        case '=': {

                            if(chars[pos+1]=='='){

                                tokens.add(new Token(Kind.OP_EQ,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_ASSIGN,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '-': {

                            if(chars[pos+1]=='>'){

                                tokens.add(new Token(Kind.OP_RARROW,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_MINUS,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '>': {

                            if(chars[pos+1]=='='){

                                tokens.add(new Token(Kind.OP_GE,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_GT,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '!': {

                            if(chars[pos+1]=='='){

                                tokens.add(new Token(Kind.OP_NEQ,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_EXCL,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '<': {

                            if(chars[pos+1]=='='){

                                tokens.add(new Token(Kind.OP_LE,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else if(chars[pos+1]=='-'){

                                tokens.add(new Token(Kind.OP_LARROW,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_LT,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '*': {

                            if(chars[pos+1]=='*'){

                                tokens.add(new Token(Kind.OP_POWER,pos, 2,line,startPos));

                                pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_TIMES,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '/': {

                            if(chars[pos+1]=='/'){

                                state=State.IN_COMMENT;

                                pos_temp=pos;pos+=2;startPos+=2;

                            }

                            else{

                                tokens.add(new Token(Kind.OP_DIV,pos, 1,line,startPos));

                                pos++;startPos++;

                            }

                        }break;

                        case '\r':{

                            if(chars[pos+1]=='\n'){

                                line++;startPos=1;pos+=2;

                            }

                            else{

                                line++;pos++;startPos=1;

                            }

                        }break;

                        case '0': {tokens.add(new Token(Kind.INTEGER_LITERAL,pos, 1,line,startPos));pos++;startPos++;}break;

                        case '\n':{line++;pos++;startPos=1;}break;

                        case '\"':{state=State.IN_STRING;pos_temp=pos;pos++;}break;

                        case EOFchar:{pos++;}break;

                        default: {

                            if(map_op.containsKey(ch)){tokens.add(new Token(map_op.get(ch), pos, 1,line,startPos));pos++;startPos++;}

                            else if (Character.isDigit(ch)) {sum=0;state = State.IN_DIGIT;pos_temp=pos;}

                            else if (Character.isJavaIdentifierStart(ch)) {

                                state = State.IN_IDENT;pos_temp=pos;temp="";

                            }

                            else if (Character.isWhitespace(ch)){

                                pos++;startPos++;

                            }

                            else {throw new LexicalException("Illegal Character",pos); }

                        }

                    }

                    // switch (ch)

                }  break;

                case IN_DIGIT: {//数字态

                    ch = pos < chars.length ? chars[pos] : EOFchar;

                    if(Character.isDigit(ch)){temp+=ch;pos++;}

                    else{

                        for (int i = 0; i < temp.length(); i++) {

                            sum  = sum * 10 + (temp.charAt(i) - '0');

                            if (sum < 0)  throw new LexicalException("Integeal too big!",pos_temp);

                        }

                        tokens.add(new Token(Kind.INTEGER_LITERAL, pos_temp, pos - pos_temp,line,startPos));

                        startPos+=pos-pos_temp;

                        pos_temp=0;

                        temp="";

                        state=State.START;



                    }



                }break;

                case IN_IDENT: {//变量

                    ch = pos < chars.length ? chars[pos] : EOFchar;

                    if (Character.isLetterOrDigit(ch) || ch=='$' || ch=='_') {

                        temp+=ch;

                        pos++;

                    }

                    else {



                        if(map_keywords.containsKey(temp)){

                            tokens.add(new Token(map_keywords.get(temp), pos_temp, pos - pos_temp,line,startPos));

                        }

                        else if(temp.equals("true")||temp.equals("false")){

                            tokens.add(new Token(Kind.BOOLEAN_LITERAL, pos_temp, pos - pos_temp,line,startPos));



                        }

                        else{

                            tokens.add(new Token(Kind.IDENTIFIER, pos_temp, pos - pos_temp,line,startPos));

                        }

                        state = State.START;

                        startPos+=pos-pos_temp;

                        temp="";

                        pos_temp=0;

                    }

                }  break;

                case IN_STRING: {//字符串

                    ch = pos < chars.length ? chars[pos] : EOFchar;

                    //System.out.println(ch);

                    if (ch=='\n'||ch=='\t'||ch=='\f'||ch=='\r'){

                        throw new LexicalException("Illegal Character for String Literal",pos);

                    }

                    else if(ch=='\\'){

                        if(chars[pos+1]=='n'||chars[pos+1]=='t'||chars[pos+1]=='b'||chars[pos+1]=='f'||chars[pos+1]=='r'||chars[pos+1]=='\"'||chars[pos+1]=='\''||chars[pos+1]=='\\'){

                            temp=temp+ch+chars[pos+1];pos+=2;

                        }

                        else{

                            throw new LexicalException("Illegal Character for String Literal",pos+1);

                        }

                    }

                    else if (ch!=EOFchar&&ch!='\"') {

                        temp+=ch;

                        pos++;

                    }

                    else {

                        if(ch!='\"') {throw new LexicalException("Missing \" in the end of String",pos);}

                        else{

                            tokens.add(new Token(Kind.STRING_LITERAL, pos_temp, pos - pos_temp+1,line,startPos));

                            pos++;

                            state = State.START;

                            startPos+=pos-pos_temp;

                            temp="";}

                    }

                }  break;

                case IN_COMMENT: {//评论

                    ch = pos < chars.length ? chars[pos] : EOFchar;

                    if (ch!='\n'&&ch!='\r'&&ch!=EOFchar) {

                        pos++;

                    }

                    else {

                        state=State.START;

                        startPos+=pos-pos_temp;

                    }

                }  break;

                default:  throw new LexicalException("ILLEGAL CHARACTER",pos);

            }// switch(state)

        } // while

        tokens.add(new Token(Kind.EOF, pos-2, 0,line,startPos));

        return this;

    }



    /**

     * Returns true if the internal interator has more Tokens

     *

     * @return

     */

    public boolean hasTokens() {

        return nextTokenPos < tokens.size();

    }



    /**

     * Returns the next Token and updates the internal iterator so that the next

     * call to nextToken will return the next token in the list.

     *

     * It is the callers responsibility to ensure that there is another Token.

     *

     * Precondition: hasTokens()

     *

     * @return

     */

    public Token nextToken() {

        return tokens.get(nextTokenPos++);

    }



    /**

     * Returns the next Token, but does not update the internal iterator. This

     * means that the next call to nextToken or peek will return the same Token

     * as returned by this methods.

     *

     * It is the callers responsibility to ensure that there is another Token.

     *

     * Precondition: hasTokens()

     *

     * @return next Token.

     */

    public Token peek() {

        return tokens.get(nextTokenPos);

    }



    /**

     * Resets the internal iterator so that the next call to peek or nextToken

     * will return the first Token.

     */

    public void reset() {

        nextTokenPos = 0;

    }



    /**

     * Returns a String representation of the list of Tokens

     */

    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("Tokens:\n");

        System.out.println(tokens.size());

        for (int i = 0; i < tokens.size(); i++) {

            sb.append(tokens.get(i)).append('\n');

        }

        return sb.toString();

    }



}

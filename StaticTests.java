import static java.lang.System.out;
class StaticSuper{
    static {
        out.println("super static block");
    }
    StaticSuper(){
        out.println("super constructor");
    }
}
class statics{
    static {
        out.println("hahahha");
    }
    public static void main(String [] args){
        out.println("in main");
        statics s=new statics();
        StaticTests st=new StaticTests();
    }
}
public class StaticTests extends StaticSuper{
    static int rand;
    static {
        rand=(int) (Math.random()*6);
        out.println("static block " +rand);
    }
    StaticTests(){
        out.println("constructor");
    }

}
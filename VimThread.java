import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Date;

class VimFile3 extends JFrame {
    boolean judge=false;
    int pos,col,row,setPosition;
    JTextArea textArea;
    File CurFileName=new File("D:\\test\\ha.txt"); //默认保存路径
    public File getCurFileName(){
        return CurFileName;
    }
    public void setCurFileName(File curFileName){
        CurFileName=curFileName;
    }
    public static void main(String[] args){
        VimFile3 vimTest2=new VimFile3();
    }
    //构造函数，创建GUI
    public VimFile3(){
        judge=false;
        int a,b;
        this.setTitle("Vim");
        textArea=new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(textArea);

        this.getContentPane().setLayout(new BorderLayout());

        this.add(scrollPane,BorderLayout.CENTER);

        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        textArea.addKeyListener(new KeyListenerTest1());
        Runnable threadJob=new MyRunnable();
        Thread thread=new Thread(threadJob);
        if(textArea.getText()!=null){
            thread.start();
        }
    }

    //文件操作
    public class FileTest1{
        //保存文件
        public void saveFile(File file){
            if(file==null){ return; }
            if (!file.exists()){
                try{
                    boolean createResult=file.createNewFile();
                    if(createResult){
                        System.out.println("文件创建成功");
                        System.out.println("保存文件的路径是"+file.getAbsolutePath());
                    }else{
                        System.out.println("文件创建失败");
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("保存文件的路径是"+file.getAbsolutePath());
            }
            if(!file.isFile()){ return; }
            try{
                FileOutputStream fos=new FileOutputStream(file);
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
                String[] s=textArea.getText().split("\n");
                for(int i=0;i<s.length;i++){
                    bw.write(s[i]);
                    bw.write("\r\n");
                    bw.flush();
                }
                fos.close();
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        //另存文件
        public void saveAs(){
            File saveAsFileName=null;
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setDialogTitle("另存为");
            int resultVal=fileChooser.showSaveDialog(null);
            fileChooser.setVisible(true);
            switch(resultVal){
                case JFileChooser.APPROVE_OPTION:
                    saveAsFileName=fileChooser.getSelectedFile().getAbsoluteFile();
                    this.saveFile(saveAsFileName);
                    break;
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("退出保存文件选择框");
                    break;
                case JFileChooser.ERROR_OPTION:
                    System.out.println("保存文件出错");
                    break;
            }
        }
    }

    //键盘按键监听
    public class KeyListenerTest1 implements KeyListener{
        FileTest1 fileTest1=new FileTest1();
        int a,b,c,d,e;
        int countd=0;
        int county=0;
        String copy=null;
        public void keyPressed(KeyEvent e){}
        public void keyTyped(KeyEvent e){}
        public void keyReleased(KeyEvent e){
            char keyChar=e.getKeyChar();
            //切换为非编辑模式
            if(keyChar==27&&judge==true){
                textArea.setEditable(false);
                judge=false;
            }
            //切换为编辑模式
            if(keyChar=='i'&&judge==false){
                textArea.setEditable(true);
                judge=true;
            }
            //非编辑模式向左移动光标
            if (keyChar=='h'&&judge==false){
                textArea.setCaretPosition(textArea.getCaretPosition()-1);
            }
            //非编辑模式向右移动光标
            if (keyChar=='l'&&judge==false){
                textArea.setCaretPosition(textArea.getCaretPosition()+1);
            }
            //非编辑模式向上移动光标
            if (keyChar=='k'&&judge==false){
                pos = textArea.getCaretPosition();
                col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                try {
                    row = textArea.getLineOfOffset(pos) + 1;
                } catch (Exception var4) {
                }
                setPosition=0;
                try{
                    if(textArea.getCaretPosition()-textArea.getLineStartOffset(row-1)>textArea.getLineEndOffset(row-2)-textArea.getLineStartOffset(row-2)-1){
                        setPosition=textArea.getLineEndOffset(row-2)-1;
                    }else{
                        if(row-1==1){
                            setPosition=textArea.getCaretPosition()-textArea.getLineStartOffset(row-1);
                        }
                        else{
                            setPosition=textArea.getCaretPosition()-textArea.getLineStartOffset(row-1)+textArea.getLineStartOffset(row-2);
                        }
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                textArea.setCaretPosition(setPosition);
            }
            //非编辑模式向下移动光标
            if (keyChar=='j'&&judge==false){
                pos = textArea.getCaretPosition();
                col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                try {
                    row = textArea.getLineOfOffset(pos) + 1;
                } catch (Exception var4) {
                }
                setPosition=0;
                try{
                    if(textArea.getCaretPosition()-textArea.getLineStartOffset(row-1)>textArea.getLineEndOffset(row)-textArea.getLineStartOffset(row)){
                        if(row==textArea.getLineCount()-1){
                            setPosition=textArea.getLineEndOffset(row);
                        }else{
                            setPosition = textArea.getLineEndOffset(row)-1;
                        }


                    }else{
                        if(row==1){
                            setPosition=textArea.getCaretPosition()+textArea.getLineEndOffset(row-1);
                        }
                        else{
                            setPosition=textArea.getCaretPosition()-textArea.getLineStartOffset(row-1)+textArea.getLineStartOffset(row);
                        }
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                textArea.setCaretPosition(setPosition);
            }
            //保存文件
            if(keyChar=='w'&&judge==false){
                fileTest1.saveFile(getCurFileName());
            }
            //保存并退出
            if (keyChar=='x'&&judge==false){
                System.out.println("退出");
                fileTest1.saveFile(getCurFileName());
                System.exit(0);
            }
            //另存为
            if(keyChar=='s'&&judge==false){
                fileTest1.saveAs();
            }
            if(keyChar=='d'&&judge==false){
                countd++;
                System.out.println("第"+countd+"次"+"按下按键d");
                if(countd%2==0){
                    pos = textArea.getCaretPosition();
                    col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                    try {
                        row = textArea.getLineOfOffset(pos) + 1;
                    } catch (Exception ex) {ex.printStackTrace(); }
                    String[] s=textArea.getText().split("\n");
                    String[] st=new String[s.length-1];
                    int j=0;
                    for(int i=0;i<s.length;i++){
                        if(i!=row-1){
                            st[j]=s[i];
                            j++;
                        }
                    }
                    textArea.setText("");
                    for(int i=0;i<st.length;i++){
                        if(i<st.length-1){
                            textArea.append(st[i]);
                            textArea.append("\r\n");
                        }
                        else{
                            textArea.append(st[i]);
                        }
                    }
                    System.out.println("删除成功");
                }
            }
            if(keyChar=='y'&&judge==false){
                county++;
                System.out.println("第"+county+"次"+"按下按键y");
                if(county%2==0){
                    pos = textArea.getCaretPosition();
                    col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                    try {
                        row = textArea.getLineOfOffset(pos) + 1;
                    } catch (Exception ex) {ex.printStackTrace(); }
                    String[] s=textArea.getText().split("\n");
                    String st=null;
                    for(int i=0;i<s.length;i++){
                        if(i==row-1){
                            st=s[i];
                        }
                    }
                    copy=st;
                    System.out.println("字符串："+"'"+st+"'"+"被保存到粘贴板");
                    //textArea.append("\r\n");
                    //textArea.append(st);
                }
            }
            if(keyChar=='p'&&judge==false){
                textArea.append("\r\n");
                textArea.append(copy);
            }

        }

    }

    //每隔30秒保存一次文件
    public class MyRunnable implements Runnable{
        FileTest1 fileTest1=new FileTest1();
        public void run(){
            while(true){
                fileTest1.saveFile(getCurFileName());
                System.out.println("文件保存成功  "+String.format("%tc",new Date()));
                try{
                    Thread.sleep(30000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
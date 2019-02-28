import java.io.*;

public class BufferDemo{
    public static void main(String [] args){
        try{
            FileOutputStream fos=new FileOutputStream("D:\\test1.txt");
            BufferedOutputStream bos=new BufferedOutputStream(fos);
            byte[] b={'a','b','c','d','e'};
            fos.write(b);
            fos.close();
            FileInputStream fis=new FileInputStream("D:\\test1.txt");
            BufferedInputStream bis=new BufferedInputStream(fis);
            int ch=bis.read();
            while (ch!=-1){
                System.out.println((char) ch);
                ch=bis.read();
            }
            fis.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
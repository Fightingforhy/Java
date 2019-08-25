import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo{
    public static void main(String[] args){
        try{
            FileOutputStream fos=new FileOutputStream("D:\\test.txt");
            byte[] b={'a','c','d','e','x'};
            fos.write(b);
            fos.close();
            FileInputStream fis =new FileInputStream("D:\\test.txt");
            int ch=fis.read();
            while(ch!=-1){
                System.out.println((char) ch);
                ch=fis.read();
            }
            byte[] buffer =new byte[5];
            fis.read(buffer);
            for(int i=0;i<buffer.length;i++){
                System.out.println((char) buffer[i]);
            }
            fis.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
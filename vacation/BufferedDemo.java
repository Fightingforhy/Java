import java.io.*;

public class BufferedDemo{
    public static void main(String [] args){
        try{
            FileReader fr=new FileReader("D:\\test1.txt");
            BufferedReader br=new BufferedReader(fr);
            FileWriter fw=new FileWriter("D:\\test2.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            String str=br.readLine();
            while(str!=null){
                bw.write(str);
                bw.newLine();
                str=br.readLine();
            }
            br.close();
            bw.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
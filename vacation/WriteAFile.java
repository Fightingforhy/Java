import java.io.*;
class WriteAFile{
    public static void main(String [] args){
        try{
            FileWriter writer=new FileWriter("Mytext.txt");
            writer.write("hello mytext!");
            writer.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
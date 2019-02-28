import javax.swing.*;
import java.awt.*;
import java.sql.BatchUpdateException;

public class Button1{
    public static void main(String [] args){
        Button1 button1=new Button1();
        button1.go1();
    }
    public void go(){
        JFrame frame=new JFrame();
        Button button=new Button("Click This");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font bigFont=new Font("serif",Font.BOLD,28);
        button.setFont(bigFont);
        frame.getContentPane().add(BorderLayout.NORTH,button);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
    }
    public void go1(){
        JFrame frame=new JFrame();
        Button east=new Button("East");
        Button west=new Button("West");
        Button south =new Button("South");
        Button north=new Button("North");
        Button center =new Button("Center");
        frame.getContentPane().add(BorderLayout.EAST,east);
        frame.getContentPane().add(BorderLayout.WEST,west);
        frame.getContentPane().add(BorderLayout.SOUTH,south);
        frame.getContentPane().add(BorderLayout.NORTH,north);
        frame.getContentPane().add(BorderLayout.CENTER,center);
        frame.setSize(300,300);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
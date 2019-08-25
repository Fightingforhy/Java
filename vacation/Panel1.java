import javax.swing.*;
import java.awt.*;
public class Panel1{
    public static void main(String [] args){
        Panel1 panel1=new Panel1();
        panel1.go();
    }
    public  void go(){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JButton button=new JButton("shock me");
        JButton button1=new JButton("bliss");
        JButton button2=new JButton("huh?");
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
import javax.swing.*;
public class SimpleGuil{
    public static void main(String [] args){
        JFrame frame =new JFrame();
        JButton button =new JButton("click me hahaha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
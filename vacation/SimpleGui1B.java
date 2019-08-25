import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleGui1B implements ActionListener{
    JButton button;
    public void go(){
        JFrame frame =new JFrame();
        button =new JButton("click me");
        button.addActionListener(this);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        SimpleGui1B gui=new SimpleGui1B();
        gui.go();
    }
    public void actionPerformed(ActionEvent event){
        button.setText("I've been clicked!");
    }
}
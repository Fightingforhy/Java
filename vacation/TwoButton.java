import javafx.scene.layout.BorderRepeat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButton{
    JFrame frame;
    JLabel label;
    JButton colorButton=new JButton("Change Circle");
    public static void main(String [] args){
        TwoButton gui=new TwoButton();
        gui.go();
    }
    public void go(){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton labelButton=new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());
        //JButton colorButton=new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());
        label=new JLabel("I'm a label");
        MyDrawPanel1 drawPanel=new MyDrawPanel1();
        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.WEST,label);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("Ouch!");
        }
    }
    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();

        }
    }
}
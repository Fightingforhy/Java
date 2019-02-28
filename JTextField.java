import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class TextField implements ActionListener{
    JTextField textField;
    public static void main(String [] args){
        TextField textField=new TextField();
        textField.go();
    }
    public void go(){
        JFrame frame=new JFrame();
        JButton button=new JButton();
        button.addActionListener(this);
        textField=new JTextField(20);
        textField=new JTextField("Your name");
        //System.out.println(textField.getText());
        textField.setText("whatever");
        textField.setText("");
        textField.addActionListener(this);
        //textField.selectAll();
        //textField.requestFocus();
        frame.add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        textField.selectAll();
        textField.requestFocus();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//文本框
class JTextFieldDemo{
    JFrame frame;
    JTextField textField;
    JLabel label;
    public JTextFieldDemo(){
        frame=new JFrame("JTextFieldDemo");
        label=new JLabel("Your name");
        frame.add(label);
        textField=new JTextField(8);
        frame.add(textField);
        //textField.addActionListener(new ActionListener() {
            //@Override
           // public void actionPerformed(ActionEvent e) {
           //     System.out.println(textField.getText());
          //  }
       // });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JTextFieldDemo();
    }
}
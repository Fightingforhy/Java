import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//相当于输入密码的时候，会显示‘*’；
class JPasswordFieldDemo{
    JFrame frame;
    JPasswordField passwordField;
    public JPasswordFieldDemo(){
        frame=new JFrame("JPasswordFieldDemo");
        passwordField=new JPasswordField(10);
        passwordField.setEchoChar('*');
        frame.getContentPane().add(passwordField);
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] input=passwordField.getPassword();
                for(char c:input){
                    System.out.println(c);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JPasswordFieldDemo();
    }
}
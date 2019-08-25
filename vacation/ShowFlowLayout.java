import javax.swing.*;
import java.awt.*;

public class ShowFlowLayout extends JFrame{
    public ShowFlowLayout(){
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        add(new JLabel("用户名"));
        add(new JTextField(8));
        add(new JLabel("密码  "));
        add(new JTextField(8));
    }
    public static void main(String [] args){
        ShowFlowLayout frame=new ShowFlowLayout();

        frame.setTitle("ShowFlowLayout");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setSize(500,300);
        frame.setVisible(true);
    }
}
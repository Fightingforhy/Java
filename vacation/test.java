import javax.swing.*;
import java.awt.*;

 class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(250, 125);
        JPanel panelFirst = new JPanel();//存放用户名密码
        JPanel panelSecond = new JPanel();//存放按钮
        panelFirst.setLayout(new GridLayout(2, 2));
        JLabel userLabel = new JLabel("username");
        JLabel passLabel = new JLabel("password");
        JTextField userText = new JTextField();
        JTextField passText = new JTextField();
        panelFirst.add(userLabel);
        panelFirst.add(userText);
        panelFirst.add(passLabel);
        panelFirst.add(passText);
        panelSecond.setLayout(new FlowLayout());
        Button reg = new Button("Register");
        Button login = new Button("Login");
        Button cancel = new Button("Cancel");
        panelSecond.add(reg);
        panelSecond.add(login);
        panelSecond.add(cancel);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.getContentPane().setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.add(panelSecond, BorderLayout.SOUTH);
        frame.add(panelFirst, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}
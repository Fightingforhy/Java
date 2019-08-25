import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.*;


class JButtonDemo{
    JFrame frame;
    JButton button;
    public JButtonDemo() {
        frame = new JFrame("JButtonDemo");
        button = new JButton("百度搜索");
        frame.getContentPane().add(BorderLayout.NORTH, button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("cmd/c start http://www.baidu.com");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JButtonDemo();
    }
}
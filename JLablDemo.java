//package blog.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class JLabelDemo{
    JFrame frame;
    JLabel label;
    public JLabelDemo(){
        frame=new JFrame("JLabelDemo");
        label=new JLabel("<html><a href=http:www.baidu.com>百度搜索</a></html>");//嵌入了html标签
        label.addMouseListener(new MouseAdapter(){  //添加鼠标事件侦听器，当单机标签时，打开网页
            public void mouseClicked(MouseEvent e) {
                try {
                    Runtime.getRuntime().exec("cmd/c start http://www.baidu.com");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        label.setCursor(new Cursor(Cursor.HAND_CURSOR)); //设置手形鼠标
        frame.getContentPane().add(BorderLayout.NORTH,label);//将标签添加到窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();             //使窗口自动根据添加了的组件调整大小
        frame.setLocationRelativeTo(null);
        frame.setSize(300,300);
        frame.setVisible(true);
        }
        public static void main(String [] args){
        new JLabelDemo();
    }
}
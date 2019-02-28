import javax.swing.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class VimTest1 implements ActionListener {
    Frame frame= new Frame();
    Panel nn=new Panel();
    Label a1=new Label("用户名");
    Label a2=new Label("密码  ");
    TextField b1=new TextField("name     ");
    TextField b2=new TextField("password");
    Button n1=new Button("确定");
    public void run(){
        nn.add(a1);
        nn.add(b1);
        nn.add(a2);
        b2.setEchoChar('*');
        n1.addActionListener(this);
        nn.add(b2);
        nn.add(n1);
        frame.add(nn);
        frame.setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        VimTest1 e1=new VimTest1();
        e1.run();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==n1){
            Frame nw1=new Frame("信息");
            TextField b3=new TextField("功能尚未开放");
            nw1.add(b3);
            nw1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            nw1.setSize(300,300);
            nw1.setVisible(true);
        }


    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleGui3c implements ActionListener{
    JFrame frame;
    public static void main(String [] args){
        SimpleGui3c gui=new SimpleGui3c();
        gui.go();
    }
    public void go(){
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button=new JButton("Change colors");
        button.addActionListener(this);
        MyDrawPanel1 drawPanel=new MyDrawPanel1();
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.setSize(300,300);
        frame.setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        frame.repaint();
    }
}
class MyDrawPanel1 extends JPanel{
    public void paintComponent(Graphics g){
        //显示.jpg图片
        //g.setColor(Color.red);
        //g.fillRect(20,50,100,100);
        //g.fillOval(70,70,100,100)
        //Image image=new ImageIcon("catzilla.jpg").getImage();
        //g.drawImage(image,3,4,this);

        //变色椭圆
        Graphics2D g2d=(Graphics2D) g;
        int red=(int) (Math.random()*255);
        int green=(int) (Math.random()*255);
        int blue=(int) (Math.random()*255);
        Color randomColor=new Color(red,green,blue);
        //Color startColor=new Color(red,green,blue);
        //red=(int)(Math.random()*255);
        //green=(int)(Math.random()*255);
        //blue=(int) (Math.random()*255);
        //Color endColor=new Color(red,green,blue);
        //GradientPaint gradient=new GradientPaint(70,70,startColor,150,150,endColor);
         g.setColor(randomColor);
        g2d.fillOval(100,100,100,100);
    }
}
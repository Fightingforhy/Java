import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameTest1 extends JPanel implements ActionListener {
    JButton button;
    JFrame frame;
    public static void main(String [] args){
        FrameTest1 frameTest1=new FrameTest1();
        frameTest1.go();
    }
    public void go(){
        JFrame frame=new JFrame("FrameTest1");
        button=new JButton("ok");
        button.addActionListener(this);
        Mydrawpaint1 mydrawpaint=new Mydrawpaint1();
        frame.getContentPane().add(BorderLayout.CENTER,button);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //JButton button1=new JButton("用户名");
        //frame.getContentPane().add(button1);
    }
    public void actionPerformed(ActionEvent event){
        frame.repaint();
    }
    public class Mydrawpaint1 extends JPanel{
        public void paintComponent(Graphics g){
            //显示.jpg图片
            g.setColor(Color.red);
            g.fillRect(20,50,100,100);
            //g.fillOval(70,70,100,100)
            Image image=new ImageIcon("catzilla.jpg").getImage();
            g.drawImage(image,3,4,this);

            //变色椭圆
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            int red=(int) (Math.random()*255);
            int green=(int) (Math.random()*255);
            int blue=(int) (Math.random()*255);
            Color randomColor=new Color(red,green,blue);
            g.setColor(randomColor);
            g.fillOval(70,70,100,100);

            //渐变色
            Graphics2D g2d=(Graphics2D) g;
            GradientPaint gradient=new GradientPaint(70,70,Color.blue,150,150,Color.orange);
            g2d.setPaint(gradient);
            g2d.fillOval(70,70,100,100);

            //随机渐变颜色
            //int red=(int) (Math.random()*255);
            //int green=(int) (Math.random()*255);
            //int blue=(int) (Math.random()*255);
            Color endColor=new Color(red,green,blue);
            //GradientPaint gradient=new GradientPaint(70,70,Color.blue,150,150,Color.orange);
            //g2d.setPaint(gradient);
            //g2d.fillOval(70,70,100,100);
        }
    }

}
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
class MyDrawPanel extends JPanel {
    JButton button;
    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
       // Image image=new ImageIcon("catzilla.jpg");
      //  g.drawImage(image,3,4,this);
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        int red=(int) (Math.random()*25);
        int green=(int) (Math.random()*255);
        int blue=(int) (Math.random()*255);

        Color randomColor=new Color(red,green,blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
    public void go(){
        JFrame frame =new JFrame();
        button =new JButton("click me");
       // button.addActionListener(this);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        MyDrawPanel draw =new MyDrawPanel();
        draw.go();
    }
}
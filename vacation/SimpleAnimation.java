import sun.reflect.annotation.ExceptionProxy;

import javax.swing.*;
import java.awt.*;
public class SimpleAnimation{
    int x=0;
    int y=0;
    public static void main(String [] args){
        SimpleAnimation gui=new SimpleAnimation();
        gui.go();
    }
    public void go(){
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel=new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setSize(500,500);
        frame.setVisible(true);
        int width=frame.getWidth();
        for(int i=0;i<width-80;i++) {
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (Exception ex) { }
        }
        for(int i=0;i<width-60;i++){
            x++;
            drawPanel.repaint();
            try{
                Thread.sleep(5);
            }catch(Exception ex){ }
        }
        for(int i=0;i<width-80;i++){
            y--;
            drawPanel.repaint();
            try{
                Thread.sleep(5);
            }catch(Exception ex){}
        }
        for(int i=0;i<width-60;i++){
            x--;
            drawPanel.repaint();
            try{
                Thread.sleep(5);
            }catch(Exception ex){}
        }
        x+=20;
        for(int i=0;i<width-80;i++){
            x++;y++;
            drawPanel.repaint();
            try{
                Thread.sleep(5);
            }catch(Exception ex){}
        }
    }
    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.black);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(Color.blue);
            g.fillOval(x,y,40,40);
        }
    }
}
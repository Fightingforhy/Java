@@ -0,0 +1,34 @@
import javax.swing.*;
import java.awt.*;
public class Animate{
    int x=1;
    int y=1;
    JFrame frame;
    public static void main(String [] args){
        Animate animate=new Animate();
        animate.go();
    }
    public void go(){
        JFrame frame=new JFrame();
        MyDrawP myDrawP=new MyDrawP();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,270);
        frame.getContentPane().add(myDrawP);
        frame.setVisible(true);
        for(int i=0;i<124;i++,x++){
            x++;y++;
            myDrawP.repaint();
            try{
                Thread.sleep(50);
            }catch(Exception ex){}
        }
    }
    class MyDrawP extends JPanel{
        public void paintComponent(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0,0,500,250);
            g.setColor(Color.blue);
            g.fillRect(x,y,500-x*2,250-y*2);
        }
    }
}

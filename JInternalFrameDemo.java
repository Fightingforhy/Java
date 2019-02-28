import java.awt.*;
import javax.swing.*;
//实现多文档程序
class  JInternalFrameDemo
{
    JFrame mainFrame;
    JDesktopPane desktop;
    public JInternalFrameDemo(){
        mainFrame = new JFrame ("JInternalFrame");
        desktop = new JDesktopPane();

        for(int i=0; i<4; i++){
            JInternalFrame internalFrame = new JInternalFrame();
            internalFrame.setVisible( true );
            internalFrame.setLocation(i*40,i*40);
            internalFrame.getContentPane().add( new JButton ("button") );
            internalFrame.pack();
            desktop.add(internalFrame);
        }
//        desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        mainFrame.setContentPane(desktop);
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.setSize(400,400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }

    public static void main(String[] args)
    {
        new JInternalFrameDemo();
    }
}
import javax.swing.*;
import java.awt.Color;

//选项卡
class JTabbedPaneDemo
{
    JFrame mainFrame;
    JTabbedPane simpleTabbedPane;
    public JTabbedPaneDemo() {
        mainFrame = new JFrame ( "Vim" );
        simpleTabbedPane = new JTabbedPane();
        simpleTabbedPane.setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );
        simpleTabbedPane.addTab("Tab1",new JLabel ("Component1"));
        simpleTabbedPane.addTab("Tab2",new JLabel ("Component2"));
        simpleTabbedPane.addTab("Tab3",new JLabel ("Component3"));
        simpleTabbedPane.addTab("Tab4",new JLabel ("Component4"));
        for(int i=0; i<4; i++){
            simpleTabbedPane.setTabComponentAt( i,new JButton (""+i));
            simpleTabbedPane.setBackgroundAt(i,Color.black);
        }
        mainFrame.getContentPane().add( simpleTabbedPane );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainFrame.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    public static void main(String[] args)
    {
        new JTabbedPaneDemo();
    }
}
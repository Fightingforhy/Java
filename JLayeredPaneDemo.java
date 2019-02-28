import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class JLayeredPaneDemo
{
    JFrame mainFrame;
    JLayeredPane layeredPane;
    JLabel blackLabel;
    JComboBox layerList;
    public JLayeredPaneDemo() {
        mainFrame = new JFrame ( "JLayeredPaneDemo" );
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize( new Dimension(200,300) );
        Color[] colors = { Color.red, Color.green, Color.yellow, Color.blue };
        for( int i=0; i<4; i++){
            JLabel label = createLabel(i,colors[i]);
            layeredPane.add( label, new Integer(i) );
        }
        blackLabel = new JLabel ( "lll" );
        blackLabel.setBounds( 15,40,120,120);
        blackLabel.setOpaque( true );
        blackLabel.setBackground( Color.black );
        layeredPane.add( blackLabel, new Integer(1), 0 );
        layeredPane.addMouseMotionListener( new MouseInputAdapter(){
            public void mouseMoved( MouseEvent e ){
                blackLabel.setBounds( e.getX(),e.getY(),120,120 );
            }
        } );

        String layerListItem[] = { "PUT THE BLACK LABEL AT LAYER 0",
                "PUT THE BLACK LABEL AT LAYER 1","PUT THE BLACK LABEL AT LAYER 2",
                "PUT THE BLACK LABEL AT LAYER 3","PUT THE BLACK LABEL AT LAYER 4" };
        layerList = new JComboBox( layerListItem );
        layerList.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                layeredPane.setLayer( blackLabel,layerList.getSelectedIndex() );
            }
        } );
        mainFrame.getContentPane().add( layerList ,BorderLayout.PAGE_END);
        mainFrame.getContentPane().add( layeredPane, BorderLayout.PAGE_START);
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.setSize( 400,400 );
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    JLabel createLabel(int i,Color color){
        JLabel label = new JLabel ( ""+i);
        label.setOpaque( true );
        label.setBounds( i*60,i*60,140,140 );
        label.setBackground( color );
        return label;
    }
    public static void main(String[] args)
    {
        new JLayeredPaneDemo();
    }
}
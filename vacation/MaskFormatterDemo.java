import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
class  MaskFormatterDemo
{
    JFrame mainFrame;
    JFormattedTextField simpleFormattedTextField;
    MaskFormatter mask;
    public MaskFormatterDemo(){
        mainFrame = new JFrame ( "MaskFormatterDemo" );
        try{
            mask = new MaskFormatter("####");
            simpleFormattedTextField = new JFormattedTextField( mask );
            mainFrame.getContentPane().add( simpleFormattedTextField );
        }catch( ParseException e ){
            e.printStackTrace();
        }
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainFrame.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    public static void main(String[] args)
    {
        new MaskFormatterDemo();
    }
}
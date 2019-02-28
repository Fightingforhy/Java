import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
class JColorChooserCustomDemo
{
    JFrame mainFrame;
    JColorChooser simpleColorChooserCustom;
    JLabel sampleLabel;
    public JColorChooserCustomDemo() {
        mainFrame = new JFrame ( "JColorChooserCustomDemo" );
        sampleLabel = new JLabel ("sample");
        simpleColorChooserCustom = new JColorChooser();
        simpleColorChooserCustom.getSelectionModel().addChangeListener( new ChangeListener(){
            public void stateChanged( ChangeEvent e ){
                sampleLabel.setForeground( simpleColorChooserCustom.getColor() );
            }
        });
        AbstractColorChooserPanel accps[] = { new CustomColorChooserPanel(),
                new CustomColorChooserPanel()};
        simpleColorChooserCustom.setChooserPanels(accps);
        mainFrame.getContentPane().add( simpleColorChooserCustom,BorderLayout.PAGE_START );
        mainFrame.getContentPane().add( sampleLabel,BorderLayout.PAGE_END );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainFrame.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    class CustomColorChooserPanel extends AbstractColorChooserPanel implements ActionListener{
        JButton redButton;
        JButton greenButton;
        JButton blueButton;
        public CustomColorChooserPanel(){
            this.redButton = new JButton("red");
            this.greenButton = new JButton("green");
            this.blueButton = new JButton("blue");
            redButton.addActionListener(this);
            greenButton.addActionListener(this);
            blueButton.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae) {
            if((JButton)ae.getSource() == redButton){
                getColorSelectionModel().setSelectedColor(Color.red);
            }else{
                if((JButton)ae.getSource() == greenButton){
                    getColorSelectionModel().setSelectedColor(Color.green);
                }
                else{
                    getColorSelectionModel().setSelectedColor(Color.blue);
                }
            }
        }
        public void buildChooser(){
            add(redButton);
            add(greenButton);
            add(blueButton);
        }
        public void updateChooser(){}
        public String getDisplayName(){
            return "CustomPanel";
        }
        public Icon getSmallDisplayIcon() {
            return null;
        }
        public Icon getLargeDisplayIcon() {
            return null;
        }
    }
    public static void main(String[] args)
    {
        new JColorChooserCustomDemo();
    }
}
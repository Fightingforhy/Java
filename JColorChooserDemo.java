import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

//一个颜色选择器

class JColorChooserDemo{
    JFrame frame;
    JColorChooser colorChooser;
    JLabel label;
    public JColorChooserDemo(){
        frame=new JFrame("JColorChooserDemo");
        label=new JLabel("sample");
        colorChooser=new JColorChooser();
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setForeground(colorChooser.getColor());
            }
        });
        frame.getContentPane().add(colorChooser,BorderLayout.PAGE_START);
        frame.getContentPane().add(colorChooser,BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new JColorChooserDemo();
    }
}
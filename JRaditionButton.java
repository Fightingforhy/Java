import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//单选按钮，要用到ButtonGroup，添加到同一个ButtonGroup的单选按钮表示在它们之间只可选其一，
//不同ButtonGroup里的单选按钮相互之间的选择不受影响
class JRadioBUttonDemo implements ItemListener{
    JFrame frame;
    JPanel panel;
    ButtonGroup buttonGroup;
    JRadioButton radioButton1;
    JRadioButton radioButton2;
    public JRadioBUttonDemo(){
        frame=new JFrame("JRadioButtonDemo");
        panel=new JPanel();
        radioButton1=new JRadioButton("RadioButton1");
        radioButton1.setMnemonic('1');
        radioButton1.addItemListener(this);
        radioButton2=new JRadioButton("RadioButton2");
        radioButton2.setMnemonic('2');
        radioButton2.addItemListener(this);
        buttonGroup=new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        panel.add(radioButton1);
        panel.add(radioButton2);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e){
        JRadioButton cb=(JRadioButton)e.getSource();
        if(cb==radioButton1){
            System.out.println("RadioButton1");
        }else {
            System.out.println("RadioButton2");
        }
    }
    public static void main(String [] args){
        new JRadioBUttonDemo();
    }
}
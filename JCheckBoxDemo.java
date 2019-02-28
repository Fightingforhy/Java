import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//复选框
class JCheckBoxDemo implements ItemListener{
    JFrame frame;
    JPanel panel;
    JCheckBox checkBox1;
    JCheckBox checkBox2;
    public JCheckBoxDemo(){
        frame=new JFrame("JCheckBoxDemo");
        panel=new JPanel();
        checkBox1=new JCheckBox("checkbox1");
        checkBox1.setMnemonic('1');
        checkBox1.addItemListener(this);
        checkBox2=new JCheckBox("checkbox2");
        checkBox2.setMnemonic('2');
        checkBox2.addItemListener(this);
        panel.add(checkBox1);
        panel.add(checkBox2);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void itemStateChanged(ItemEvent e){
        JCheckBox cb=(JCheckBox)e.getSource();
        if(cb==checkBox1){
            System.out.println("CheckBox1");
        }
        else{
            System.out.println("CheckBox2");
        }
    }
    public static void main(String [] args){
        new JCheckBoxDemo();
    }
}
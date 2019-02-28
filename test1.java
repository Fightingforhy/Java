import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.*;

class TestSelectDemo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new TestSelectFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(300,300);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
class TestSelectFrame extends JFrame {
    public TestSelectFrame(){
        setTitle("测试单选按钮、复选框和下拉列表");
        setSize(400,100);
        TestSelectPanel tsp  =new TestSelectPanel();
        add(tsp);
    }
}
class TestSelectPanel extends JPanel{
    public TestSelectPanel(){
        JCheckBox jcb1 = new JCheckBox("Java");
        JCheckBox jcb2 = new JCheckBox("#");
        JCheckBox jcb3 = new JCheckBox("C++");
        add(jcb1);
        add(jcb2);
        add(jcb3);

        ButtonGroup group = new ButtonGroup();
        JRadioButton b1= new JRadioButton("男");
        JRadioButton b2= new JRadioButton("女");
        group.add(b1);
        group.add(b2);
        add(b1);
        add(b2);
        JComboBox jcb = new JComboBox();
        jcb.addItem("计算机");
        jcb.addItem("医学");
        jcb.addItem("英语");
        add(jcb);
    }

}
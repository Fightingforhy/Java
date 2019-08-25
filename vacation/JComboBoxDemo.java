import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//组合框
class JComboBoxDemo{
    JFrame frame;
    JComboBox comboBox;
    public JComboBoxDemo(){
        frame=new JFrame("JComboBoxdemo");
        Vector<String> cbData=new Vector<String>();
        cbData.add("images/Pig.gif");
        cbData.add("images/Bird.gif");
        cbData.add("images/Dog.gif");
        cbData.add("images/Cat.gif");
        comboBox=new JComboBox(cbData);
        comboBox.setPreferredSize(new Dimension(200,130));
        comboBox.setMaximumRowCount(2);
        comboBox.setRenderer(new CustomComboBoxRenderer());
        frame.getContentPane().add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("selection changed");
                System.out.println(comboBox.getSelectedItem());
            }
        });
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JComboBoxDemo();
    }
    class CustomComboBoxRenderer extends JLabel implements ListCellRenderer{
        CustomComboBoxRenderer(){
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }
        public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
            if(isSelected){
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            }else{
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            String imageFileName=(String)value;
            ImageIcon labellcon=new ImageIcon(imageFileName);
            setText(imageFileName.substring(imageFileName.lastIndexOf('/')+1));
            setIcon(labellcon);
            return this;
        }
    }
}
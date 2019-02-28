import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

class JListCustomDemo{
    JFrame frame;
    JList list;
    public JListCustomDemo(){
        frame=new JFrame("JListCustomDemo");

        final DefaultListModel model=new DefaultListModel();
        model.addElement("button1");
        model.addElement("button2");
        list=new JList(model);
        list.setCellRenderer(new CustomListCellRenderer());

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(model.getElementAt(list.getSelectedIndex()));
            }
        });
        frame.add(list);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,500);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JListCustomDemo();
    }
}
class CustomListCellRenderer implements ListCellRenderer{
    public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
        return new JButton((String)value);
    }
}
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class JListDemo{
    JFrame frame;
    JList list;
    JButton changeSelections;
    public JListDemo(){
        frame=new JFrame("JListDemo");
        /*Vector<String> listData=new Vector<String>();
        listData.add("data1");
        listData.add("data2");
        listData.add("data3");
        listData.add("data4");
        list=new JList(listData);
         */

        DefaultListModel dlm=new DefaultListModel();
        dlm.addElement("data1");
        dlm.addElement("data2");
        dlm.addElement("data3");
        dlm.addElement("data4");
        list=new JList(dlm);
        changeSelections=new JButton("changeSelections");
        changeSelections.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListSelectionModel dlsm=(DefaultListSelectionModel)list.getSelectionModel();
                //dlsm.addSelectionInterval(0,1);
                //dlsm.removeSelectionInterval(0,1);
                ((DefaultListSelectionModel) dlsm).removeSelectionInterval(0,1);
                /*DefaultListModel dlm=(DefaultListModel)list.getModel();
                dlm.remove(0);
                dlm.remove(1);
                 */
            }
        });
        frame.getContentPane().add(list,BorderLayout.PAGE_START);
        frame.getContentPane().add(changeSelections,BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JListDemo();
    }
}
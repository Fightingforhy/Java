import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JScrollPaneDemo{
    JFrame frame;
    JScrollPane scrollPane;
    JTextArea textArea;
    JButton button;
    public JScrollPaneDemo(){
        frame=new JFrame("JScrollPaneDemo");
        textArea=new JTextArea(10,20);
        scrollPane=new JScrollPane(textArea);//创建一个滚动窗格，里面显示的内容是文本区域
        scrollPane.setRowHeaderView(new JLabel("this is a column header"));//设置行标题
        scrollPane.setColumnHeaderView(new JLabel("this is a column header"));//设置列标题
        scrollPane.setCorner(JScrollPane.LOWER_LEADING_CORNER,new JButton("corner"));//设置右下角
        scrollPane.setCorner(JScrollPane.UPPER_LEADING_CORNER,new JButton("corner"));//设置左上角
        button=new JButton("button");
        button.addActionListener(new ActionListener() { //当单选按钮时，滚动窗口显示的内容变为另一个文本区域
            @Override
            public void actionPerformed(ActionEvent e) {
                scrollPane.getViewport().setView(new JTextArea("button"));
            }
        });
        frame.getContentPane().add(scrollPane,BorderLayout.PAGE_START);
        frame.getContentPane().add(button,BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JScrollPaneDemo();
    }
}
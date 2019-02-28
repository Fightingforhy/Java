import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//文本区域，多行的
class JTextAreaDemo{
    JFrame frame;
    JTextArea textArea;
    JButton button;
    public  JTextAreaDemo(){
        frame=new JFrame("JTextAreaDemo");
        textArea=new JTextArea(10,20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        button=new JButton("append text to the text area");
        frame.getContentPane().add(textArea,BorderLayout.PAGE_START);
        frame.getContentPane().add(button,BorderLayout.PAGE_END);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("button appended text here");
                System.out.println(textArea.getText());
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JTextFieldDemo();
    }
}
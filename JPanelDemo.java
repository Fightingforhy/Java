import javax.swing.*;

class JPanelDemo{
    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel label;
    public JPanelDemo(){
        frame=new JFrame("JPanelDemo");
        panel=new JPanel();
        button=new JButton("button");
        label=new JLabel("label");
        panel.add(label);
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        new JPanelDemo();
    }
}
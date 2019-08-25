import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
//进度条，表示任务的完成进度
class SwingWorkerTest
{
    JFrame mainFrame;
    JPanel mainPanel;
    JButton button;
    JButton getButton;
    public SwingWorkerTest() {
        mainFrame = new JFrame (  );
        mainPanel = new JPanel ();
        final javax.swing.SwingWorker<Integer,Integer> worker =
                new javax.swing.SwingWorker<Integer,Integer>(){
                    public Integer doInBackground(){
                        int coutn = 0;
                        while( (coutn++)<10 ){
                            try{
                                System.out.println( "doInBackground() is doing a long job" );
                                Thread.sleep(1000);
                                publish( new Integer( (int)(Math.random()*1000) ) );
                            }catch( InterruptedException e ){
                                e.printStackTrace();
                            }
                        }
                        return new Integer(3);
                    }
                    @Override
                    public void process(List<Integer> integers){
                        int i = 0;
                        Iterator iterator = integers.iterator();
                        while( iterator.hasNext() ){
                            i++;
                            Integer integer = (Integer)iterator.next();
                            System.out.println( "在process输出publish的值"+i+"   "+integer );
                        }
                    }
                };
        button = new JButton ("start");
        button.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
                worker.execute();
            }
        });
        getButton = new JButton ("Get");
        getButton.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
                try{
                    System.out.println( "doInBackground的返回值: "+worker.get() );
                }catch( InterruptedException ie ){
                    ie.printStackTrace();
                }catch( ExecutionException ee ){
                    ee.printStackTrace();
                }
            }
        });
        mainPanel.add(button);
        mainPanel.add(getButton);
        mainFrame.getContentPane().add( mainPanel );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainFrame.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    public static void main(String[] args)
    {
        new SwingWorkerTest();
    }
}
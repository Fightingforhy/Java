import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.beans.*;
//显示进度在对话框里
class ProgressMonitorDemo
{
    JFrame mainFrame;
    ProgressMonitor simpleProgressMonitor;
    JButton startButton;
    Worker worker;
    public ProgressMonitorDemo() {
        mainFrame = new JFrame ( "ProgressMonitorDemo" );
        startButton = new JButton ("Start");
        startButton.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e){
                simpleProgressMonitor = new ProgressMonitor(mainFrame,"正在执行任务","",0,100);
                simpleProgressMonitor.setMillisToDecideToPopup(0);
                simpleProgressMonitor.setMillisToPopup(0);
                worker = new Worker();
                worker.addPropertyChangeListener( new PropertyChangeListener(){
                    public void propertyChange( PropertyChangeEvent e ){
                        if( "progress".equals( e.getPropertyName() )){
                            int progress = (Integer)e.getNewValue();
                            simpleProgressMonitor.setProgress( progress );
                            String message = String.format("%d%% completed",progress);
                            simpleProgressMonitor.setNote(message);
                        }
                    }
                });
                worker.execute();
                startButton.setEnabled(false);
            }
        } );
        mainFrame.getContentPane().add( startButton,BorderLayout.LINE_START );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainFrame.setSize(300,300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }

    public static void main(String[] args)
    {
        new ProgressMonitorDemo();
    }
    class Worker extends javax.swing.SwingWorker<Void,Void>{
        public Void doInBackground(){
            int progress = 0;
            Random r = new Random();
            while( progress<=100 && !isCancelled() ){
                progress += r.nextInt(10);
                setProgress( Math.min(progress,100) );
                try{
                    Thread.sleep( r.nextInt(1000) );
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
            return null;
        }
        public void done(){
            startButton.setEnabled(true);
        }
    }
}
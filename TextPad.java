import java.awt.*;
import java.awt.event.*;

import java.io.*;

import javax.swing.*;


import java.util.*;
public class TextPad extends JFrame implements ActionListener
{

    //定义一个面板
    //JPanel jp =null;
    JTextArea jta =null;


    //定义菜单条
    JMenuBar jmb=null;
    //定义菜单
    JMenu jm1 =null;
    //定义菜单选项
    JMenuItem jmi1=null;
    JMenuItem jmi2=null;
    JMenuItem jmi3=null;
    JMenuItem jmi4 =null;
    ArrayList<JMenuItem> arraylistOfItem=null;//为菜单项创建集合列表
    File CurFileName=null;//保存当前打开文件的文件目录

    public File getCurFileName() {
        return CurFileName;
    }
    public void setCurFileName(File curFileName) {
        CurFileName = curFileName;
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        TextPad t =new TextPad();
    }
    //构造函数
    public TextPad()
    {
        //创建一个面板
        //jp =new JPanel();
        //创建多文本行的文本域
        jta=new JTextArea();
        jta.setRows(20);
        jta.setColumns(20);
        jta.setText(null);
        jta.setFont( new Font(null,10, 22));
        JScrollPane scroll=new JScrollPane();
        scroll.setViewportView(jta);

        arraylistOfItem =new ArrayList<JMenuItem>();
        //创建一个菜单条
        jmb =new JMenuBar();
        //创建一个菜单
        jm1 =new JMenu("文件");
        jm1.setMnemonic('F');
        //创建 菜单选项
        jmi1=new JMenuItem("打开", new ImageIcon("images/open-sign-128.png"));
        jmi1.setMnemonic('O');
        jmi1.addActionListener(this);;
        jmi1.setActionCommand("打开");
        arraylistOfItem.add(jmi1);

        jmi2=new JMenuItem("保存");
        jmi2.setMnemonic('S');
        jmi2.addActionListener(this);
        jmi2.setActionCommand("保存");
        arraylistOfItem.add(jmi2);
        jmi2.setIcon(new ImageIcon("images/128_save.png"));

        jmi4 =new JMenuItem("另存为");
        jmi4.setMnemonic('D');
        jmi4.addActionListener(this);
        jmi4.setActionCommand("另存为");
        arraylistOfItem.add(jmi4);
        jmi4.setIcon(new ImageIcon("images/48_save_as.png"));

        jmi3 =new JMenuItem("退出");
        jmi3.setIcon(new ImageIcon("images/128_exit.png"));
        arraylistOfItem.add(jmi3);
        jmi3.addActionListener(this);
        jmi3.setActionCommand("退出");

        //jp.setLayout(new BorderLayout());
        //jp.setBackground(Color.lightGray);

        //组件加进面板组件里面
        //jp.add(jta,BorderLayout.CENTER);


        //设置窗体布局管理器
        this.getContentPane().setLayout(new BorderLayout());


        //面板加入窗体容器，
        //this.add(jp,BorderLayout.CENTER);
        this.add(scroll, BorderLayout.CENTER);

        this.setJMenuBar(jmb);
        jmb.add(jm1 );
        for(int i=0; i<arraylistOfItem.size(); i++)
        {
            jm1.add(arraylistOfItem.get(i));
        }

        //设置窗体的大小属性
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(new Point(400,200));
        this.setResizable(false);




    }


    /**
     * @author pengrong
     * @功能：打开一个文件；并读取这个文件内容到文本域
     * @Version 1.0
     */
    public void openFileToTextArea()
    {
        //JFileChooser

        //System.out.println("我爱你啊");
        File fileName=null;
        JFileChooser jfc=new JFileChooser();
        //设置打开文件对话框的标题
        jfc.setDialogTitle("请选择文件");
        //默认方式打开对话框，返回一个int的整数
        int returnVal = jfc.showOpenDialog(null);
        jfc.setVisible(true);

        if(JFileChooser.APPROVE_OPTION ==returnVal)
        {
            //得到用户选择的文件全路径
            fileName=jfc.getSelectedFile().getAbsoluteFile();
            this.setCurFileName(fileName);
            System.out.println("文件路径是"+fileName.getAbsolutePath());
            this.readFile(fileName,jta);

        }
        else if(returnVal == JFileChooser.ERROR_OPTION)
        {
            System.out.println("选择文件有错");
            return;
        }
        else if(returnVal == JFileChooser.CANCEL_OPTION)
        {
            System.out.println("退出文件选择框");
            return;
        }






    }
    /**
     * @author pengrong
     * @param fileName 文件目录
     * @param jta 文本域引用
     * @功能：根据一个指定的文件目录，将文件里面的信息输出到文本域里面
     */
    public void readFile(File fileName, JTextArea jta)
    {
        if( (fileName ==null) || (!fileName.exists()) || (jta ==null) )
        {
            return;
        }
        //FileReader fr=null;
        InputStreamReader read =null;
        BufferedReader br =null;
        //http://bbs.csdn.net/topics/390675453

        //下面是读取文件字符的处理逻辑

        try
        {
            //选则BufferedReader作为输入流的类
            read =new InputStreamReader(new FileInputStream(fileName));
            //fr =new FileReader(fileName);
            br =new BufferedReader(read);

            String s=null;
            //String strcon=null;

            while ((s=br.readLine()) !=null)
            {
                //System.out.println(s+"\r\n");
                jta.append(s+"\r\n");
            }
            //jta.setText(strcon);

        } catch (Exception e2)
        {
            e2.printStackTrace( );
            // TODO: handle exception
        }
        finally
        {
            try {
                read.close();
                br.close();
            } catch (IOException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

        String actionCommand = e.getActionCommand();
        switch (actionCommand)
        {
            case "打开":
                this.openFileToTextArea();
                break;

            case "保存" :
                this.saveFile(this.getCurFileName());
                break;

            case "退出" :
                this.saveFile(this.getCurFileName());
                System.exit(0);
                break;

            case "另存为" :
                this.saveAs();
                break;

            default:
                break;
        }

    }

    /**
     * @author pengrong
     * @param file 文件目录
     * @功能：将文件保存到一个指定的文件目录
     */
    public void saveFile(File file)
    {
//      file =this.getCurFileName();
        //准备写入到指定文件即可
        if ( (file ==null)   )
        {
            return;
        }

        //如果文件不存在，则创建
        if ( !file.exists() )
        {
            //file.getParentFile();
            try
            {
                file.createNewFile();
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (!file.isFile()) {
            return;

        }

        FileWriter fw =null;
        BufferedWriter bw =null;

        try
        {
            fw=new FileWriter(file);
            bw=new BufferedWriter(fw);
            //获取jta文本，并用\n分隔符分割文本
            String[] s =this.jta.getText().split("\n");
            for (int i = 0; i < s.length; i++) {
                bw.write(s[i] +"\r\n");
                bw.flush();
                //bw.newLine();
            }


        } catch (Exception e)
        {
            e.printStackTrace( );
            // TODO: handle exception
        }
        finally
        {
            try
            {
                //这里关闭流要从大到小关闭
//              fw.close(); //这样的顺序就是不行，fw流自己关闭了。然后bw流又把fw流关闭一次就会说java.io.IOException: Stream closed
//              bw.close();
                bw.close();
                fw.close();

            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }

    /**
     * @author pengrong
     * @功能：将文件另存为
     */
    public void saveAs()
    {
        //另存的文件目录
        File saveAsFileName =null;

        JFileChooser jfc =new JFileChooser();
        jfc.setDialogTitle("另存为");

        int resultVal = jfc.showSaveDialog(null);
        jfc.setVisible(true);
        switch (resultVal)
        {
            case JFileChooser.APPROVE_OPTION:
                saveAsFileName=jfc.getSelectedFile().getAbsoluteFile();

                System.out.println("保存文件的路径是"+saveAsFileName.getAbsolutePath());
                this.saveFile(saveAsFileName);
                break;
            case JFileChooser.CANCEL_OPTION :
                System.out.println("退出保存文件选择框");

                break;
            case JFileChooser.ERROR_OPTION:
                System.out.println("保存文件出错");
                break;
            default:
                break;
        }

    }

}
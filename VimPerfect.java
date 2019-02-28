import com.sun.jmx.mbeanserver.JmxMBeanServer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;

class MyVimGui extends JFrame implements ActionListener{
    boolean judge = false;
    int pos, col, row, setPosition;
    JTextArea textArea;
    JTextField textField;
    File CurFileName = new File("D:\\test\\ha.txt"); //默认保存路径
    JMenuItem menuItem14;//=new JMenuItem("新建(N)");

    JMenuItem menuItem15;//=new JMenuItem("关闭(C)");

    JMenuItem menuItem16;//=new JMenuItem("保存(S)");

    JMenuItem menuItem17;//=new JMenuItem("另存为(A)...");
//返回保存路径
    public File getCurFileName() {
        return CurFileName;
    }
//设置保存路径
    public void setCurFileName(File curFileName) {
        CurFileName = curFileName;
    }
//构造函数
    MyVimGui(){
        judge = false;

        //int a, b;
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);//添加菜单栏，自动放在最上方
        textArea = new JTextArea();
        textArea.setTabSize(9);//设置Tab键跳转大小
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.addKeyListener(new KeyListenerTest1());
        textField = new JTextField();
        textField.setEditable(true);
        Runnable threadJob = new MyRunnable1();
        Thread thread = new Thread(threadJob);
        if (textArea.getText() != null) {
            thread.start();
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(textArea);
        this.getContentPane().setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(BorderLayout.SOUTH, textField);

//总菜单
        JMenu Menu1=new JMenu("文件(F)");
        Menu1.setMnemonic('F');
        JMenu Menu2=new JMenu("编辑(E)");
        Menu2.setMnemonic('E');
        JMenu Menu3=new JMenu("工具(T)");
        Menu3.setMnemonic('T');
        JMenu Menu4=new JMenu("语法(S)");
        Menu4.setMnemonic('S');
        JMenu Menu5=new JMenu("缓冲区(B)");
        Menu5.setMnemonic('B');
        JMenu Menu6=new JMenu("窗口(W)");
        Menu6.setMnemonic('W');
        JMenu Menu7=new JMenu("帮助(H)");
        Menu7.setMnemonic('H');
        menuBar.add(Menu1);
        menuBar.add(Menu2);
        menuBar.add(Menu3);
        menuBar.add(Menu4);
        menuBar.add(Menu5);
        menuBar.add(Menu6);
        menuBar.add(Menu7);
//第一个菜单
        JMenuItem menuItem11 = new JMenuItem("打开(O)");
        menuItem11.setMnemonic('O');
        JMenuItem menuItem12 = new JMenuItem("分割并打开(L)...");
        menuItem12.setMnemonic('L');
        JMenuItem menuItem13=new JMenuItem("打开标签...");
        JMenuItem menuItem14=new JMenuItem("新建(N)");
        menuItem14.setMnemonic('N');
        JMenuItem menuItem15=new JMenuItem("关闭(C)");
        menuItem15.setMnemonic('C');
        JMenuItem menuItem16=new JMenuItem("保存(S)");
        menuItem16.setMnemonic('S');
        JMenuItem menuItem17=new JMenuItem("另存为(A)...");
        menuItem17.setMnemonic('A');
        JMenuItem menuItem18=new JMenuItem("分割比较(Diff)(D)...");
        menuItem18.setMnemonic('D');
        JMenuItem menuItem19= new JMenuItem("分割打补丁(Patch)(B)...");
        menuItem19.setMnemonic('B');
        JMenuItem menuItem110=new JMenuItem("打印(P)");
        menuItem110.setMnemonic('P');
        JMenuItem menuItem111=new JMenuItem("保存并退出(V)");
        menuItem111.setMnemonic('V');
        JMenuItem menuItem112=new JMenuItem("退出(X)");
        menuItem112.setMnemonic('X');

        Menu1.addSeparator();
        Menu1.add(menuItem11);
        Menu1.add(menuItem12);
        Menu1.add(menuItem13);
        Menu1.add(menuItem14);
        Menu1.add(menuItem15);
        Menu1.add(menuItem16);
        Menu1.add(menuItem17);
        Menu1.add(menuItem18);
        Menu1.add(menuItem19);
        Menu1.add(menuItem110);
        Menu1.add(menuItem111);
        Menu1.add(menuItem112);

        menuItem11.addActionListener(this);
        menuItem12.addActionListener(this);
        menuItem13.addActionListener(this);
        menuItem14.addActionListener(this);
        menuItem15.addActionListener(this);
        menuItem16.addActionListener(this);
        menuItem17.addActionListener(this);
        menuItem18.addActionListener(this);
        menuItem19.addActionListener(this);
        menuItem110.addActionListener(this);
        menuItem111.addActionListener(this);
        menuItem112.addActionListener(this);
//第二个菜单
        JMenuItem menuItem21 = new JMenuItem("撤销(U)");
        menuItem21.setMnemonic('U');
        JMenuItem menuItem22 = new JMenuItem("重做(R)...");
        menuItem22.setMnemonic('R');
        JMenuItem menuItem23=new JMenuItem("重复上次操作(E)");
        menuItem23.setMnemonic('E');
        JMenuItem menuItem24=new JMenuItem("剪切(T)");
        menuItem24.setMnemonic('T');
        JMenuItem menuItem25=new JMenuItem("复制(C)");
        menuItem25.setMnemonic('C');
        JMenuItem menuItem26=new JMenuItem("粘贴(P)");
        menuItem26.setMnemonic('P');
        JMenuItem menuItem27=new JMenuItem("粘贴到光标前(B)");
        menuItem27.setMnemonic('B');
        JMenuItem menuItem28=new JMenuItem("粘贴到光标后(A)");
        menuItem28.setMnemonic('A');
        JMenuItem menuItem29= new JMenuItem("删除(D)...");
        menuItem29.setMnemonic('D');
        JMenuItem menuItem210=new JMenuItem("全选(S)");
        menuItem210.setMnemonic('S');
        JMenuItem menuItem211=new JMenuItem("查找(F)...");
        menuItem211.setMnemonic('F');
        JMenuItem menuItem212=new JMenuItem("查找和替换(L)...");
        menuItem212.setMnemonic('L');
        JMenuItem menuItem213 = new JMenuItem("设定窗口(W)");
        menuItem213.setMnemonic('W');
        JMenuItem menuItem214 = new JMenuItem("启动设定(S)");
        menuItem214.setMnemonic('S');
        JMenuItem menuItem215 = new JMenuItem("全局设定(G)");
        menuItem215.setMnemonic('G');
        JMenuItem menuItem216 = new JMenuItem("文件设定(I)");
        menuItem216.setMnemonic('I');
        JMenuItem menuItem217 = new JMenuItem("配色方案(O)");
        menuItem217.setMnemonic('O');
        JMenuItem menuItem218 = new JMenuItem("键盘映射(K)");
        menuItem218.setMnemonic('K');
        JMenuItem menuItem219 = new JMenuItem("选择字体(N)...");
        menuItem219.setMnemonic('N');


        Menu2.addSeparator();
        Menu2.add(menuItem21);
        Menu2.add(menuItem22);
        Menu2.add(menuItem23);
        Menu2.add(menuItem24);
        Menu2.add(menuItem25);
        Menu2.add(menuItem26);
        Menu2.add(menuItem27);
        Menu2.add(menuItem28);
        Menu2.add(menuItem29);
        Menu2.add(menuItem210);
        Menu2.add(menuItem211);
        Menu2.add(menuItem212);
        Menu2.add(menuItem213);
        Menu2.add(menuItem214);
        Menu2.add(menuItem215);
        Menu2.add(menuItem216);
        Menu2.add(menuItem217);
        Menu2.add(menuItem218);
        Menu2.add(menuItem219);

        menuItem21.addActionListener(this);
        menuItem22.addActionListener(this);
        menuItem23.addActionListener(this);
        menuItem24.addActionListener(this);
        menuItem25.addActionListener(this);
        menuItem26.addActionListener(this);
        menuItem27.addActionListener(this);
        menuItem28.addActionListener(this);
        menuItem29.addActionListener(this);
        menuItem210.addActionListener(this);
        menuItem211.addActionListener(this);
        menuItem212.addActionListener(this);
        menuItem213.addActionListener(this);
        menuItem214.addActionListener(this);
        menuItem215.addActionListener(this);
        menuItem216.addActionListener(this);
        menuItem217.addActionListener(this);
        menuItem218.addActionListener(this);
        menuItem219.addActionListener(this);
//第三个菜单
        JMenuItem menuItem31 = new JMenuItem("跳转到这个tag(J)");
        menuItem31.setMnemonic('J');
        JMenuItem menuItem32 = new JMenuItem("跳转返回(B)");
        menuItem32.setMnemonic('B');
        JMenuItem menuItem33=new JMenuItem("建立Tags文件(T)");
        menuItem33.setMnemonic('T');
        JMenuItem menuItem34=new JMenuItem("拼写检查(S)");
        menuItem34.setMnemonic('S');
        JMenuItem menuItem35=new JMenuItem("折叠(F)");
        menuItem35.setMnemonic('F');
        JMenuItem menuItem36=new JMenuItem("比较(Diff)(D)");
        menuItem36.setMnemonic('D');
        JMenuItem menuItem37=new JMenuItem("Make(M)");
        menuItem37.setMnemonic('M');
        JMenuItem menuItem38=new JMenuItem("列出错误(L)");
        menuItem38.setMnemonic('L');
        JMenuItem menuItem39= new JMenuItem("列出消息(I)");
        menuItem39.setMnemonic('I');
        JMenuItem menuItem310=new JMenuItem("下一个错误(N)");
        menuItem310.setMnemonic('N');
        JMenuItem menuItem311=new JMenuItem("上一个错误(P)");
        menuItem311.setMnemonic('P');
        JMenuItem menuItem312=new JMenuItem("更旧的错误列表(O)");
        menuItem312.setMnemonic('O');
        JMenuItem menuItem313 = new JMenuItem("更新的错误列表(E)");
        menuItem313.setMnemonic('E');
        JMenuItem menuItem314 = new JMenuItem("错误窗口(W)");
        menuItem314.setMnemonic('W');
        JMenuItem menuItem315 = new JMenuItem("设定编译器(T)");
        menuItem315.setMnemonic('T');
        JMenuItem menuItem316 = new JMenuItem("转换成十六进制");
        JMenuItem menuItem317 = new JMenuItem("转换返回");


        Menu3.addSeparator();
        Menu3.add(menuItem31);
        Menu3.add(menuItem32);
        Menu3.add(menuItem33);
        Menu3.add(menuItem34);
        Menu3.add(menuItem35);
        Menu3.add(menuItem36);
        Menu3.add(menuItem37);
        Menu3.add(menuItem38);
        Menu3.add(menuItem39);
        Menu3.add(menuItem310);
        Menu3.add(menuItem311);
        Menu3.add(menuItem312);
        Menu3.add(menuItem313);
        Menu3.add(menuItem314);
        Menu3.add(menuItem315);
        Menu3.add(menuItem316);
        Menu3.add(menuItem317);

        menuItem31.addActionListener(this);
        menuItem32.addActionListener(this);
        menuItem33.addActionListener(this);
        menuItem34.addActionListener(this);
        menuItem35.addActionListener(this);
        menuItem36.addActionListener(this);
        menuItem37.addActionListener(this);
        menuItem38.addActionListener(this);
        menuItem39.addActionListener(this);
        menuItem310.addActionListener(this);
        menuItem311.addActionListener(this);
        menuItem312.addActionListener(this);
        menuItem313.addActionListener(this);
        menuItem314.addActionListener(this);
        menuItem315.addActionListener(this);
        menuItem316.addActionListener(this);
        menuItem317.addActionListener(this);

//第四个菜单
        JMenuItem menuItem41 = new JMenuItem("在菜单中显示文件类型(S)");
        menuItem41.setMnemonic('S');
        JMenuItem menuItem42 = new JMenuItem("关闭(O)");
        menuItem41.setMnemonic('O');
        JMenuItem menuItem43=new JMenuItem("手工(M)");
        menuItem43.setMnemonic('M');
        JMenuItem menuItem44=new JMenuItem("自动(U)");
        menuItem44.setMnemonic('U');
        JMenuItem menuItem45=new JMenuItem("仅对这个文件开/关(T)");
        menuItem45.setMnemonic('T');
        JMenuItem menuItem46=new JMenuItem("色彩测试(L)");
        menuItem46.setMnemonic('L');
        JMenuItem menuItem47=new JMenuItem("高亮测试(H)");
        menuItem47.setMnemonic('H');
        JMenuItem menuItem48=new JMenuItem("转换成HTML(C)");
        menuItem48.setMnemonic('C');

        Menu4.addSeparator();
        Menu4.add(menuItem41);
        Menu4.add(menuItem42);
        Menu4.add(menuItem43);
        Menu4.add(menuItem44);
        Menu4.add(menuItem45);
        Menu4.add(menuItem46);
        Menu4.add(menuItem47);
        Menu4.add(menuItem48);

        menuItem41.addActionListener(this);
        menuItem42.addActionListener(this);
        menuItem43.addActionListener(this);
        menuItem44.addActionListener(this);
        menuItem45.addActionListener(this);
        menuItem46.addActionListener(this);
        menuItem47.addActionListener(this);
        menuItem48.addActionListener(this);
//第五个菜单
        JMenuItem menuItem51 = new JMenuItem("更新菜单(R)");
        menuItem51.setMnemonic('R');
        JMenuItem menuItem52 = new JMenuItem("删除(D)");
        menuItem52.setMnemonic('D');
        JMenuItem menuItem53=new JMenuItem("交替(A)");
        menuItem53.setMnemonic('A');
        JMenuItem menuItem54=new JMenuItem("下一个(N)");
        menuItem54.setMnemonic('N');
        JMenuItem menuItem55=new JMenuItem("上一个(P)");
        menuItem55.setMnemonic('P');
        JMenuItem menuItem56=new JMenuItem("[No file](1)");
        menuItem56.setMnemonic('1');

        Menu5.addSeparator();
        Menu5.add(menuItem51);
        Menu5.add(menuItem52);
        Menu5.add(menuItem53);
        Menu5.add(menuItem54);
        Menu5.add(menuItem55);
        Menu5.add(menuItem56);

        menuItem51.addActionListener(this);
        menuItem52.addActionListener(this);
        menuItem53.addActionListener(this);
        menuItem54.addActionListener(this);
        menuItem55.addActionListener(this);
        menuItem56.addActionListener(this);
//第六个菜单
        JMenuItem menuItem61 = new JMenuItem("新建(N)");
        menuItem61.setMnemonic('N');
        JMenuItem menuItem62 = new JMenuItem("分割(P)");
        menuItem62.setMnemonic('P');
        JMenuItem menuItem63=new JMenuItem("分割到#(L)");
        menuItem63.setMnemonic('L');
        JMenuItem menuItem64=new JMenuItem("垂直分割(V)");
        menuItem64.setMnemonic('V');
        JMenuItem menuItem65=new JMenuItem("分割文件浏览器(X)");
        menuItem65.setMnemonic('X');
        JMenuItem menuItem66=new JMenuItem("关闭(C)");
        menuItem66.setMnemonic('C');
        JMenuItem menuItem67=new JMenuItem("关闭其他窗口(O)");
        menuItem67.setMnemonic('O');
        JMenuItem menuItem68=new JMenuItem("移动到(T)");
        menuItem68.setMnemonic('T');
        JMenuItem menuItem69= new JMenuItem("向上轮换(U)");
        menuItem69.setMnemonic('U');
        JMenuItem menuItem610=new JMenuItem("向下轮换(D)");
        menuItem610.setMnemonic('D');
        JMenuItem menuItem611=new JMenuItem("等大(E)");
        menuItem611.setMnemonic('E');
        JMenuItem menuItem612=new JMenuItem("最大高度(M)");
        menuItem612.setMnemonic('M');
        JMenuItem menuItem613 = new JMenuItem("最小高度(I)");
        menuItem613.setMnemonic('I');
        JMenuItem menuItem614 = new JMenuItem("最大宽度(W)");
        menuItem614.setMnemonic('W');
        JMenuItem menuItem615 = new JMenuItem("最小宽度(H)");
        menuItem615.setMnemonic('H');

        Menu6.addSeparator();
        Menu6.add(menuItem61);
        Menu6.add(menuItem62);
        Menu6.add(menuItem63);
        Menu6.add(menuItem64);
        Menu6.add(menuItem65);
        Menu6.add(menuItem66);
        Menu6.add(menuItem67);
        Menu6.add(menuItem68);
        Menu6.add(menuItem69);
        Menu6.add(menuItem610);
        Menu6.add(menuItem611);
        Menu6.add(menuItem612);
        Menu6.add(menuItem613);
        Menu6.add(menuItem614);
        Menu6.add(menuItem615);

        menuItem61.addActionListener(this);
        menuItem62.addActionListener(this);
        menuItem63.addActionListener(this);
        menuItem64.addActionListener(this);
        menuItem65.addActionListener(this);
        menuItem66.addActionListener(this);
        menuItem67.addActionListener(this);
        menuItem68.addActionListener(this);
        menuItem69.addActionListener(this);
        menuItem610.addActionListener(this);
        menuItem611.addActionListener(this);
        menuItem612.addActionListener(this);
        menuItem613.addActionListener(this);
        menuItem614.addActionListener(this);
        menuItem615.addActionListener(this);
//第七个菜单
        JMenuItem menuItem71 = new JMenuItem("纵览(O)");
        menuItem71.setMnemonic('O');
        JMenuItem menuItem72 = new JMenuItem("用户手册(U)...");
        menuItem72.setMnemonic('U');
        JMenuItem menuItem73=new JMenuItem("How-to 指引(H)");
        menuItem73.setMnemonic('H');
        JMenuItem menuItem74=new JMenuItem("查找(F)...");
        menuItem74.setMnemonic('F');
        JMenuItem menuItem75=new JMenuItem("致谢(C)");
        menuItem75.setMnemonic('C');
        JMenuItem menuItem76=new JMenuItem("版权(P)");
        menuItem76.setMnemonic('P');
        JMenuItem menuItem77=new JMenuItem("赞助/注册(S)");
        menuItem77.setMnemonic('S');
        JMenuItem menuItem78=new JMenuItem("孤儿(R)");
        menuItem78.setMnemonic('R');
        JMenuItem menuItem79= new JMenuItem("版本(V)");
        menuItem79.setMnemonic('V');
        JMenuItem menuItem710=new JMenuItem("关于(A)");
        menuItem710.setMnemonic('A');

        Menu7.addSeparator();
        Menu7.add(menuItem71);
        Menu7.add(menuItem72);
        Menu7.add(menuItem73);
        Menu7.add(menuItem74);
        Menu7.add(menuItem75);
        Menu7.add(menuItem76);
        Menu7.add(menuItem77);
        Menu7.add(menuItem78);
        Menu7.add(menuItem79);
        Menu7.add(menuItem710);

        menuItem71.addActionListener(this);
        menuItem72.addActionListener(this);
        menuItem73.addActionListener(this);
        menuItem74.addActionListener(this);
        menuItem75.addActionListener(this);
        menuItem76.addActionListener(this);
        menuItem77.addActionListener(this);
        menuItem78.addActionListener(this);
        menuItem79.addActionListener(this);
        menuItem710.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        FileTest1 fileTest1=new FileTest1();
        if (e.getSource()==menuItem14){
            textArea.setText("");
        }
        if(e.getSource()==menuItem15){
            System.exit(0);
        }
        if (e.getSource()==menuItem16){
            fileTest1.saveFile(getCurFileName());
        }
        if (e.getSource()==menuItem17){
            fileTest1.saveAs();
        }
    }
    //文件操作
    public class FileTest1 {
        //保存文件
        public void saveFile(File file) {
            if (file == null) {
                return;
            }
            if (!file.exists()) {
                try {
                    boolean createResult = file.createNewFile();
                    if (createResult) {
                        System.out.println("文件创建成功");
                        System.out.println("保存文件的路径是" + file.getAbsolutePath());
                    } else {
                        System.out.println("文件创建失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("保存文件的路径是" + file.getAbsolutePath());
            }
            if (!file.isFile()) {
                return;
            }
            try {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                String[] s = textArea.getText().split("\n");
                for (int i = 0; i < s.length; i++) {
                    bw.write(s[i]);
                    bw.write("\r\n");
                    bw.flush();
                }
                fos.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //另存文件
        public void saveAs() {
            File saveAsFileName = null;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("另存为");
            int resultVal = fileChooser.showSaveDialog(null);
            fileChooser.setVisible(true);
            switch (resultVal) {
                case JFileChooser.APPROVE_OPTION:
                    saveAsFileName = fileChooser.getSelectedFile().getAbsoluteFile();
                    this.saveFile(saveAsFileName);
                    break;
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("退出保存文件选择框");
                    break;
                case JFileChooser.ERROR_OPTION:
                    System.out.println("保存文件出错");
                    break;
            }//swith语句结束
        }//saveAs方法结束
    }//类FileTest1结束

    //键盘按键监听
    public class KeyListenerTest1 implements KeyListener {
        MyVimGui.FileTest1 fileTest1 = new MyVimGui.FileTest1();
        //int a,b,c,d,e;
        int countd = 0;
        int county = 0;
        int count = 0;
        String s1 = null;
        String s2 = null;
        String copy = null;

        public void keyPressed(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
            char keyChar = e.getKeyChar();
            //切换为非编辑模式
            if (keyChar == 27 && judge == true) {
                textArea.setEditable(false);
                judge = false;
            }
            //切换为编辑模式
            if (keyChar == 'i' && judge == false) {
                textArea.setEditable(true);
                judge = true;
            }
            //非编辑模式向左移动光标
            if (keyChar == 'h' && judge == false) {
                textArea.setCaretPosition(textArea.getCaretPosition() - 1);
            }
            //非编辑模式向右移动光标
            if (keyChar == 'l' && judge == false) {
                textArea.setCaretPosition(textArea.getCaretPosition() + 1);
            }
            //非编辑模式向上移动光标
            if (keyChar == 'k' && judge == false) {
                pos = textArea.getCaretPosition();
                col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                try {
                    row = textArea.getLineOfOffset(pos) + 1;
                } catch (Exception var4) {
                }
                setPosition = 0;
                try {
                    if (textArea.getCaretPosition() - textArea.getLineStartOffset(row - 1) > textArea.getLineEndOffset(row - 2) - textArea.getLineStartOffset(row - 2) - 1) {
                        setPosition = textArea.getLineEndOffset(row - 2) - 1;
                    } else {
                        if (row - 1 == 1) {
                            setPosition = textArea.getCaretPosition() - textArea.getLineStartOffset(row - 1);
                        } else {
                            setPosition = textArea.getCaretPosition() - textArea.getLineStartOffset(row - 1) + textArea.getLineStartOffset(row - 2);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                textArea.setCaretPosition(setPosition);
            }
            //非编辑模式向下移动光标
            if (keyChar == 'j' && judge == false) {
                pos = textArea.getCaretPosition();
                col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                try {
                    row = textArea.getLineOfOffset(pos) + 1;
                } catch (Exception var4) {
                }
                setPosition = 0;
                try {
                    if (textArea.getCaretPosition() - textArea.getLineStartOffset(row - 1) > textArea.getLineEndOffset(row) - textArea.getLineStartOffset(row)) {
                        if (row == textArea.getLineCount() - 1) {
                            setPosition = textArea.getLineEndOffset(row);
                        } else {
                            setPosition = textArea.getLineEndOffset(row) - 1;
                        }
                    } else {
                        if (row == 1) {
                            setPosition = textArea.getCaretPosition() + textArea.getLineEndOffset(row - 1);
                        } else {
                            setPosition = textArea.getCaretPosition() - textArea.getLineStartOffset(row - 1) + textArea.getLineStartOffset(row);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                textArea.setCaretPosition(setPosition);
            }
            //保存文件
            if (keyChar == 'w' && judge == false) {
                fileTest1.saveFile(getCurFileName());
            }
            //保存并退出
            if (keyChar == 'x' && judge == false) {
                System.out.println("退出");
                fileTest1.saveFile(getCurFileName());
                System.exit(0);
            }
            //另存为
            if (keyChar == 's' && judge == false) {
                fileTest1.saveAs();
            }
            //按两次d删除光标所在行
            if (keyChar == 'd' && judge == false) {
                countd++;
                System.out.println("第" + countd + "次" + "按下按键d");
                if (countd % 2 == 0) {
                    pos = textArea.getCaretPosition();
                    col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                    try {
                        row = textArea.getLineOfOffset(pos) + 1;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    String[] s = textArea.getText().split("\n");
                    String[] st = new String[s.length - 1];
                    int j = 0;
                    for (int i = 0; i < s.length; i++) {
                        if (i != row - 1) {
                            st[j] = s[i];
                            j++;
                        }
                    }
                    textArea.setText("");
                    for (int i = 0; i < st.length; i++) {
                        if (i < st.length - 1) {
                            textArea.append(st[i]);
                            textArea.append("\r\n");
                        } else {
                            textArea.append(st[i]);
                        }
                    }
                    System.out.println("删除成功");
                }
            }
            //按两次y复制光标所在行内容到粘贴板
            if (keyChar == 'y' && judge == false) {
                county++;
                System.out.println("第" + county + "次" + "按下按键y");
                if (county % 2 == 0) {
                    pos = textArea.getCaretPosition();
                    col = pos - textArea.getText().substring(0, pos).lastIndexOf("/n");
                    try {
                        row = textArea.getLineOfOffset(pos) + 1;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    String[] s = textArea.getText().split("\n");
                    String st = null;
                    for (int i = 0; i < s.length; i++) {
                        if (i == row - 1) {
                            st = s[i];
                        }
                    }
                    copy = st;
                    System.out.println("字符串：" + "'" + copy + "'" + "被保存到粘贴板");
                }
            }
            //把粘贴板内容写入下一行
            if (keyChar == 'p' && judge == false) {
                System.out.println("按下p键");
                System.out.println("字符串‘" + copy + "’被复制成功");
                textArea.insert("\r\n", textArea.getCaretPosition());
                textArea.insert(copy, textArea.getCaretPosition());
            }
            //实现在文本框输入/键用新字符串替换文本中已知字符串或者匹配字符串
            if (keyChar == '/' && judge == false) {
                int x=0;String stf=textField.getText();
                for(int i=0;i<stf.length();i++){
                    if(stf.charAt(i)=='/'){
                        x++;
                    }
                }
                //替换字符串
                if(x==2){
                    String s1 = null;
                    String s2 = null;
                    String[] sf = new String[3];
                    sf = textField.getText().split("/");
                    s1 = sf[1];
                    s2 = sf[2];
                    System.out.println("被替换的字符串为:'"+s1+"'");
                    System.out.println("新字符串为:'"+s2+"'");
                    String[] sr = textArea.getText().split("\n");
                    for (int i = 0; i < sr.length; i++) {
                        sr[i] = sr[i].replaceAll(s1, s2);
                    }
                    textArea.setText("");
                    for (int i = 0; i < sr.length; i++) {
                        if (i < sr.length - 1) {
                            textArea.append(sr[i]);
                            textArea.append("\r\n");
                        } else {
                            textArea.append(sr[i]);
                        }
                    }
                    System.out.println("替换成功");
                }
                //匹配字符串
                if(x==1){
                    String[] spoint=textField.getText().split("/");
                    String point=spoint[1];
                    System.out.println(point);
                    String[] sr=textArea.getText().split("\n");
                    for(int i=0;i<sr.length;i++){
                        if(sr[i].contains(point)){
                            int n=i+1;
                            int p=0,q=0;
                            int pointLocation=0;
                            try{
                                pointLocation=textArea.getLineEndOffset(i-1);
                            }catch (Exception ex){ ex.printStackTrace();}
                            if(i==0){
                                p=sr[i].indexOf(point);
                                q=p+point.length();
                            }
                            else{
                                p=sr[i].indexOf(point)+pointLocation;
                                q=p+point.length();
                            }
                            System.out.println(p+" "+q);
                            textArea.setSelectionStart(p);
                            textArea.setSelectionEnd(q);
                            textArea.setSelectedTextColor(Color.GREEN);
                            textArea.setSelectionColor(Color.black);
                            System.out.println(textArea.getSelectedText().toUpperCase());
                            System.out.println("第"+ n +"行包含字符串:'"+point+"'");
                        }//if语句结束
                    }//for循环结束
                }//if语句结束
            }//if语句结束
        }//keyReleased方法结束
    }//类KeyListenerTest1结束

    //每隔30秒保存一次文件
    public class MyRunnable1 implements Runnable {
        MyVimGui.FileTest1 fileTest1 = new MyVimGui.FileTest1();

        public void run() {
            while (true) {
                fileTest1.saveFile(getCurFileName());
                System.out.println("文件保存成功  " + String.format("%tc", new Date()));
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//while循环结束
        }//run()方法结束
    }//类MyRunnable1结束

    public static void main(String[] args) {
        JFrame frame=new MyVimGui();
        frame.setTitle("Vim");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}

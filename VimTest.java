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
import javax.swing.*;
import javax.swing.plaf.metal.MetalScrollButton;

class MyVimGui extends JFrame implements ActionListener{
    JTextArea textArea;
    JMenuBar menuBar;
    JScrollPane scrollPane;
    MyVimGui(){
        JFrame frame=new JFrame("Vim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        menuBar = new JMenuBar();
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

//弹出式菜单，鼠标右键点击弹出
        final JPopupMenu popupMenu=new JPopupMenu();
        JMenuItem pop1=new JMenuItem("撤销(U)");
        JMenuItem pop2=new JMenuItem("粘贴(P)");
        JMenuItem pop3=new JMenuItem("选择单词(W)");
        JMenuItem pop4=new JMenuItem("选择句子(S)");
        JMenuItem pop5=new JMenuItem("选择段落(R)");
        JMenuItem pop6=new JMenuItem("选择行(L)");
        JMenuItem pop7=new JMenuItem("选择块(B)");
        JMenuItem pop8=new JMenuItem("全选(A)");
        popupMenu.add(pop1);
        popupMenu.add(pop2);
        popupMenu.add(pop3);
        popupMenu.add(pop4);
        popupMenu.add(pop5);
        popupMenu.add(pop6);
        popupMenu.add(pop7);
        popupMenu.add(pop8);
        JTextArea textArea=new JTextArea();
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()){
                    popupMenu.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
        add(new JScrollPane(textArea));

        setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent e) {

        JMenuItem source = (JMenuItem) (e.getSource());
    }
    public void actionPerformed1(ActionEvent e){
        textArea.append("Button clicked \n");
    }

    public static void main(String[] args) {

        MyVimGui myVimGui = new MyVimGui();
    }

}

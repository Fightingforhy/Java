import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.table.*;

class JTableTest
{
    JFrame mainFrame;
    JPanel mainPanel;
    JTable table;
    JScrollPane scrollPane;
    public JTableTest() {

        mainFrame = new JFrame ( "JTableTest" );
        mainPanel = new JPanel ( new BorderLayout() );

        String[] columnName = { "Name","Age","Favorite Color","Career","Married" };
        Object[][] data = { { "kate", new Integer(34),new Color(255,0,0),"engineer", new Boolean(true) },
                { "jim", new Integer(56),Color.white,"manager", new Boolean(false) },
                { "roy", new Integer(23),Color.black,"driver", new Boolean(false) },
                { "paul", new Integer(33),Color.blue,"teacher", new Boolean(true) }};

        CustomTableModel customModel = new CustomTableModel( data,columnName );//自定义的数据模型
        table = new JTable( customModel ){//在构造方法里传递数据模型作为参数
            public String getToolTipText( MouseEvent e){//设定工具提示
                int row = rowAtPoint( e.getPoint() );
                int column = columnAtPoint( e.getPoint() );
                int realColumn = convertColumnIndexToModel( column );
                if( realColumn == 3 ){
                    TableModel model = getModel();
                    String name = (String)model.getValueAt( row, 0 );
                    String career = (String)model.getValueAt( row, realColumn );
                    return name + "'s" + "career is " + career;
                }
                return null;
            }

            public TableCellEditor getCellEditor(int row, int column) {
                if ((row == 1) && (column == 2)) {
                    return new CustomCellEditor();//好像没起作用?
                }
                return super.getCellEditor(row, column);
            }
        };
        table.getTableHeader().setToolTipText("click here can't sort the contents");//设置标题头的工具提示.排序功能并未实现
        ListSelectionModel rowSm = table.getSelectionModel();
        rowSm.addListSelectionListener( new ListSelectionListener(){
            public void valueChanged( ListSelectionEvent e ){
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                System.out.println( lsm.getMaxSelectionIndex() );
            }
        } );

        TableColumn column = table.getColumnModel().getColumn(3);
        JComboBox combox = new JComboBox();
        combox.addItem("engineer");
        combox.addItem("students");
        combox.addItem("driver");
        combox.addItem("teacher");
        column.setCellEditor( new DefaultCellEditor( combox ) );//为一整列指定编辑器

        table.setDefaultEditor( Color.class , new CustomCellEditor() );//为特定的数据类型指定编辑器
        table.setDefaultRenderer( Color.class , new CustomRenderer() );


        TableModel tableModel = table.getModel();
        tableModel.addTableModelListener( new TableModelListener(){
            public void tableChanged( TableModelEvent e ){
                TableModel model = (TableModel)e.getSource();
                int row = e.getFirstRow();
                int column = e.getColumn();

                System.out.println( model.getValueAt( row, column ) );
                System.out.println( model.getColumnName( column ) );
            }
        } );

        mainPanel.add(table.getTableHeader(),BorderLayout.PAGE_START);
        mainPanel.add(table,BorderLayout.CENTER);
        scrollPane = new JScrollPane (mainPanel);//这样,表头会自动添加到滚动空格里;否则,则要使用下面三行将标题头也添加到框架窗口
/*        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.getContentPane().add(table.getTableHeader(), BorderLayout.PAGE_START);
        mainFrame.getContentPane().add(table, BorderLayout.CENTER);*/


        mainFrame.getContentPane().add( scrollPane );
        mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible( true );
    }
    private class CustomTableModel extends AbstractTableModel{//自定义的数据类型
        String[] columnName;
        Object[][] data;
        CustomTableModel(Object[][] data,String[] columnName){
            this.columnName = columnName;
            this.data = data;
        }
        public Object getValueAt( int rowIndex, int columnIndex ){
            return data[rowIndex][columnIndex];
        }
        public int getColumnCount(){
            return data[0].length;
        }
        public int getRowCount(){
            return data.length;
        }
        public String getColumnName( int columnIndex ){
            return columnName[columnIndex];
        }
        public Class getColumnClass( int columnIndex ){
            return getValueAt(0,columnIndex).getClass();

        }
        public void setValueAt( Object value, int row, int column ){
            data[row][column] = value;
            fireTableCellUpdated(row,column);
        }
        public boolean isCellEditable(int row ,int column){
            return true;
        }
    }
    //自定义的编辑器
    private class CustomCellEditor extends AbstractCellEditor implements TableCellEditor,ActionListener{
        Color currentColor;
        JButton button;
        JColorChooser chooser;
        JDialog dialog;
        CustomCellEditor(){
            button = new JButton ();
            button.addActionListener( this );
            button.setActionCommand("editor");
            chooser = new JColorChooser();
            dialog = JColorChooser.createDialog( button,"pick a color",true,chooser,this,null);
        }
        public void actionPerformed( ActionEvent e ){
            if( e.getActionCommand().equals( "editor" ) ){
                button.setBackground( currentColor );
                chooser.setColor(currentColor);
                dialog.setVisible( true );
                fireEditingStopped();
            }else{

                currentColor = chooser.getColor();
            }
        }
        public Object getCellEditorValue(){
            return currentColor;
        }
        public Component getTableCellEditorComponent( JTable table,Object value,boolean isSelected,int row,int column){
            currentColor = (Color)value;
            return button;
        }
    }
    //自定义的渲染器
    private class CustomRenderer extends JLabel implements TableCellRenderer{
        CustomRenderer(){
            setOpaque(true);
        }
        public Component getTableCellRendererComponent(
                JTable table,Object value,boolean isSelected,
                boolean hasFocus,int row,int column){
            setBackground( (Color)value );
            setToolTipText( "RGB Value: "+((Color)value).getRed()+" "
                    +((Color)value).getGreen()+" "+((Color)value).getBlue() );
            return this;
        }

    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater( new Runnable(){
            public void run(){
                new JTableTest();
            }
        });
    }
}
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.beans.*;

//一个打开/保存文件对话框

class JFileChooserDemo{
    JFileChooser fileChooser;
    JScrollPane scrollPane;
    JLabel label;
    public JFileChooserDemo(){
        fileChooser=new JFileChooser();
        label=new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        scrollPane=new JScrollPane(label);
        scrollPane.setPreferredSize(new Dimension(100,10));
        fileChooser.setAccessory(scrollPane);
        fileChooser.addChoosableFileFilter(new GifFileFilter());
        fileChooser.addChoosableFileFilter(new PngFileFilter());
        fileChooser.addChoosableFileFilter(new JpgFileFilter());
        fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())){
                    File newSelectedFile=(File) evt.getNewValue();
                    if(newSelectedFile!=null){
                        ImageIcon icon=new ImageIcon(newSelectedFile.getPath());
                        label.setIcon(icon);
                    }
                }
            }
        });
        fileChooser.showOpenDialog(null);
        //fileChooser.showDialog(null,"自定义按钮文字“);
    }
    class GifFileFilter extends FileFilter{
        public boolean accept(File f){
            return f.getName().endsWith(".gif");
        }
        public String getDescription(){
            return "Gif files(.gif)";
        }
    }
    class PngFileFilter extends FileFilter{
        public boolean accept(File f){
            return f.getName().endsWith(".png");
        }
        public String getDescription(){
            return "Png file(.png)";
        }
    }
    class JpgFileFilter extends FileFilter{
        public boolean accept(File f){
            return f.getName().endsWith(".jpg");
        }
        public String getDescription(){
            return "Jpg file(.jpg)";
        }
    }
    public static void main(String[] args){
        new JFileChooserDemo();
    }
}
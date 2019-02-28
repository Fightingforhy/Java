import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.beans.*;

class JFileChooserDemo
{
    JFileChooser simpleFileChooser;
    JScrollPane previewScrollPane;
    JLabel previewLabel;
    public JFileChooserDemo() {
        simpleFileChooser = new JFileChooser();
        previewLabel = new JLabel ();
        previewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        previewScrollPane = new JScrollPane ( previewLabel );
        previewScrollPane.setPreferredSize(new Dimension(100,10));
        simpleFileChooser.setAccessory( previewScrollPane );
        simpleFileChooser.addChoosableFileFilter( new GifFileFilter() );
        simpleFileChooser.addChoosableFileFilter( new PngFileFilter() );
        simpleFileChooser.addChoosableFileFilter( new JpgFileFilter() );
        simpleFileChooser.addPropertyChangeListener( new PropertyChangeListener(){
            public void propertyChange( PropertyChangeEvent e ){
                if ( JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals( e.getPropertyName() ) ){
                    File newSelectedFile = (File)e.getNewValue();
                    if( newSelectedFile != null){
                        ImageIcon icon = new ImageIcon( newSelectedFile.getPath() );
                        previewLabel.setIcon( icon );
                    }
                }
            }
        });
        simpleFileChooser.showOpenDialog(null);
        //simpleFileChooser.showDialog(null,"自定义按钮文字");
    }
    class GifFileFilter extends FileFilter{
        public boolean accept( File f ){
            return f.getName().endsWith(".gif");
        }
        public String getDescription(){
            return "Gif files(.gif)";
        }
    }
    class PngFileFilter extends FileFilter{
        public boolean accept( File f ){
            return f.getName().endsWith(".png");
        }
        public String getDescription(){
            return "Png files(.png)";
        }
    }
    class JpgFileFilter extends FileFilter{
        public boolean accept( File f ){
            return f.getName().endsWith(".jpg");
        }
        public String getDescription(){
            return "Jpg files(.jpg)";
        }
    }
    public static void main(String[] args)
    {
        new JFileChooserDemo();
    }
}
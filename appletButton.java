import java.awt.*;
import java.applet.Applet;
public class appletButton extends Applet{
    Button button1,button2,button3;
    public void init(){
        button1=new Button("OK");
        button2=new Button("Open");
        button3=new Button("Close");
        add(button1);
        add(button2);
        add(button3);
        Applet applet=new Applet();
        System.out.println(applet.getAppletInfo());
    }
}
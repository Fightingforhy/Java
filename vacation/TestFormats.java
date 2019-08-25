import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Calendar;
import java.util.Date;

public class TestFormats{
    public static void main(String [] args){
        String s=String.format("%,d",1000000000);
        System.out.println(s);
        String s2=String.format("I have %,.2f, bugs to fix.",476578.09876);
        System.out.println(s2);
        int one=20456654;
        double two=100567890.248907;
        String s3=String.format("The rank is %,d out of %,.2f.",one,two);
        System.out.println(s3);
        String  s4=String.format("%tr",new Date());
        System.out.println(s4);
        String s5=String.format("%tc",new Date());
        System.out.println(s5);
        Date today =new Date();
        String s6=String.format("%tA,%tB %td",today,today,today);
        System.out.println(s6);
        Date today2=new Date();
        String s7=String .format("%tA,%<tB %<td",today);
        System.out.println(s7);

        //Calendar范例测试
        Calendar c=Calendar.getInstance();
        c.set(2004,1,7,15,40);
        long day1=c.getTimeInMillis();
        day1+=1000*60*60;
        c.setTimeInMillis(day1);
        System.out.println("new hour "+c.get(c.HOUR_OF_DAY));
        c.add(c.DATE,35);
        System.out.println("add 35 days "+c.getTime());
        c.roll(c.DATE,35);
        System.out.println("roll 35 days "+c.getTime());
        c.set(c.DATE,1);
        System.out.println("set to 1 "+c.getTime());
    }
}
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Calendar;
import java.util.Date;

public class TestCalendar{
    public static void main(String [] args){
        //Calendar范例测试
        Calendar c=Calendar.getInstance();
        c.set(2018,8,6,8,30);
        long day1=c.getTimeInMillis();
        day1+=1000*60*60;
        day1+=1000*60*10;
        c.setTimeInMillis(day1);
        System.out.println("new hour "+c.get(c.HOUR_OF_DAY));
        System.out.println("minute "+c.get(c.MINUTE));
        System.out.println("second "+c.get(c.SECOND));
        c.add(c.DATE,35);
        c.add(c.HOUR_OF_DAY,-1);
        c.add(c.MINUTE,4);
        System.out.println("add 35 days "+c.getTime());
        c.roll(c.DATE,35);
        c.roll(c.HOUR_OF_DAY,12);
        System.out.println("roll 35 days "+c.getTime());
        c.set(c.DATE,1);//c.set(c.DAY_OF_MONTH,1);
        c.set(c.MINUTE,1);
        c.set(c.HOUR_OF_DAY,1);
        c.set(c.MONTH,0);
        c.set(Calendar.YEAR,2017);
        System.out.println("set to 1 "+c.getTime());
    }
}
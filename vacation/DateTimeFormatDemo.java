import java.util.Locale;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormatSymbols;
class  DateTimeFormatDemo
{
    public static void main(String[] args)
    {
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        Locale[]  locales = { Locale.CHINA,Locale.US,Locale.GERMANY };
        String[] patterns = { "yy-MM-dd","E yyyy/MM/dd","yy.MM.dd.hh.mm.ss" };
        DateFormat formats;
        SimpleDateFormat sdf;
        String out;
        for( int i=0; i<3; i++ ){
            formats = DateFormat.getDateInstance(DateFormat.DEFAULT,locales[i]);
            out = formats.format( date );
            System.out.println( out );
            formats = DateFormat.getTimeInstance(DateFormat.LONG,locales[i]);
            out = formats.format( date );
            System.out.println( out );
            formats = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL,locales[i]);
            out = formats.format( date );
            System.out.println( out );
            sdf = new SimpleDateFormat(patterns[i],locales[i]);
            out = sdf.format( date );
            System.out.println( out+"  "+patterns[i] );
            System.out.println( "=====================" );
        }
        DateFormatSymbols dfss = new DateFormatSymbols(Locale.CHINA);
        sdf = new SimpleDateFormat();
        String[] capitalDays = {
                "","SUN-星期日", "MON-星期一", "TUE-星期二", "WED-星期三",
                "THU-星期四", "FRI-星期五", "SAT-星期六"};
        dfss.setShortWeekdays(capitalDays);
        sdf.applyPattern("E");
        sdf.setDateFormatSymbols( dfss );
        out = sdf.format(date);
        System.out.println( out );
    }
}
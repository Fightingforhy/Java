import java.util.Locale;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
class NumberFormatDemo{
    public static void main( String[] args ){
        double number = 96356.127;
        double currency = 56832.523;
        double percent = 0.72;
        String out;
        Locale locales[] = { Locale.CHINA,Locale.US,Locale.GERMANY };
        NumberFormat formats = NumberFormat.getNumberInstance();
        for( int i=0; i<3; i++){
            formats = NumberFormat.getNumberInstance( locales[i] );
            out = formats.format( number );
            System.out.println( out+"  "+locales[i].getDisplayName() );
            formats = NumberFormat.getCurrencyInstance( locales[i] );
            out = formats.format( currency );
            System.out.println( out+"  "+locales[i].getDisplayName() );
            formats = NumberFormat.getPercentInstance( locales[i] );
            out = formats.format( percent );
            System.out.println( out+"  "+locales[i].getDisplayName() );
        }
        DecimalFormat df = new DecimalFormat();
        String pattern = "@#,###.##";
        df.applyPattern( pattern );
        out = df.format(number);
        System.out.println( out );
        pattern = "#@###.####";
        df.applyPattern( pattern );
        out = df.format(number);
        System.out.println( out );
        df = (DecimalFormat)formats;
        df.applyPattern("#,###.##");
        out = df.format(number);
        System.out.println( out );
        DecimalFormatSymbols dfss = new DecimalFormatSymbols(Locale.GERMANY);
        dfss.setDecimalSeparator('^');
        df.setDecimalFormatSymbols( dfss );
        df.applyPattern("00,000.000");
        out = df.format(number);
        System.out.println( out );
    }
}
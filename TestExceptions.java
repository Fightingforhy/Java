import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class TestExceptions {
    static void doRisky(String test) throws ScaryException{
        System.out.println("start risky");
        if("yes".equals(test)){
            throw new ScaryException();
        }
        System.out.println("end risky");
        return;
    }
    public static void main(String [] args){
        String test1="no";
        String test2="yes";
        try{
            System.out.println("start try");
            doRisky(test1);
            System.out.println("end try");
        }catch(ScaryException se){
            System.out.println("scary exception");
        }finally{
            System.out.println("finally");
        }
        System.out.println("end of main");
        try{
            System.out.println("start try");
            doRisky(test2);
            System.out.println("end try");
        }catch(ScaryException se){
            System.out.println("scary exception");
        }finally{
            System.out.println("finally");
        }
        System.out.println("end of main");
    }
}
class ScaryException extends Exception{

}
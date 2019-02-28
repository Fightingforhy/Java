class Boat{
    private int length;
    public void setLength(int len){
        length=len;
    }
    public void move(){
        System.out.println("drift  ");
    }
}
class Rowboat extends Boat{
    public void rowTheBoat(){
        System.out.println("stroke natasha");
    }
}
class Sailboat extends Boat{
    public void move(){
        System.out.println("hoist sail ");
    }
}
public class TestBoat{
    public static  void main(String [] args){
        Boat b1=new Boat();
        Sailboat b2=new Sailboat();
        Rowboat b3=new Rowboat();
        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}
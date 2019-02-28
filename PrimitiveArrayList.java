import java.util.ArrayList;

class Primitive1{
    public void doNumsNewWay(){
        ArrayList<Integer> listOfNumbers=new ArrayList<Integer>();
        listOfNumbers.add(1);
        int num=listOfNumbers.get(0);
        System.out.println(num);
    }
}
class Primitive2{
    public void doNumsOldWay(){
        ArrayList listOfNumbers=new ArrayList();
        listOfNumbers.add(new Integer(2));
        Integer one=(Integer) listOfNumbers.get(0);
        int intOne =one.intValue();
        System.out.println(intOne);
    }
}
public class PrimitiveArrayList {
    public static void main(String[] args) {
        Primitive1 p = new Primitive1();
        p.doNumsNewWay();
        Primitive2 p2 = new Primitive2();
        p2.doNumsOldWay();
        Integer j = new Integer(5);
        Integer k = j + 3;
        j++;
        int i=j.intValue();
        System.out.println(k+" "+j+" "+i);
    }

}
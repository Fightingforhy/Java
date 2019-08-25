class Duck{
    int pound=6;
    float floatability=2.1F;
    String name="Generic";
    long[] feathers={1,2,3,4,5,6,7};
    boolean canFly=true;
    int maxSpeed=25;
    public Duck(){
        System.out.println("type 1 duck");
    }
    public Duck(float d,int w){
        System.out.println("type 2 duck");
    }
    public Duck(String n,long[] f){
        System.out.println("type 3 duck");
    }
    public Duck(boolean c){
        System.out.println("type 4 duck");
    }
    public Duck(int a,float d){
        System.out.println("type 5 duck");
    }
}
public class TestDuck{
    public static void main(String [] args){
        int weight =8;
        float density=2.3F;
        String name ="Donald";
        long[] feathers={1,2,3,4,5,6};
        boolean canFly =true;
        int airspeed=22;
        Duck[] d=new Duck[7];
        d[0]=new Duck();
        d[1]=new Duck(density,weight);
        d[2]=new Duck(name,feathers);
        d[3]=new Duck(canFly);
        d[4]=new Duck(3.3F,airspeed);
        d[5]=new Duck(false);
        d[6]=new Duck(airspeed,density);
    }
}
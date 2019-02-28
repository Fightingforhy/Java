public class  HonsterTestOrive {
    public static void main(String [] args){
        Monster[] ma =new Monster[3];
        ma[0]=new Vampire();
        ma[1]=new Dragon();
        ma[2]=new Monster();
        for(int x=0;x<3;x++){
            ma[x].frighten(x);
        }
    }
}
class Monster{
    void frighten(int d){
        System.out.println("arrrgh");
    }
}
class Vampire extends Monster{
    void frighten(int degree){
        System.out.println("a bite?");
    }
}
class Dragon extends Monster{
    void frighten(int degree){
        System.out.println("breath fire");
    }
}
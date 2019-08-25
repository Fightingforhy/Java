public interface Pet{
    public abstract void beFriendly();
    public abstract void play();
}
class Canine{
    void roma(){ }
}
class Dog extends Canine implements Pet{
    public void beFriendly(){
        System.out.println("摇尾巴");
    }
    public void play(){
        System.out.println("摇尾巴");
    }
    public void roma(){ }
    public void eat(){ }
    public static void main(String [] args){
        Dog dog1=new Dog();
        dog1.beFriendly();
        dog1.play();
    }
}

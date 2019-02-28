abstract class Animal{
    String picture;
    int hunger;
    String food;
    String boundaries;
    String location;
    void makeNoise(){}
    void eat(){}
    void sleep(){}
    void roam(){}
}
class Feline extends Animal{
    void roam(){}
}
class Canine extends Animal{
    void roam(){}
}
class Lion extends Feline{
    void makeNoise(){
        System.out.println("hong");
    }
    void eat(){
        System.out.println("meat");
    }
}
class Tiger extends Feline{
    void makeNoise(){
        System.out.println("hao");
    }
    void eat(){
        System.out.println("meat");
    }
}
class Cat extends Feline{
    void makeNoise(){
        System.out.println("miao");
    }
    void eat(){
        System.out.println("meat and gress");
    }
}
class Hippo extends Animal{
    void makeNoise(){
        System.out.println("don't know");
    }
    void eat(){
        System.out.println("gress");
    }
}
class Wolf extends Canine{
    void makeNoise(){
        System.out.println("ou hou");
    }
    void eat(){
        System.out.println("meat");
    }
}
class Dog extends Canine{
    void makeNoise(){
        System.out.println("wang wang wang");
    }
    void eat(){
        System.out.println("meat");
    }
}
class MyAnimalList{
    private Animal[] animals=new Animal[6];
    private int nextIndex=0;
    public void add(Animal a){
        if(nextIndex<animals.length){
            animals[nextIndex]=a;
            System.out.println("Animal added at "+nextIndex);
            nextIndex++;
        }
    }
}
class AnimalTestDrive{
    public static void main(String [] args){
        MyAnimalList list = new MyAnimalList();
        Dog a= new Dog();
        Cat c=new Cat();
        Wolf w=new Wolf();
        Lion l=new Lion();
        Tiger t=new Tiger();
        Hippo h=new Hippo();
        list.add(a);
        list.add(c);
        list.add(w);
        list.add(l);
        list.add(t);
        list.add(h);
    }
}
class Foo{
    static int x;
    public void go(){
        System.out.println(x);
    }
}
class Foo2{
    int x;
    public static void go(){
        System.out.println(2);
        }
        void Go(){
        go();
    }
}
class Foo3{
     final int x=3;
    public void go(){
        System.out.println(x);
    }
}
class Foo4{
    static final int x=4;
    public void go(){
        System.out.println(x);
    }
}
class Foo5{
    static final int x=55;
    public void go(final int x){
        System.out.println(x);
    }
}
class Foo6{
    int x=12;
    public static void go(final  int x){
        System.out.println(x);
    }
}
class Test{
    public static void main(String [] args){
        Foo f=new Foo();
        f.go();
        Foo2 f2=new Foo2();
        f2.Go();
        Foo3 f3=new Foo3();
        f3.go();
        Foo4 f4=new Foo4();
        f4.go();
        Foo5 f5=new Foo5();
        f5.go(5);
        Foo6.go(6);
    }
}
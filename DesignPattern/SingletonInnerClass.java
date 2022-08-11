package DesignPattern;

public class SingletonInnerClass{
    public static void main(String[] args){
//        System.out.println(Singleton.getInstance());
//        System.out.println(Singleton.getInstance());
        Singleton.test();        //没有调用，所以不会初始化内部类
//        System.out.println(Singleton.i);    //Singleton初始化不会导致内部类初始化
    }
}


class Singleton {
    private Singleton(){
        System.out.println("private Singleton()");
    }
    public static Integer  i = 10;
    static {
        System.out.println("Singleton init");
    }
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
        static {
            System.out.println("holder init");
        }
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public static void test(){
        System.out.println("test");
    }
}

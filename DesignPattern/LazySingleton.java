package DesignPattern;

public class LazySingleton {
    private static LazySingleton lazysingleton;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(lazysingleton == null){
            lazysingleton = new LazySingleton();
        }
        return lazysingleton;
    }

    public static void main(String[] args){
        LazySingleton l = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println(l);
        System.out.println(l2);
        System.out.println(l == l2);
    }
}

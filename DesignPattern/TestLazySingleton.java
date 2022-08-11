package DesignPattern;

public class TestLazySingleton {
    public static void main(String[] args){
        LazySingleton.otherMethod();
        System.out.println("++++++++");
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
    }
}

package DesignPattern;

public class EhSingleton {
    private static EhSingleton ehsingleton = new EhSingleton();
    private EhSingleton(){}
    public static EhSingleton getInstance(){
        return ehsingleton;
    }
    public static void main(String[] args){
        EhSingleton e = EhSingleton.getInstance();
        System.out.println(e);
        EhSingleton e2 = EhSingleton.getInstance();
        System.out.println(e2);
        System.out.println(e == e2);
    }
}



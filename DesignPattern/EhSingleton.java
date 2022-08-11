package DesignPattern;

import java.io.Serializable;

public class EhSingleton implements Serializable {
    private static EhSingleton ehsingleton = new EhSingleton();
    private EhSingleton(){
        if(ehsingleton !=null){
            throw new RuntimeException("Singleton can't build twice.");
        }
        System.out.println("private EhSingleton()");
    }
    public static EhSingleton getInstance(){
        return ehsingleton;
    }
    public static void otherMethod(){
        System.out.println("other method");
    }
    public Object readResolve(){
        return ehsingleton;
    }
}



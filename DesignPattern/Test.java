package DesignPattern;

public class Test {
    public static void main(String[] args){
        EhSingleton e1 = EhSingleton.getInstance();
        EhSingleton e2 = EhSingleton.getInstance();
        System.out.println(e1 == e2);

        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println(l1 == l2);

        SynLazySingleton s1 = SynLazySingleton.getInstance();
        SynLazySingleton s2 = SynLazySingleton.getInstance();
        System.out.println(s1 == s2);

        //LazySingleton l3 = new LazySingleton();   //不能够访问构造方法

        LazySingletonDoubleCheck l3 = LazySingletonDoubleCheck.getInstance();
        LazySingletonDoubleCheck l4 = LazySingletonDoubleCheck.getInstance();
        System.out.println(l3 == l4);
    }
}


package DesignPattern;

public class LazySingletonDoubleCheck {
    private static volatile LazySingletonDoubleCheck lazysingletondoublecheck;
    private LazySingletonDoubleCheck(){}
    public static LazySingletonDoubleCheck getInstance(){
        if(lazysingletondoublecheck == null){
            synchronized (LazySingletonDoubleCheck.class){
                lazysingletondoublecheck = new LazySingletonDoubleCheck();
            }
        }
        return lazysingletondoublecheck;
    }
    public static void main(String[] args){
        LazySingletonDoubleCheck l1 = LazySingletonDoubleCheck.getInstance();
        LazySingletonDoubleCheck l2 = LazySingletonDoubleCheck.getInstance();
        System.out.println(l1 == l2);
    }
}

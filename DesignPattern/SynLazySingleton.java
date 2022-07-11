package DesignPattern;

public class SynLazySingleton {
    private static SynLazySingleton synlazysingleton;
    private SynLazySingleton(){}
    public static synchronized SynLazySingleton getInstance(){
        if(synlazysingleton == null){
            synlazysingleton = new SynLazySingleton();
        }
        return synlazysingleton;
    }
    public static void main(String[] args){
        SynLazySingleton s1 = SynLazySingleton.getInstance();
        SynLazySingleton s2 = SynLazySingleton.getInstance();
        System.out.println(s1 == s2);
//        类自己可以访问private修饰的方法
        SynLazySingleton s3 = new SynLazySingleton();
        System.out.println(s3 == s2);
    }
}
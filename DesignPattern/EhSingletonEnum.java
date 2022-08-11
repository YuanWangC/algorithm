package DesignPattern;

// 枚举类默认构造方法为private，可以有效限制实例个数，反序列化后发现，实例初始化被放在static代码块中
public enum EhSingletonEnum{
    Instance;   //枚举变量是public类型的，可以直接使用
    EhSingletonEnum(){
        System.out.println("private EhSingletonEnum()");
    }     //构造方法默认private
    public String toString(){
        return getClass().getName()+" @ "+Integer.toHexString(hashCode());
    }
    public static EhSingletonEnum getInstance(){
        return Instance;
    }
    public static void otherMethod(){
        System.out.println("other method");
    }
}
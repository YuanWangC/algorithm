package DesignPattern;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, NoSuchFieldException {
        EhSingleton.otherMethod();  //调用静态方法时会触发类的初始化，调用了构造函数，创建单例
        System.out.println(EhSingleton.getInstance());
        System.out.println(EhSingleton.getInstance());
        //反射破坏单例
        //在构造函数中判断单例是否已经创建，从而保证单例
//        reflection(EhSingleton.class);

        //反序列化破坏单例（实现Serializable，可以使对象变成字节流读写磁盘）
        //使用readResolve()方法保证单例
//        serializable(EhSingleton.getInstance());
        //Unsafe破坏单例，没有预防手段
//        unsafe(EhSingleton.class);
    }
    private static void reflection(Class<?> cla) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = cla.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println("reflection build another instance: "+constructor.newInstance());
    }
    private static void serializable(Object instance) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        先读成字节流
        ObjectOutputStream objos = new ObjectOutputStream(bos);
        objos.writeObject(instance);
//        再写
        ObjectInputStream objis = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
//        readObject不走构造方法
        System.out.println("serializable build another instance: "+objis.readObject());
    }
    private static void unsafe(Class<?> cla) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe U = (Unsafe)f.get(null);
        Object o = U.allocateInstance(cla);
        System.out.println("unsafe build another instance: "+o);
    }
}


package DesignPattern;

import sun.misc.Unsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestSingletonEnum {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException, NoSuchFieldException {
        EhSingletonEnum.otherMethod();
        System.out.println(EhSingletonEnum.getInstance());
        System.out.println(EhSingletonEnum.getInstance());
        System.out.println(EhSingletonEnum.Instance);
        EhSingletonEnum.Instance.name();
        EhSingletonEnum.Instance.ordinal();
//        枚举类可以解决反射和序列化导致的单例破坏问题
//        reflection(EhSingletonEnum.class);   //报错
//        serializable(EhSingletonEnum.getInstance());  //创建同一个类
//        unsafe(EhSingletonEnum.class);
        unsafeAddEnums();
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
    private static void unsafeAddEnums() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe U = (Unsafe)f.get(null);
        long nameOffset = U.objectFieldOffset(Enum.class.getDeclaredField("name"));
        long ordinalOffset = U.objectFieldOffset(Enum.class.getDeclaredField("ordinal"));
        EhSingletonEnum o = (EhSingletonEnum) U.allocateInstance(EhSingletonEnum.class);
        U.compareAndSwapObject(o,nameOffset,null,"newInstance");
        U.compareAndSwapInt(o,ordinalOffset,0,1);
        System.out.println(o.name());
        System.out.println(o.ordinal());
    }
}

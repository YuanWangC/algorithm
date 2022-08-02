import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class SyncVsCas {
//    private static final Unsafe u = Unsafe.getUnsafe();
//    不受信任的类加载器加载的（非Boost），会报错SecurityException
//    这个单例类，需要使用反射来访问theUnsafe字段，从而访问getUnsafe方法，获取唯一实例
    static Field f;
    static {
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    static Unsafe u;
    static {
        try {
            u = (Unsafe) f.get(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    static final long BALANCE;
    static {
        try {
            BALANCE = u.objectFieldOffset(Account.class.getDeclaredField("balance"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public SyncVsCas() throws NoSuchFieldException {
    }

    static class Account{
        volatile int balance = 10;
    }
    public static void main(String[] args){
        Account obj = new Account();
        while(true){
            int cur = obj.balance;
            int newCur = cur + 5;
            if(u.compareAndSwapInt(obj, BALANCE, cur, newCur)){
                break;
            }
        }
        System.out.println(obj.balance);
    }
}

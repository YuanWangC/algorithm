import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class CASTest {
    static Field f;
    static Unsafe U;
    static long valueOffset;
    static {
        try{
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            U = (Unsafe)f.get(null);
            valueOffset = U.objectFieldOffset(Test.class.getDeclaredField("value"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void cas(Test t){
        Thread t1 = new Thread(()->{
            while(true){
                int cur = t.value;
                int newCur = cur+5;
                if(U.compareAndSwapInt(t,valueOffset,cur,newCur)){
                    break;
                }
            }
        },"t1");

        Thread t2 = new Thread(()->{
            while(true){
                int cur = t.value;
                int newCur = cur-5;
                if(U.compareAndSwapInt(t,valueOffset,cur,newCur)){
                    break;
                }
            }
        },"t2");
        showResult(t,t1,t2);
    }
    public static void showResult(Test t,Thread t1,Thread t2){
        t1.start();
        t2.start();
        System.out.println(t.value);
    }
    public static void main(String[] args){
        cas(new Test());
    }
}
class Test{
    volatile int value = 10;
}
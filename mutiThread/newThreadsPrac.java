import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class newThreadsPrac {

    public static void main(String[] args){
//        只有start output第一个输出是确定的
        System.out.println("start output in main...");
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("t1:"+t1.currentThread().getPriority());
//        t1.run();
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        System.out.println("t2:"+t2.currentThread().getPriority());
//        t2.run();
        Thread t3 = new Thread(()->{
//            try {
//                Thread.sleep(5);
//
//            }
//            //当一个线程在wait、sleep、或者其他阻塞状态的情况下，并且当线程被置为interruped状态时，会抛出该异常
//            catch (InterruptedException e){}
            System.out.println("start running thread with lamada!");
        });
        t3.currentThread().setPriority(Thread.MAX_PRIORITY);
        t3.start();
        System.out.println("t3:"+t3.currentThread().getPriority());
        MyCallable t4 = new MyCallable();
        FutureTask<Integer> f = new FutureTask<>(t4);
        new Thread(f,"t4").start();

//        t3.run();
//        try {
//            Thread.sleep(15);
//        }catch (InterruptedException e){}
//        end output的输出位置无法确定，因为以上进程和main进程是并发的
        System.out.println("end output in main...");
    }

}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("start running myThread!");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("start running new thread with runnable obj!");
    }
}
class MyCallable implements Callable<Integer> {
    public Integer call(){
        System.out.println("start running new thread with callable obj!");
        return 1;
    }
}
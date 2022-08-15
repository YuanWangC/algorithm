import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for(int i=0;i<10;i++){
            Runnable worker = new MyRunnable2(""+i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()){
            Thread.sleep(500);
            System.out.println("!executor.isTerminated()");
            System.out.println(executor.getActiveCount());
            System.out.println(executor.getCompletedTaskCount());
        }
        System.out.println("Finished all Threads.");
    }
}
class MyRunnable2 implements Runnable{
    private String comm;
    public MyRunnable2(String s){
        comm = s;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" "+comm+" start "+new Date());
        process();
        System.out.println(Thread.currentThread().getName()+" "+comm+" end "+new Date());
    }
    private void process(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Override
    public String toString(){
        return this.comm;
    }
}
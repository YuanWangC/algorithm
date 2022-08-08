import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PhilosopherDeadLock {
    static int[] chop = {1,1,1,1,1};
    public static void main(String[] args){
        PhilosopherThread t1 = new PhilosopherThread();
        t1.setName("p0");
        PhilosopherThread t2 = new PhilosopherThread();
        t2.setName("p1");
        PhilosopherThread t3 = new PhilosopherThread();
        t3.setName("p2");
        PhilosopherThread t4 = new PhilosopherThread();
        t4.setName("p3");
        PhilosopherThread t5 = new PhilosopherThread();
        t5.setName("p4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
class PhilosopherThread extends Thread{
    @Override
    public synchronized void run(){
        while(true){
            int index = this.getName().charAt(1)-'0';
            // 第一只筷子
            if(PhilosopherDeadLock.chop[index] ==1){
                PhilosopherDeadLock.chop[index] = 0;
                System.out.println(this.getName()+" is getting chop "+index);
            }
            //没拿到
            else{
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            //另一只筷子
            if(PhilosopherDeadLock.chop[(index+1)%PhilosopherDeadLock.chop.length] ==1){
                PhilosopherDeadLock.chop[(index+1)%PhilosopherDeadLock.chop.length]=0;
                System.out.println(this.getName()+" is getting chop "+(index+1)%PhilosopherDeadLock.chop.length);
                System.out.println(this.getName()+" is eating");
                try {
                    Thread.sleep(1000);
                    PhilosopherDeadLock.chop[index]=1;
                    PhilosopherDeadLock.chop[(index+1)%PhilosopherDeadLock.chop.length]=1;
                    System.out.println(this.getName()+" is finished the meal.");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            //没拿到
            else {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
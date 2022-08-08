import java.util.concurrent.CountDownLatch;

public class PhilosopherSolve1 {
    static int[] chop = {-1,-1,-1,-1,-1};
    //假设筷子摆放是这样的： 0  1  2  3  4  (0)
    //哲学家是这样就坐的：    0  1  2  3  4
    public static void main(String[] args){
        CountDownLatch count = new CountDownLatch(5);
        PhilosopherS1Thread t1 = new PhilosopherS1Thread(count);
        t1.setName("p0");
        PhilosopherS1Thread t2 = new PhilosopherS1Thread(count);
        t2.setName("p1");
        PhilosopherS1Thread t3 = new PhilosopherS1Thread(count);
        t3.setName("p2");
        PhilosopherS1Thread t4 = new PhilosopherS1Thread(count);
        t4.setName("p3");
        PhilosopherS1Thread t5 = new PhilosopherS1Thread(count);
        t5.setName("p4");
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            count.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println((System.currentTimeMillis()-start)/1000);
    }
}
class PhilosopherS1Thread extends Thread{
    private CountDownLatch count;
    public PhilosopherS1Thread(CountDownLatch c){
        this.count = c;
    }
    @Override
    public void run() {
        int index = this.getName().charAt(1) - '0';
        int left = index;
        int right = (index + 1) % PhilosopherSolve1.chop.length;
        while (true) {
            if (index % 2 == 0) {
                if (PhilosopherSolve1.chop[left] == -1) {
                    PhilosopherSolve1.chop[left] = index;
                    System.out.println(this.getName() + " is getting chop " + left);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (PhilosopherSolve1.chop[right] == -1) {
                    PhilosopherSolve1.chop[right] = index;
                    System.out.println(this.getName() + " is getting chop " + right);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (PhilosopherSolve1.chop[right] == -1) {
                    PhilosopherSolve1.chop[right] = index;
                    System.out.println(this.getName() + " is getting chop " + right);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (PhilosopherSolve1.chop[left] == -1) {
                    PhilosopherSolve1.chop[left] = index;
                    System.out.println(this.getName() + " is getting chop " + left);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(PhilosopherSolve1.chop[left] == index && PhilosopherSolve1.chop[right] == index){
                try {
                    System.out.println(this.getName()+" is eating");
                    Thread.sleep(1000);
                    PhilosopherSolve1.chop[left]=-1;
                    PhilosopherSolve1.chop[right]=-1;
                    System.out.println(this.getName()+" is finished the meal.");
                    break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        this.count.countDown();
    }
}
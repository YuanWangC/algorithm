import javax.xml.namespace.QName;

public class ThreadYield {
    public static void main(String[] args){
        Thread t = new MyThread4("tom");
        Thread j = new MyThread4("jenny");
        t.start();
        j.start();
    }
}

class MyThread4 extends Thread{
    public MyThread4(String name){
        super(name);
    }
    @Override
    public void run(){
        System.out.println(this.getName()+" MyThread is running");
        int n=0;
        while(n<50){
            System.out.println(this.getName()+"------"+n);
            if(n==30){
                this.yield();
            }
            n++;
        }
//        for (int i = 1; i <= 50; i++) {
//            System.out.println("" + this.getName() + "-----" + i);
//            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
//            if (i == 30) {
//                this.yield();
//            }
//        }
    }
}

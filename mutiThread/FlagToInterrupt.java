public class FlagToInterrupt {
    public static void main(String[] args){
        MyThread3 t = new MyThread3();
        t.start();
        try{
            Thread.sleep(1);
            t.running = false;
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main is running");
    }
}

class MyThread3 extends Thread{
    public volatile boolean running = true;
    @Override
    public void run(){
        int n=0;
        while (running){
            n++;
        }
        System.out.println(n+" Thread is interrupted by running.");
    }
}
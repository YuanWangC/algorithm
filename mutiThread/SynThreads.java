public class SynThreads {
    public static void main(String[] args){
        Thread ta = new AddThread();
        Thread td = new DecThread();
        ta.start();
        td.start();
        try {
            ta.join();
            td.join();
        }catch (InterruptedException e){}
//        如果不使用synchronized的话，每次输出结果都是不一致的
        System.out.println(Counter.counter);
    }
}
class Counter{
    public static int counter = 0;
}

class AddThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10000;i++) {
//            将同一个对象Counter.class用synchronized锁起来，才能使每次只有一个线程可以访问其中的语句
            synchronized (Counter.class) {
                Counter.counter++;
            }
        }
    }
}

class DecThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10000;i++){
//            将同一个对象Counter.class用synchronized锁起来，才能使每次只有一个线程可以访问其中的语句
            synchronized (Counter.class) {
                Counter.counter--;
            }
        }
    }
}
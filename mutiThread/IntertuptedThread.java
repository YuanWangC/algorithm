public class IntertuptedThread {

    public static void main(String[] args){
        Thread t = new MyThread2();
        t.start();
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e){}
//        main中断了t进程
        t.interrupt();
        System.out.println("main is interrupting MyThread2");
//        main等待t结束
        try {
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main is running");
    }
}
/*
If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class,
or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), methods of this class,
then its interrupt status will be cleared and it will receive an InterruptedException.
 */
class HelloThread extends Thread{
    @Override
    public void run(){
        System.out.println("HelloThread is running");
        int n = 0;
//        isInterrupted()可以收到被中断的信号
//        不可以在while中结束进程，线程在sleep时接到中断，中断信号被清除(isInterrupted()是false)
        while(!isInterrupted()){
            n++;
            System.out.println(n+" Hello!");
//            如果收到中断信号时，正好处于sleep状态，直接在catch语句块中break，就可以结束线程
//            try{
//                Thread.sleep(100);
//            }catch (InterruptedException e){
////                break;
//                System.out.println("hello catched InterruptedException");
//                System.out.println(isInterrupted());
//            }
        }
        System.out.println(n +" HelloThread is interrupted.");
    }
}

class MyThread2 extends Thread{
    @Override
    public void run(){
        System.out.println("MyThread2 is running");
        Thread h = new HelloThread();
        h.start();
//        当前线程在在等待h线程结束（join）时，遇到被中断的标志，会抛出InterruptedException的错误，此处被catch处理了
//        此时h的isInterrupted()已经是true了，如果没有sleep的话，h线程可以被直接中断结束
        try{
            h.join();
        }catch (InterruptedException e){
            System.out.println("MyThread2 is interrupted.");
        }
//        如果MyThread2被中断，则需要对h进行中断，否则会一直执行下去
        h.interrupt();
    }
}
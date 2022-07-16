import java.time.LocalTime;

public class TimerThread {
    public static void main(String[] args){
        System.out.println("main:"+LocalTime.now());
    // JVM退出时，不必关心守护线程是否已结束
    // 守护线程不能持有任何需要关闭的资源，例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失
        Thread t = new TimerThreadDae();
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(300);
        }catch (InterruptedException e){}
        System.out.println("main ends.");
    }
}

class TimerThreadDae extends Thread{
    @Override
    public void run(){
        while(true){
            System.out.println("daemon:"+LocalTime.now());
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
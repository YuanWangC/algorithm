import java.time.LocalTime;

public class SynThreadStuAndTeah {
    public static void main(String[] args){
       long start = System.currentTimeMillis();
       Thread ta = new AddStuThread();
       Thread td = new DecStuThread();
       Thread ta2 = new AddTeahThread();
       Thread td2 = new DecTeahThread();
       ta.start();
       td.start();
       ta2.start();
       td2.start();
       try{
          ta.join();
          td.join();
          ta2.join();
          td2.join();
       }catch (InterruptedException e){}
       long end = System.currentTimeMillis();
       System.out.println(end-start);
       System.out.println(STCounter.StuCount +" "+STCounter.TeahCount);
    }
}
class STCounter{
    public static int StuCount = 0;
    public static int TeahCount = 0;
    public static final Object lockStudent = new Object();
    public static final Object lockTeacher = new Object();
}

class AddStuThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<100000;i++){
            synchronized (STCounter.class){
//            synchronized (STCounter.lockStudent){
                STCounter.StuCount++;
            }
        }
    }
}

class DecStuThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<50000;i++) {
            synchronized (STCounter.class){
//            synchronized (STCounter.lockStudent) {
                STCounter.StuCount--;
            }
        }
    }
}

class AddTeahThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<80000;i++) {
            synchronized (STCounter.class){
//            synchronized (STCounter.lockTeacher) {
                STCounter.TeahCount++;
            }
        }
    }
}

class DecTeahThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<40000;i++) {
            synchronized (STCounter.class){
//            synchronized (STCounter.lockTeacher) {
                STCounter.TeahCount--;
            }
        }
    }
}
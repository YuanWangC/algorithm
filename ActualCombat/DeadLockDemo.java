public class DeadLockDemo {
    static A a = new A();
    static B b = new B();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (a){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("get a and b.");
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            synchronized (b){
                synchronized (a){
                System.out.println("get a and b.");
                }
            }
        }).start();
    }
}

class A{}
class B{}
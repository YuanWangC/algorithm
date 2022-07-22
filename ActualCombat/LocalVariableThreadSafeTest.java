package ActualCombat;

import java.util.TreeMap;

public class LocalVariableThreadSafeTest {
//    static StringBuilder sb = new StringBuilder();
    //线程私有局部变量，安全
    public static void m1(){
        StringBuilder sb = new StringBuilder();
        sb.append("A");
        sb.append("B");
        sb.append("C");
        sb.append("D");
        System.out.println(sb);
    }

    //共享变量（栈上逃逸），并非线程私有，不安全
    public static void m2(StringBuilder sb){
        for(int i=0;i<26;i++) {
            char c = (char) ('A'+i);
            sb.append(c);
        }
        System.out.println(sb);
    }

    //局部变量被返回，可以被其他线程修改，存在线程安全问题
    public static StringBuilder m3(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            char c = (char) ('A'+i);
            sb.append(c);
        }
        return sb;
    }
    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        new Thread(()->{
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            m1();
            m2(sb);
//            sb = m3();
//            System.out.println(sb);
        }).start();
        Thread.sleep(5);
        for(int i=0;i<26;i++) {
            char c = (char) ('a'+i);
            sb.append(c);
        }
        System.out.println(sb);
    }
}

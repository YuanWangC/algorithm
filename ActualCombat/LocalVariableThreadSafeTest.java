import java.util.TreeMap;

public class LocalVariableThreadSafeTest {
    //线程私有局部变量，安全
    public static void m1(){
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        System.out.println(sb);
    }

    //共享变量（栈上逃逸），并非线程私有，不安全
    public static void m2(StringBuilder sb){
        sb.append("a");
        System.out.println(sb);
    }

    //局部变量被返回，可以被其他线程修改，存在线程安全问题
    public static StringBuilder m3(){
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        return sb;
    }
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append("c");
        sb.append("d");
        new Thread(()->{
            m2(sb);
        }).start();
    }
}

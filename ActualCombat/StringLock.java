public class StringLock {
    public static void lockTest(String s) throws InterruptedException {
        synchronized (s){
            Thread.sleep(100);
            System.out.println(s);
        }
    }
    public static void main(String[] args){
        String a = "aaa"; // 常量池
        String b = "bbb"; // 常量池
        String c = a + b; // JVM堆
        String d = "aaa" + "bbb"; // 常量池
        String e = "aaabbb"; // 常量池
        System.out.println(c == d); // false
        System.out.println(d == e);// true
        System.out.println(c.intern() == d); // true
        Runtime o = Runtime.getRuntime();
        o.freeMemory();
    }
}

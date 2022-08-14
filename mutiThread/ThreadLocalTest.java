public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Source.getSource());
                System.out.println(Source.getSource());
                System.out.println(Source.getSource());
            }, "t" + (i + 1)).start();
        }
    }
}

class Source{
    private String name;
    private static final ThreadLocal<Source> tl= new ThreadLocal<>();
    public Source(){}
    public Source(String s){
        this.name = s;
    }
    public static Source getSource(){
        Source s = tl.get();    //到当前线程获取资源
        if(s==null){
            s = new Source();
            tl.set(s);      //将资源放入当前线程
        }
        return s;
    }
}
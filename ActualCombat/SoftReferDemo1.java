import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferDemo1 {
    private static final int _5GB = 5*1024*1024*1024;
//    private static final int _4MB = 4*1024*1024;
    public static void soft(){
        // List-(强)->SoftReference-(软)->byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        // 定义引用队列。用于清除无对象的软引用
        ReferenceQueue<byte[]> que = new ReferenceQueue<>();
        for(int i=0;i<15;i++){
        // 添加ReferenceQueue，给软引用关联引用队列，引用的对象被回收时，软引用会自行加入队列
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_5GB],que);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("allocate and GC end. "+list.size());

        // 手动删除引用队列中无用的软引用
        Reference<? extends byte[]> poll = que.poll();
        while(poll!=null) {
            list.remove(poll);
            poll = que.poll();
        }

        for(SoftReference<byte[]> ref:list){
            System.out.println(ref.get());
        }
        System.out.println("After GC: "+list.size());
    }
    public static void main(String[] args) throws IOException {
//        System.out.println(Runtime.getRuntime().maxMemory());
//        不重要数据大量存储，触发OutOfMemory的代码
//        List<byte[]> list = new ArrayList<>();
//        for(int i=0;i<15;i++){
//            list.add(new byte[_5GB]);
//        }
//        System.in.read();
        SoftReferDemo1.soft();
    }
}

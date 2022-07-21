import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferDemo1 {
    private static int _5GB = 5*1024*1024*1024;
    public static void main(String[] args) throws IOException {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for(int i=0;i<15;i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_5GB]);
            list.add(ref);
            for(WeakReference<byte[]> w:list){
                System.out.print(w.get()+" ");
            }
            System.out.println();
        }
        System.out.println("end. "+list.size());
    }
}

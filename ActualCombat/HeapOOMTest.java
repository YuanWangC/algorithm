import java.util.ArrayList;
import java.util.List;

public class HeapOOMTest {
    public static void main(String[] args){
        int count = 0;
        try {
            List<String> l = new ArrayList<>();
            String h = "hello";
            while(true){
                l.add(h);
                h = h+h;
                count++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }
}

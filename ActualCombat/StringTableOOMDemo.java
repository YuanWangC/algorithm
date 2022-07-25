import java.util.ArrayList;
import java.util.List;

public class StringTableOOMDemo {
    public static void main(String[] args){
        List<String> l = new ArrayList<>();
        int count = 0;
        try {
            for (int i = 0; i < 260000; i++) {
                l.add(String.valueOf(i).intern());
                count++;
            }
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(count);
        }
    }
}

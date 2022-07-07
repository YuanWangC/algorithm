package Basic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class NumberOfPermutation {
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.
//    HashSet<String> set = new HashSet();
    StringBuilder sb = new StringBuilder();
    ArrayList<String> res = new ArrayList<>();
    boolean[] flag;
    static int x = 0;
    public void search(char[] arr){
        if(sb.length() == arr.length){
//            set.add(sb.toString());
            res.add(new String(sb));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i] == arr[i-1] && !flag[i-1])continue;
            if(flag[i])continue;
            sb.append(arr[i]);
            flag[i] = true;
            search(arr);
            flag[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s.length()==0){
            System.out.println(0);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<65 ||s.charAt(i)>90){
                System.out.println(0);
                return;
            }
        }
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        NumberOfPermutation obj = new NumberOfPermutation();
        obj.flag = new boolean[s.length()];
        obj.search(sc);
//        System.out.println(obj.set);
//        System.out.println(obj.set.size());
        System.out.println(obj.res);
        System.out.println(obj.res.size());
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class MatchReplaceSubstring {
    HashMap<String,String> memo = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    public void match(String s){
        System.out.println(memo);
        System.out.println(s);
        int i = s.indexOf('%');
        if(i == -1)return;
        if(i!=0)
            sb.append(s, 0, i+1);
        int j = s.substring(i+1).indexOf('%')+1;
        if(j>=s.length())return;
        String tag = s.substring(i,j+1);
        System.out.println(tag);
        if(memo.containsKey(tag)){
            sb.append(memo.get(tag));
            match(s.substring(j+1));
        }
        else{
            match(s.substring(i+1));
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String pattern = in.nextLine();
        String[] keys = in.nextLine().split(",");
        String[] vals = in.nextLine().split(",");
        MatchReplaceSubstring obj = new MatchReplaceSubstring();
        for(int i=0;i<keys.length;i++){
            String k = '%'+keys[i]+'%';
            obj.memo.put(k,vals[i]);
        }
        obj.match(pattern);
        System.out.println(obj.sb.toString());
    }
}

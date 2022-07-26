import java.util.HashMap;
import java.util.Scanner;

public class MinimumWindowSubstring {
    HashMap<Character,Integer> memo = new HashMap();
    HashMap<Character,Integer> window = new HashMap();
    public String minWindow(String s, String t) {
        if(s.equals(t))return t;
        int left = 0,right = 0;
        int min = Integer.MAX_VALUE;
        int valid = 0;
        int start = 0,end = 0;
        for(int i=0;i<t.length();i++)
            memo.put(t.charAt(i),memo.getOrDefault(t.charAt(i),0)+1);

        while(right<s.length()){
            char c = s.charAt(right++);
            if(memo.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c) <= memo.get(c)){
                    valid++;
                }
            }
            // System.out.println(window);
            // System.out.println(memo);
            // System.out.println(min);
            // System.out.println(valid);
            while(valid==t.length()){
                if(min>right-left){
                    start = left;
                    end = right;
                    min = right-left;
                }
                char l = s.charAt(left++);
                if(memo.containsKey(l)){
                    if(window.get(l) <= memo.get(l))
                        valid--;
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,end);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.nextLine();
        String t = in.nextLine();
//        System.out.println(s.length());
//        System.out.println(t.length());
        MinimumWindowSubstring object= new MinimumWindowSubstring();
        String res = object.minWindow(s,t);
        System.out.println(res);
    }
}

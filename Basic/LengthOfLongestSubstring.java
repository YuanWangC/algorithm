package Basic;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start = 0,end = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap();
        while(end<s.length() &&start<=end){
            // System.out.println("end:"+s.charAt(end));
            if(map.containsKey(s.charAt(end))){
                // System.out.println("break");
                int newStart = map.get(s.charAt(end))+1;
                while(start<newStart){
                    map.remove(s.charAt(start++));
                }
                map.put(s.charAt(end),end);
            }
            else{
                map.put(s.charAt(end),end);
                int len = end-start+1;
                max = (max>len)?max:len;
            }
             System.out.println(map);
            // System.out.println(start+" "+end);
            end++;
        }
        // System.out.println(end+" "+start);
        return max;
    }
    public static void main(String[] args){
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        LengthOfLongestSubstring obj2 = new LengthOfLongestSubstring();
        System.out.println(obj.equals(obj2));
        int len = obj.lengthOfLongestSubstring("abdcaef");
        System.out.println(len);
        int a = 10000;
        Integer a2 = new Integer(10000);
        Double a3 = new Double(10000.0);
        System.out.println(a2.equals(a3));
//        System.out.println(a3 == a2);
        double b = 10000.0;
        System.out.println(b == a);
        String s = null;
        Integer i = null;
        System.out.println(i);
    }
}
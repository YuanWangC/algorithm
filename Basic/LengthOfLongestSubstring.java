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
    public int lengthOfLongestSubstringDP(String s) {
        if(s.length() <=1)return s.length();
        int[] dp = new int[s.length()+1];
        dp[0] = 0;
        dp[1] = 1;
        HashMap<Character,Integer> map= new HashMap();
        map.put(s.charAt(0),0);
        int pre = -1;
        for(int i=2;i<=s.length();i++){
            if(map.containsKey(s.charAt(i-1))){
                // System.out.println("contains "+s.charAt(i-1));
                pre = Math.max(pre,map.get(s.charAt(i-1))+1);
                // System.out.println(pre);
                map.put(s.charAt(i-1),i-1);
                dp[i] = i-pre;
            }
            else {
                map.put(s.charAt(i-1),i-1);
                dp[i] = dp[i-1]+1;
            }
        }
        // System.out.println(Arrays.toString(dp));
        int max = 0;
        for(int j:dp){
            // System.out.println(j);
            max = max<j?j:max;
        }
        return max;
    }
    public static void main(String[] args){
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        LengthOfLongestSubstring obj2 = new LengthOfLongestSubstring();
        System.out.println(obj.equals(obj2));
        int len1 = obj.lengthOfLongestSubstring("abdcaef");
        int len2 = obj.lengthOfLongestSubstringDP("abdcaef");
        System.out.println(len1+" "+len2);
    }
}
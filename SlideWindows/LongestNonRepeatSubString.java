import java.util.HashMap;
import java.util.Scanner;

/*
    寻找最长不重复的子串，有两种方法，一个是滑动窗口，一个是利用HashMap空间换时间
 */
public class LongestNonRepeatSubString {
    HashMap<Character,Integer> window = new HashMap();
    public int lengthOfLongestSubstring1(String s) {
        int left = 0,right = 0;
        int max = Integer.MIN_VALUE;
        while(right<s.length()){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            right++;
//            System.out.println(window);
            //左边收缩到刚加入的字符不重复为止
            while(window.get(c)>1){
                //左边不论是谁，都得++，都得收缩，直到满足条件
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            if(max<right-left){
                max = right-left;
//                System.out.println(s.substring(left,right));
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() <= 1)return s.length();
        // 到i位置为止，最长的不重复子字符串长度是dp[i]
        int[] dp = new int[s.length()+1];
        dp[0] = 0;
        dp[1] = 1;
        HashMap<Character,Integer> memo = new HashMap();
        memo.put(s.charAt(0),0);
        int pre = 0;
        for(int i=2;i<=s.length();i++){
            char c = s.charAt(i-1);
//            记录所有第一次出现的字符的位置
            if(!memo.containsKey(c)){
                dp[i] = dp[i-1]+1;
                memo.put(c,i-1);
            }
            else{
//                第二次出现，需要收缩
                int cur = memo.get(c)+1;
//                此处取到收缩的最大位置
                pre = cur>pre?cur:pre;
                memo.put(c,i-1);
                dp[i] = i-pre;
                // System.out.println(c+" "+pre+" "+i);
            }
        }
        // System.out.println(Arrays.toString(dp));
        int max = 0;
        for(int k:dp)
            max = k>max?k:max;
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
        String s = "abcbfebb";
        LongestNonRepeatSubString obj = new LongestNonRepeatSubString();
        int len = obj.lengthOfLongestSubstring1(s);
        System.out.println(len);

        int len1 = obj.lengthOfLongestSubstring2(s);
        System.out.println(len1);
    }
}
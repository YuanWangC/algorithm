package String;

import java.util.Scanner;

public class LongestPalindromicSubstring {
    public String find(String s,int left, int right){
        if(s.charAt(left)!=s.charAt(right))return "";
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            // if(s.charAt(left)!=s.charAt(right))break;
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public String longestPalindrome(String s) {
        if(s.length()<=1)return s;
        int max = 0;
        String res = "";
        for(int i=0;i<s.length()-1;i++){
            String res1 = find(s,i,i);
            String res2 = find(s,i,i+1);
            if(res1.length()<res2.length())res1 = res2;
            if(max<res1.length()){
                // System.out.println(res);
                res = res1;
                max = res1.length();
            }
        }
        return res;
    }
    public static void main(String[] args){
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String res = obj.longestPalindrome(s);
        System.out.println(res);
    }
}

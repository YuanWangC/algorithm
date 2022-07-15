package Basic;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class LongestComSubSequence {
    public int longestCommonSubsequence(String text1, String text2) {
//        dp内涵：字符串分别走到第i个和第j个时，最长公共子序列长度是dp[i][j]
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            char c = text1.charAt(i-1);
            for(int j=1;j<=text2.length();j++){
                if(c == text2.charAt(j-1)){
//                    注意此处，是dp[i-1][j-1]+1,i和j都没有选择的基础上加一，否则会重复计算
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        for(int[] a:dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[] args){
        LongestComSubSequence object= new LongestComSubSequence();
        String s1 = "acd";
        String s2 = "abcde";
        int res = object.longestCommonSubsequence(s1,s2);
        System.out.println(res);
    }
}

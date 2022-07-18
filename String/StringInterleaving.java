package String;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StringInterleaving {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s2.length()+s1.length() != s3.length())return false;
//        s1的第i个和s2的第j个字符中是否有至少一个可以匹配s3的第（i+j）个字符
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=1;i<=s1.length();i++){
            dp[i][0] = dp[i-1][0] && (s3.charAt(i-1)==s1.charAt(i-1));
        }
        for(int i=1;i<=s2.length();i++){
            dp[0][i] = dp[0][i-1] &&(s3.charAt(i-1)==s2.charAt(i-1));
        }
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    //  dp[i][j]每次只与其中一个字符串匹配，但是与两个字符串变量有关
                    //  使用或运算，将两种结果统一起来，匹配任意一个就可以将结果置为true，避免了选择顺序（先匹配s1还是s2）
                    //  s3.charAt(i + j - 1)匹配
                    boolean dpi = s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j];
                    boolean dpj = s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1];
                    dp[i][j] = dpi | dpj;
//                    不使用中间变量，可以提高效率
//                    dp[i][j] = (dp[i-1][j] && (s1.charAt(i - 1) == s3.charAt(i + j -1)))|(dp[i][j-1] && (s2.charAt(j - 1) == s3.charAt(j + i -1)));
                }
            }
        for(boolean[] arr:dp)
            System.out.println(Arrays.toString(arr));
        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args){
        StringInterleaving obj = new StringInterleaving();
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
////        String s3 = "aadbbbaccc";
        String s1 = "aa";
        String s2 = "ab";
        String s3 = "abaa";
        boolean res = obj.isInterleave(s1,s2,s3);
        System.out.println(res);
    }
}

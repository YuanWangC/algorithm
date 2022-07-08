package Basic;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<dp.length;i++){
            dp[i][i] = 1;
        }
        for(int i=dp.length-1;i>=0;i--){
            for(int j=i+1;j<dp.length;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        // for(int i=0;i<dp.length;i++)
        // System.out.println(Arrays.toString(dp[i]));
        return dp[0][dp.length-1];
    }
    public static void main(String[] args){
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        String s = "abdcceabbcd";
        int res = obj.longestPalindromeSubseq(s);
        System.out.println(res);
    }
}

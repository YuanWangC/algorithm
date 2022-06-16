public class RegexMatchDP {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=p.length();j++){
                if(j==0 && i!=0)dp[i][j] = false;
                if(j>0){
                    if(p.charAt(j-1) != '*'){                       
                        if(i>0 && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)))
                            dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        if(j >= 2)
                            dp[i][j] |= dp[i][j-2];
                        if(i > 0 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'))
                            dp[i][j] |= dp[i-1][j];
                    }
                }
                System.out.println(dp[i][j]+" "+i+" "+j);
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
    	boolean res = isMatch("aa", "a*");
    	System.out.println(res);
    }
}
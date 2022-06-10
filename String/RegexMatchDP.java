class RegexMatchDP {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // 空字符串和空正则匹配结果为true
        dp[0][0] = true;
        
        // 空字符串和非空正则需要计算
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=p.length();j++){
                // 空正则和非空字符串不需要匹配，结果为false
                if(j==0 && i!=0)dp[i][j] = false;
                if(j>0){
                    if(p.charAt(j-1) != '*'){
                        // 空串不必匹配单个字符
                        if(i>0 && (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)))
                            dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        // 遇上*,匹配到0个字符
                        if(j >= 2)
                            dp[i][j] |= dp[i][j-2];
                        // 遇上*，匹配s上的字符，结果为前一个字符匹配结果&true，不变
                        if(i > 0 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'))
                            dp[i][j] |= dp[i-1][j];
                    }
                }
                System.out.println(dp[i][j]+" "+i+" "+j);
            }
        }
        return dp[s.length()][p.length()];
    }
}
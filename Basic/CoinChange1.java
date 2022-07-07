package Basic;

import java.util.Arrays;

public class CoinChange1 {
    public int coinChange(int[] coins, int amount) {
        // 使用前i种硬币，凑成j面额，最少需要dp[i][j]个硬币数
        int[][] dp = new int[coins.length+1][amount+1];
        for(int j = 1;j <=amount;j++)
            dp[0][j] = Integer.MAX_VALUE;
        for(int i=0;i<=coins.length;i++)
            dp[i][0] = 0;
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                // 还是完全背包
                // dp[i][j-coins[i-1]]+1指的是用前i个硬币凑成面额j-coins[i-1]，再加一个i硬币，为将第i硬币加入后的数量
                if(j>=coins[i-1] && dp[i][j-coins[i-1]]!=Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][amount]==Integer.MAX_VALUE?-1:dp[coins.length][amount];
    }
    public int coinChange2(int[] coins, int amount) {
//        最少使用dp[i]个硬币可以凑成i元面额
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]>i)break;
                if(i>=coins[j])
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
    public static void main(String[] args){
        CoinChange1 obj = new CoinChange1();
        int amount = 11;
        int[] coins = {1,2,5};
        int res1 = obj.coinChange(coins,amount);
        int res2 = obj.coinChange(coins,amount);
        System.out.println(res1);
        System.out.println(res2);
    }

}

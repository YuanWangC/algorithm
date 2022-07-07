package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    int amount;
    int subAmount;
    int subCount;
    List<Integer> path;
//    回溯不清理path内容，add和remove操作可以直接修改内容
    public void search(int[] coins,int index){
        if(index>=coins.length || coins[index]>amount || subAmount > amount)return;
        if(subAmount == amount){
            subCount++;
//            path = new ArrayList();
            return;
        }
        for(int i=index;i<coins.length;i++){
            subAmount+=coins[i];
            path.add(coins[i]);
//            System.out.println(i+" "+subCount+" "+subAmount +" "+path);
//            可重复使用的coin，冲i开始，否则从i+1开始
            search(coins,i);
            subAmount-=coins[i];
//            固定搭配
            path.remove(path.size()-1);
        }
    }
//    回溯
    public int change1(int amount, int[] coins) {
        this.amount = amount;
        Arrays.sort(coins);
        this.subAmount = 0;
        this.subCount = 0;
        this.path = new ArrayList();
//        从0开始将所有情况都遍历了
        search(coins,0);
        return subCount;
    }
//    DP
    public int change2(int amount, int[] coins) {
        if(amount == 0)return 1;
        Arrays.sort(coins);
        // 表示使用第i个硬币凑出面额为j的金额有dp[i][j]种方法
        int[][] dp = new int[2][amount+1];
        // base case
        // for(int i=1;i<=amount;i++)
        //     dp[0][i] = 0;
        // for(int i=0;i<=coins.length;i++)
        //     dp[i][0] = 1;
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                // 不将第i个凑到零钱中，方法数不变
                // 将第i个凑到零钱中，相当于只考虑用前i个硬币凑j-coins[i]的面额（i从1开始，因此是i-1）
                if(j-coins[i-1]>=0)
                    dp[i%2][j] = dp[(i-1)%2][j] + dp[i%2][j-coins[i-1]];
                else dp[i%2][j] = dp[(i-1)%2][j];
            }
        }
        return dp[(coins.length)%2][amount];
    }
    public static void main(String[] args){
        CoinChange obj = new CoinChange();
        int amount = 5;
        int[] coins = {1,2,5};
        int res1 = obj.change1(amount,coins);
        int res2 = obj.change2(amount,coins);
        System.out.println(res1);
        System.out.println(res2);
    }
}

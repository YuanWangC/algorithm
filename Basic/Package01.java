package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class Package01 {
    public int fillpackage(int n,int w,int[] vs,int[] ws){
//        内涵：dp[i][j]表示在剩余容量为j的背包中装进前i个物品可以获得的最大价值
        int[][] dp = new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++) {
//            剩余容量充足
                if (j >= ws[i-1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - ws[i-1]] + vs[i-1]);
                }
//            剩余容量不足，第i个物品无法选择
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            System.out.println(i+" "+dp[i][w]);
        }
//        返回容量为w的背包中装进n个物品可以获得的最大价值
        return dp[n][w];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = in.nextInt();
            int weightP = in.nextInt();
            in.nextLine();
            String[] values = in.nextLine().split(",");
            String[] weights = in.nextLine().split(",");
            int[] valuesInt = new int[n];
            int[] weightInt = new int[n];
            for (int i = 0; i < n; i++) {
                valuesInt[i] = Integer.parseInt(values[i]);
                weightInt[i] = Integer.parseInt(weights[i]);
            }
            Package01 obj = new Package01();
            int res = obj.fillpackage(n, weightP, valuesInt, weightInt);
            System.out.println(res);
        }
    }
}

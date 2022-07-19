import java.util.Arrays;

public class CoinExchange {
    int count = 0;
    int amount;
    int sum = 0;
    int min = Integer.MAX_VALUE;
    public void dfs(int[] arr,int index){
        if(sum == amount){
            if(min>count){
                min = count;
            }
            return;
        }
        if(sum>amount)return;
        for(int i=index;i<arr.length;i++){
            sum+=arr[i];
            count++;
            dfs(arr,i);
            sum-=arr[i];
            count--;
        }
    }
    public int coinChange2(int[] coins, int amount) {
        this.amount = amount;
        dfs(coins,0);
        if(min!=Integer.MAX_VALUE)return min;
        return -1;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
//                未排序所以继续执行
                if(coins[j]>i)continue;
                dp[i]= Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        if(dp[amount] == amount+1)return -1;
        return dp[amount];
    }
    public static void main(String[] args){
        CoinExchange object= new CoinExchange();
//        int[] coins = {1,2,5};
//        int target = 11;
        //该输入用DFS会超时
        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
        int target = 9864;

        long start1 = System.currentTimeMillis();
        int res = object.coinChange(coins,target);
        System.out.println(res);
        System.out.println(System.currentTimeMillis()-start1);

        long start2 = System.currentTimeMillis();
        int res2 = object.coinChange2(coins,target);
        System.out.println(res2);
        System.out.println(System.currentTimeMillis()-start2);
    }
}

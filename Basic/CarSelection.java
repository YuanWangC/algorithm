package Basic;

import java.util.Arrays;

public class CarSelection {
    int max = 0;
    int days;
    public void bfs(int arr1[],int i,int[] arr2, int sum,char action){
//        System.out.println(i+" "+action);
        if(i>=days)return;
        if(i==days-1){
            if(action == 'A')sum+=arr1[i];
            else sum+=arr2[i];
//            System.out.println(sum);
            if(sum>max){
                max = sum;
            }
            return;
        }
        if (action == 'A') {
            sum += arr1[i];
            bfs(arr1, i + 1, arr2, sum, 'A');
            bfs(arr1, i + 2, arr2, sum, 'B');
        } else if (action == 'B') {
            sum += arr2[i];
            bfs(arr1, i + 1, arr2, sum, 'B');
            bfs(arr1, i + 2, arr2, sum, 'A');
        }
    }
    public int chose1(int n,int arr1[],int[] arr2){
        days = n;
        if(arr1[0]>arr2[0])
            bfs(arr1,0,arr2,0, 'A');
        else bfs(arr1,0,arr2,0,'B');
        return max;
    }
    public int chose2(int n,int arr1[],int[] arr2){
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        if(arr1[0]<arr2[0]){
            dp[1][1] = arr2[0];
            dp[2][1] = arr2[0]+arr2[1];
        }
        else{
            dp[1][0] = arr1[0];
            dp[2][0] = arr1[0]+arr1[1];
        }
        for(int i=2;i<=n;i++){
            if(arr1[i-1]>arr2[i-1]){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-2][1])+arr1[i-1];
            }
            else{
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][1])+arr2[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[n][0],dp[n][1]);
    }
    public static void main(String[] args){
        int k=4;
        int[] arr1 = {11,2,2,9};
        int[] arr2 = {4,1,21,23};
        CarSelection obj = new CarSelection();
        long start = System.currentTimeMillis();
        int res1 = obj.chose1(k,arr1,arr2);
        System.out.println(res1);
        System.out.println(System.currentTimeMillis()-start);
        long start2 = System.currentTimeMillis();
        int res2 = obj.chose1(k,arr1,arr2);
        System.out.println(res2);
        System.out.println(System.currentTimeMillis()-start2);
    }
}

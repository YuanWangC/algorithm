package Basic;

import java.util.Arrays;
import java.util.HashMap;

public class MouseEscape {
    double[] memoA;
    double[] memoB;
    int[] a = {1,3};
    int[] b = {2,3};
    int k;
    int n;
    double min = Integer.MAX_VALUE;
    public void dfs(int ca,int cb,int index,double sum,boolean isA) {
        if(ca*cb<0)return;
        if(index>=n)return;
        if(isA) {
            sum += memoA[index++];
            ca--;
        }
        else {
            sum += memoB[index++];
            cb--;
        }
        if(ca == 0 && cb ==0) {
//            System.out.println(sum);
             if(sum<min) {
                min = sum;
             }
             return;
        }
        dfs(ca,cb,index,sum,true);
        dfs(ca,cb,index,sum,false);
    }
    public double count2(double a,double b){
        return Math.pow(a-b,2);
    }
    public double count(double[][] arr){
        for(int i=0;i<arr.length;i++){
            memoA[i] = Math.sqrt(count2(arr[i][0],a[0])+count2(arr[i][1],a[1]));
        }
        for(int i=0;i<arr.length;i++){
            memoB[i] = Math.sqrt(count2(arr[i][0],b[0])+count2(arr[i][1],b[1]));
        }
        System.out.println(Arrays.toString(memoA));
        System.out.println(Arrays.toString(memoB));
        dfs(k, n - k, 0, 0,true);
        System.out.println(min);
        dfs(k, n - k, 0, 0,false);
        System.out.println(min);
        return min;
    }
//  三维dp(第一维表示老鼠数量，第二维表示跑到哪个洞里，第三维表示逃跑次数,数组表示总和)
    public double minDistance() {
        if(k==0||n==0){
            return 0;
        }
        double[][][] dp=new double[n][2][k+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i][0], Double.MAX_VALUE);
            Arrays.fill(dp[i][1], Double.MAX_VALUE);
        }
        // 初始化三位数组
        for(int i=0;i<=k;i++){
            dp[0][1][i]=0;
            dp[0][0][i]=0;
        }
        for(int i=1;i<=k;i++){
            if(memoA[0]<memoB[0])
                dp[1][1][i]=memoA[0];
            else dp[1][0][i]=memoB[0];
        }
        for(int i=2;i<n;i++){
            for(int j=1;j<=k;j++){
                dp[i][0][j]=Math.min(dp[i-1][0][j],dp[i-1][1][j])+memoA[i];
                dp[i][1][j]=Math.min(dp[i-1][1][j],dp[i-1][0][j])+memoB[i];
            }
        }
        System.out.println(dp[n-1][0][k]+" "+dp[n-1][1][k]);
        return Math.min(dp[n-1][0][k],dp[n-1][1][k]);
    }

    public static void main(String[] args){
        MouseEscape obj = new MouseEscape();
        int n = 5;
        int k =3;
        obj.n = n;
        obj.k = k;
        double[][] arr = {{1,1},{1,2},{1,3},{1,4},{1,5}};
        obj.memoA = new double[n];
        obj.memoB = new double[n];
        double res = obj.count(arr);
        System.out.println(res);
        double res2 = obj.minDistance();
        System.out.println(res2);
    }

}

package Basic;

import java.util.Arrays;

public class NonOverlappingIntervals {
    //贪心
    public int eraseOverlapIntervals1(int[][] intervals) {
        if(intervals.length == 1)return 0;
        Arrays.sort(intervals,(int[] a,int[] b)-> a[1]-b[1]);
        for(int i=0;i<intervals.length;i++)
            System.out.println(Arrays.toString(intervals[i]));
        int pre = intervals[0][1];
        int count = 1;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<pre)continue;
            else{
                count++;
                pre = intervals[i][1];
            }
        }
        return intervals.length-count;
    }
    //动态规划
    public int eraseOverlapIntervals2(int[][] intervals) {
        if(intervals.length <= 1)return 0;
        Arrays.sort(intervals,(int[] a,int[] b)-> a[0]-b[0]);
         for(int i=0;i<intervals.length;i++)
             System.out.println(Arrays.toString(intervals[i]));
        // i个区间可以构成的最大不重叠区间数为dp[i]
        int[] dp = new int[intervals.length+1];
        Arrays.fill(dp,1);
        for(int i=2;i<=intervals.length;i++){
            for(int j=1;j<i;j++){
                if(intervals[i-1][0]>=intervals[j-1][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // System.out.println(i+" "+dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return intervals.length-dp[intervals.length];
    }
    public static void main(String[] args){
        NonOverlappingIntervals obj = new NonOverlappingIntervals();
        int[][] intervals = {{1,2},{2,4},{2,3},{4,5}};
        int res1 = obj.eraseOverlapIntervals1(intervals);
        int res2 = obj.eraseOverlapIntervals2(intervals);
        System.out.println(res1+" "+res2);
    }
}

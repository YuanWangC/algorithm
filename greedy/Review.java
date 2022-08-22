import java.util.*;
/*
输入：
2 1
89 38
445 754
输出：
1150.05
*/
public class Review {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        double[] score = new double[n];
        double[] per = new double[n];
        double[] init = new double[n];
        for(int i=0;i<n;i++){
            per[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            score[i] = in.nextInt();
            init[i] = score[i]*per[i]/100.0;
        }
        double[][] minsum = new double[n][2];
        double sum = 0;
        for(int i=0;i<n;i++){
            minsum[i][0] = i;
            minsum[i][1] = score[i]-init[i];
        }
        Arrays.sort(minsum,(o1,o2)->{
            return (int)(o2[1]-o1[1]);
        });
        for(int i=0;i<n;i++){
            int id = (int)minsum[i][0];
            if(i<m)
            sum += score[id];
            else sum+=init[id];
        }
        System.out.printf("%.2f",sum);
    }
}

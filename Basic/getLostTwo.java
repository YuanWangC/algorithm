package Basic;

import java.util.HashMap;
import java.util.Scanner;

public class getLostTwo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n-2];
        int sum = 0;
        for(int i=0;i<n-2;i++){
            arr[i] = in.nextInt();
            sum +=arr[i];
        }
        int sumTotal = n*(1+n)/2;
        int twosum = sumTotal-sum;
        int val = twosum/2;
        int sumValTotal = val*(1+val)/2;
        int sumVal = 0;
        for(int i=0;i<n-2;i++){
            if(arr[i]<=val)
                sumVal+=arr[i];
        }
        int val1 = sumValTotal-sumVal;
        int val2 = twosum-val1;
        System.out.println(val1+" "+val2);
        HashMap<Integer,Integer> memo = new HashMap<>();

    }
}

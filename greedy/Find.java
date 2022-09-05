package greedy;

import java.util.Scanner;

public class Find {
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
            if(arr[i]>max)max = arr[i];
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==max)count++;
        }
        System.out.println(n-count);
    }
}

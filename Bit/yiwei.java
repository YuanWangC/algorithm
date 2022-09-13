package Bit;

import java.util.Scanner;

public class yiwei {
    public static int deal(long a,long b){
        boolean Can8 = true,Can4 = true,Can2 = true;
        boolean flag = false;
        int count = 0;
        if(a%8!=0)Can8 = false;
        if(a%4!=0)Can4 = false;
        if(a%2!=0)Can2 = false;
        while(a>b){
            if(!Can2 &&!Can4 &&!Can8){
                flag = false;
                break;
            }
            if(a%8==0 && Can8){
                long t = a>>>3;
                if(t<b){
                    Can8 = false;
                    continue;
                }
                else{
                    a = a>>>3;
                    count++;
                }
            }else if(a%4==0 && Can4){
                long t = a>>>2;
                if(t<b){
                    Can4 = false;
                    continue;
                }
                else{
                    a = a>>>2;
                    count++;
                }
            }else if(a%2==0 && Can2){
                long t = a>>>1;
                if(t<b){
                    Can2 = false;
                    continue;
                }
                else{
                    a = a>>>1;
                    count++;

                }
            }
            if(a==b){
                flag = true;
                break;
            }
        }
        if(!flag) return -1;
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] arr = new long[n][2];
        in.nextLine();
        for(int i=0;i<n;i++){
            String[] s = in.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            long a = arr[i][0];
            long b = arr[i][1];
            if(a<b){
                long temp = a;
                a = b;
                b = temp;
            }
            res[i] = deal(a,b);
        }
        for(int i=0;i<n;i++)
            System.out.println(res[i]);
    }
}
/*
4
3 6
16 2
12 4
1024 1
 */
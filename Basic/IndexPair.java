package Basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IndexPair {
    public int count(int[] arr){
        if(arr.length == 0)return 0;
        if(arr.length == 2 && arr[1]-arr[0] == 1)return 1;
        int c = 0;
        for(int j=0;j<arr.length;j++){
            for(int i=0;i<j;i++){
                if(arr[i]-arr[j] == i-j)c++;
            }
        }
        return c;
    }
    public int count2(int[] arr){
        HashMap<Integer,Integer>memo = new HashMap<>();
        int res = 0;
        for(int i=0;i<arr.length;i++){
            int a = arr[i] - i;
            if(memo.containsKey(a))
                memo.put(a,memo.get(a)+1);
            else memo.put(a,1);
        }
        for(Integer i:memo.values()) {
            if(i>1)
                res += (i-1)*i/2;
        }
//        System.out.println(res);
        return res;
    }
    public static void main(String[] args){
//        int[] arr = {3,5,1,4,6,6};
//        int[] arr = {1,2,3};
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        IndexPair obj = new IndexPair();
        while(k>0 && in.hasNext()){
            k--;
            int l = in.nextInt();
//            in.nextLine();
//            System.out.println(l);
//            String[] s = in.nextLine().split(" ");
//            System.out.println(Arrays.toString(s));
            int[] arr = new int[l];
            for(int i=0;i<l;i++){
//                arr[i] = Integer.parseInt(s[i]);
                arr[i] = in.nextInt();
            }
            int res = obj.count2(arr);
            System.out.println(res);
        }

    }
}

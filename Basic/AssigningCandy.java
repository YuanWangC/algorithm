package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class AssigningCandy {
    public int candy(int[] ratings) {
        if(ratings.length == 1)return 1;
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i-1]<ratings[i])res[i] = res[i-1]+1;
        }
//         Math.max(res[i],res[i+1]+1)用于保留左侧循环得到的值，否则可能被右侧修改
//        例如：[1,2,3,4,5,2]中的5应该保留左侧得到的4个糖果，而不是右侧得到的2个糖果
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i])res[i] = Math.max(res[i],res[i+1]+1);
        }
        int sum = 0;
        for(int i=0;i<res.length;i++){
            sum+=res[i];
        }
        // System.out.println(Arrays.toString(res));
        return sum;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] ratings = in.nextLine().split(",");
        int[] rat = new int[ratings.length];
        for(int i=0;i<ratings.length;i++)
            rat[i] = Integer.parseInt(ratings[i]);
        AssigningCandy obj = new AssigningCandy();
        int res = obj.candy(rat);
        System.out.println(res);
    }
}

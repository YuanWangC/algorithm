import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//求数组中，可以整除3的最大和
public class TheLargestSumDivisibleBy3 {
    public static int maxSumDivThree(int[] arr){
        int sum = 0;
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for(int i:arr){
            if(i%3==1)one.add(i);
            if(i%3==2)two.add(i);
            sum+=i;
        }
        if(sum%3==0)return sum;
//        排序，之后就减最小的
        Collections.sort(one);
        Collections.sort(two);
//        余数为1，减去一个余数为1的或者两个余数为2的数
        int ans = 0;
//        排序，之后就减最小的
        Collections.sort(one);
        Collections.sort(two);
//        余数为1，减去一个余数为1的或者两个余数为2的数
        if(sum%3==1){
            int s1=0,s2=0;
            if(one.size()>=1)s1 = sum-one.get(0);
            if(two.size()>=2)s2 = sum-two.get(0)-two.get(1);
            ans = Math.max(ans,Math.max(s1,s2));
        }
//        余数为2，减去一个余数为2的或者两个余数为1的数
        if(sum%3==2){
            int s1=0,s2=0;
            if(two.size()>=1)s2 = sum-two.get(0);
            if(one.size()>=2)s1 = sum-one.get(0)-one.get(1);
            ans = Math.max(ans,Math.max(s1,s2));
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4};
        System.out.println(TheLargestSumDivisibleBy3.maxSumDivThree(arr));
    }
}

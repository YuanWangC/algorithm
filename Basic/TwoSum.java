package Basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2){
            if(nums[0]+nums[1] == target)return new int[]{0,1};
            else return new int[0];
        }
//        用于存储当前下标i的数nums[i]，需要一个数字t，组合成为和是target的数组
        HashMap<Integer,Integer> memo = new HashMap();
        for(int i=0;i<nums.length;i++){
//           当前数为nums[i],需要查找一个t（在memo形式为{nums[i],X},nums[X]=t）构成结果
            int t = target-nums[i];
//            memo中不存在需要值为nums[i]的数时
            if(!memo.containsKey(nums[i]))
                memo.put(t,i);
//            memo中已经存在需要值为nums[i]的数，可以返回结果
            else return new int[]{i,memo.get(nums[i])};
        }
        return new int[0];
    }
    public static void main(String[] args){
        TwoSum obj = new TwoSum();
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.nextLine(); //用于回收上一个回车
        String[] arrS = in.nextLine().split(",");
        int[] arr = new int[arrS.length];
        for(int i=0;i<arr.length;i++)
            arr[i] = Integer.parseInt(arrS[i]);
        int[] res = obj.twoSum(arr,target);
        System.out.println(Arrays.toString(res));
    }
}

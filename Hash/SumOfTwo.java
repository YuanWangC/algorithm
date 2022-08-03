import java.util.Arrays;
import java.util.HashMap;
/*
    查找两数之和为target的下标，数组中没有重复数字
 */
public class SumOfTwo {
    public int[] twoSum(int[] nums, int target) {
//        哈希表中保存下标为i的数需要的另一个数target-nums[i]
        HashMap<Integer,Integer> memo = new HashMap();
//        不需要分开计算，在同一个循环中即可
        for(int i=0;i<nums.length;i++){
            int t = target-nums[i];
//            i以前有没有遇到可以使和为target的数，即：已经知道target-nums[i]，求nums[i]是否存在
            if(!memo.containsKey(nums[i]))
                memo.put(t,i);
//          所求数不包括自己（3+3=6）
            else return new int[]{i,memo.get(nums[i])};
        }
        return new int[0];
    }
    public static void main(String[] args){
        SumOfTwo object = new SumOfTwo();
        int[] nums = {3,2,4};
        int k = 6;
        int[] res = object.twoSum(nums,k);
        System.out.println(Arrays.toString(res));
    }
}
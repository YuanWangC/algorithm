package Basic;

import java.util.Arrays;

public class ShortestSubArray {
//滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0){
            if(target == nums[0])return 1;
            else return 0;
        }
        int left = 0,right = 0;
        int sum = 0,count = Integer.MAX_VALUE;
        while(left<nums.length){
            //    如果小于target就继续扩大窗口
            if(sum<target && right<nums.length){
                sum+=nums[right++];
            }
            //    如果窗口不能继续扩大,就尝试缩小窗口
            else{
            //    已经满足大于等于target条件,一边从左边缩小窗口,一边求一个最小长度
                if(sum>=target){
                    int cur = right-left;
                    System.out.println(Arrays.toString(Arrays.copyOfRange(nums,left,right)));
                    count = Math.min(count,cur);
                    sum-=nums[left];
                }
                //   否则直接缩小窗口
               left++;
            }
        }
        if(count == Integer.MAX_VALUE)return 0;
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2,3,1,2,4,3};
        ShortestSubArray obj = new ShortestSubArray();
        int res = obj.minSubArrayLen(7,arr);
        System.out.println(res);
    }
}

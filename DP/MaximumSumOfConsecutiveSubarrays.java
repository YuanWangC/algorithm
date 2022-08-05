public class MaximumSumOfConsecutiveSubarrays {
//    不使用数组，直接使用两个变量保存状态，非常省时省空间
    public int maxSubArray2(int[] nums) {
        int pre = 0,cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            cur = Math.max(pre + nums[i-1],nums[i-1]);
            max = cur>max?cur:max;
            pre = cur;
        }
        return max;
    }
//
    public int maxSubArray1(int[] nums) {
        int pre = 0,cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            cur = Math.max(pre + nums[i-1],nums[i-1]);
            max = cur>max?cur:max;
            pre = cur;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSumOfConsecutiveSubarrays obj = new MaximumSumOfConsecutiveSubarrays();
        System.out.println(obj.maxSubArray1(arr));
    }
}
/*
给定一个含有n个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class ShortestLengthGreaterThanTarget {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0,right = 0;
        int min = nums.length+1;
        int curSum = 0;
        while(right<nums.length){
            int cur = nums[right++];
            curSum+=cur;
            while(curSum>=target){
                if(min>right-left){
                    min = right-left;
                }
                curSum-=nums[left++];
            }
        }
        //注意处理结果为0的用例
        if(min == nums.length+1)return 0;
        return min;
    }
    public static void main(String[] args){
        int target = 7;
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, arr));
    }
}
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
//                负数是越乘越小的，计算乘积的最大值，要选择与上一个的最小值相乘
                dpmax[i] = Math.max(dpmin[i-1]*nums[i],nums[i]);
                dpmin[i] = Math.min(dpmax[i-1]*nums[i],nums[i]);
            }
            else{
                dpmax[i] = Math.max(dpmax[i-1]*nums[i],nums[i]);
                dpmin[i] = Math.min(dpmin[i-1]*nums[i],nums[i]);
                // System.out.println(nums[i-1]+" "+dpmax[i]+" "+dpmin[i]);
            }
            //同时比较大小，节省一次循环的时间
            if(max<dpmax[i])max = dpmax[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        MaximumProductSubarray object= new MaximumProductSubarray();
        System.out.println(object.maxProduct(arr));

    }
}
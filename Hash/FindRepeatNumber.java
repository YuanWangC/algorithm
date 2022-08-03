/*
    查找数组中出现重复的数字，数组内数字的取值范围[0,n-1]
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        if(nums.length == 2 && nums[0] == nums[1])return nums[0];
        // 将num[i]上的数换成i(0位置放0,1位置放1···n位置放n)
        for(int i=0;i<nums.length;i++){
            while(nums[nums[i]]!=nums[i]){
                swap(nums,i,nums[i]);
            }
        }
        // System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            //  将出现重复的数字返回
            if(nums[i]!=i)return nums[i];
        }
        return -1;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        FindRepeatNumber obj = new FindRepeatNumber();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int res = obj.findRepeatNumber(nums);
        System.out.println(res);
    }
}
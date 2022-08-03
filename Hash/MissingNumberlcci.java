/*
    只有一个数缺失了，数组内的数范围在[0,n]
 */
public class MissingNumberlcci {
    public int missingNumber(int[] nums) {
        if(nums.length ==0)return -1;
        for(int i=0;i<nums.length;i++){
            while(nums[i]<nums.length && nums[nums[i]] != nums[i]){
                swap(nums,i,nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i)return i;
        }
//        0到n-1都归位了，缺失的那个就是n
        return nums.length;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //将序号和数组都异或起来，相同的互相抵消
    public int missingNumber2(int[] nums) {
       if(nums.length ==0)return -1;
       int n = nums.length;
       int sum = 0;
       for(int i=0;i<n;i++){
           sum^=i;
           sum^=nums[i];
       }
//      序号n也需要单独异或一次，因为有可能数组某个元素就是数值n
       sum^=n;
       return sum;
    }
    public static void main(String[] args){
        MissingNumberlcci obj = new MissingNumberlcci();
        int[] nums = {-1,0,2,2,1,1};
        int res = obj.missingNumber(nums);
        System.out.println(res);
    }
}
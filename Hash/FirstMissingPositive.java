/*
    求数组中第一个缺失的正整数，时间O(n)空间O(1)
 */
public class FirstMissingPositive {
    /*
    原地哈希的方法
     */
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)return 1;
        for(int i=0;i<nums.length;i++){
            //  均摊时间复杂度，将num[i]上的值改为i+1(0位置放1,1位置放2···n-1位置放n)
            // 最极端的一种情况是，在第 1 个位置经过这个 while 就把所有的元素都看了一遍，这个所有的元素都被放置在它们应该在的位置，那么 for 循环后面的部分的 while 的循环体都不会被执行。
            while(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums,i,nums[i]-1);
            }
            // System.out.println(Arrays.toString(nums));
        }
        //  返回第一个不在位置上的数应有的值
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)return i+1;
        }
        //  如果都在位置上，即[1,2,3,4,5···]，那么缺失的就是最后一个数+1
        return nums.length+1;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] nums = {-1,0,2,2,1,1};
        int res = obj.firstMissingPositive(nums);
        System.out.println(res);
    }
}
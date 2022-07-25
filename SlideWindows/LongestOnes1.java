public class LongestOnes1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0,r = 0,sum = 0;
        while(r<nums.length){
            if(nums[r] == 0){
                r++;
                l = r;
            }
            else{
                // System.out.println(r+" "+l);
                sum = Math.max(sum,r-l+1);
                r++;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        LongestOnes1 obj = new LongestOnes1();
        int[] arr ={1,1,0,1,1,1};
        int res = obj.findMaxConsecutiveOnes(arr);
        System.out.println(res);
    }
}

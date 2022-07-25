public class LongestOnes3 {
    /*
    经典滑动窗口，右边无脑前进，左边按照k的大小收缩
     */
    public int longestOnes(int[] nums, int k) {
        int l = 0,r = 0;
        int m = 0;
        while(r<nums.length){
            if(nums[r] == 0)k--;
            r++;
            //收缩到k>=0为止
            while(k<0){
                if(nums[l] == 0)k++;
                l++;
            }
            m = Math.max(m,r-l);
        }
        return m;
    }
    public static void main(String[] args){
        LongestOnes3 obj = new LongestOnes3();
        int[] arr ={1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int res = obj.longestOnes(arr,k);
        System.out.println(res);
    }
}

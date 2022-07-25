public class LongestOnesOrZeros {
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

    public int longestZeros(int[] nums, int k) {
        int l = 0,r = 0;
        int m = 0;
        while(r<nums.length){
            if(nums[r] == 1)k--;
            r++;
            //收缩到k>=0为止
            while(k<0){
                if(nums[l] == 1)k++;
                l++;
            }
            m = Math.max(m,r-l);
        }
        return m;
    }
    public static void main(String[] args){
        LongestOnesOrZeros obj = new LongestOnesOrZeros();
        int[] arr ={1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int r1 = obj.longestOnes(arr,k);
        System.out.println(r1);
        int r2 = obj.longestZeros(arr,k);
        System.out.println(r2);
        System.out.println(r1>r2?r1:r2);
    }
}

package Basic;

import java.util.Arrays;

public class MaxsInSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxs;
        if(nums.length==0 || k==0)return new int[0];
        if(nums.length<k) {
            maxs = new int[1];
            k = nums.length;
        }
        else maxs = new int[nums.length-k+1];
        int j = 0;
        for(int i=0;i<maxs.length;i++){
            int temp = 0;
            int max = nums[i];
            while(temp<k){
                max = max<nums[i+temp]?nums[i+temp]:max;
                temp++;
            }
            maxs[j++] = max;
        }
        return maxs;
    }
    public static void main(String[] args){
        MaxsInSlidingWindow obj = new MaxsInSlidingWindow();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] maxs = obj.maxSlidingWindow(arr,k);
        System.out.println(Arrays.toString(maxs));
    }
}

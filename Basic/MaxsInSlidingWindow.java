package Basic;

import java.util.Arrays;
import java.util.HashMap;

public class MaxsInSlidingWindow {
    public int[] maxSlidingWindow1(int[] nums, int k) {
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
//    记录max和maxIndex，减少比较次数，如果仍然落在窗口内，只比较一次
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length==0 || k==0)return new int[0];
        int[] maxs;
        if(nums.length<k) {
            maxs = new int[1];
            k = nums.length;
        }
        else maxs = new int[nums.length-k+1];
        HashMap<Integer,Integer> memo = new HashMap();
        // base case
        int temp = k;
        int max=nums[0],maxIndex=-1;
        int j = 0;
        for(int i=0;i<nums.length-k+1;i++){
            // System.out.println(maxIndex+" "+i);
            if(maxIndex>=i){
                if(max<nums[i+k-1]){
                    max = nums[i+k-1];
                    maxIndex = i+k-1;
                }
            }
            else{
                temp = k-1;
                max=Integer.MIN_VALUE;
                while(temp>=0){
                    if(i+temp<nums.length && max<nums[i+temp]){
                        max = nums[i+temp];
                        maxIndex = i+temp;
                    }
                    temp--;
                }
            }
            // System.out.println(max);
            maxs[j++] = max;
        }
        return maxs;
    }
    public static void main(String[] args){
        MaxsInSlidingWindow obj = new MaxsInSlidingWindow();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] maxs = obj.maxSlidingWindow2(arr,k);
        System.out.println(Arrays.toString(maxs));
    }
}

package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length>256)res = new ArrayList<>(256);
        else res = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        if(nums.length<3 || nums[0]>0 || nums[nums.length-1]<0)return res;
        // System.out.println(Arrays.toString(nums));
        for(int k=0;k<nums.length-2;k++){
            if(k>0 && nums[k] == nums[k-1])continue;
            int i=k+1;
            int j=nums.length-1;
            int sum =-1;
            while(i<j){
                sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    i++;
                }
                else if(sum>0){
                    j--;
                }
                else{
                    ArrayList path = new ArrayList();
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[k]);
                    res.add(path);
                    i++;
                    j--;
                    while(i<j && nums[i] == nums[i-1])i++;
                    while(i<j && nums[j] == nums[j+1])j--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        ThreeSum obj = new ThreeSum();
        Scanner in = new Scanner(System.in);
        String[] arr = in.next().split(",");
        int[] num = new int[arr.length];
        for(int i=0;i<num.length;i++)
            num[i] = Integer.parseInt(arr[i]);
        List<List<Integer>> result = obj.threeSum(num);
        for(List<Integer> r:result)
            System.out.print(r.toString());
        System.out.println();
    }
}

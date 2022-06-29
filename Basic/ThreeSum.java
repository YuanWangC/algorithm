package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {
    List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)break;
            int sum = -nums[i];
            int[] p = search(nums,i,sum);
            System.out.println(Arrays.toString(p));
            if(p.length ==0)continue;
            List<Integer> path = new ArrayList<>();
            path.add(nums[i]);
            path.add(p[0]);
            path.add(p[1]);
            res.add(path);
        }
        return res;
    }

    private int[] search(int[] nums,int index, int sum) {
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]>sum)break;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]+nums[i]>sum)break;
                if(nums[j]+nums[i]==sum)return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
    }

    public static void main(String[] args){
        ThreeSum obj = new ThreeSum();
        Scanner in = new Scanner(System.in);
        String[] arr = in.next().split(",");
        int[] num = new int[arr.length];
        for(int i=0;i<num.length;i++)
            num[i] = Integer.parseInt(arr[i]);
        List<List<Integer>> result = obj.threeSum(num);
        System.out.println("run here");
        for(List<Integer> r:result)
            System.out.print(r.toString());
        System.out.println();
    }
}

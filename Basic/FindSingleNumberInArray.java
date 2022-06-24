package Basic;

import java.util.Arrays;
import java.util.HashMap;

public class FindSingleNumberInArray {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                res ^= nums[i];
                map.put(nums[i],1);
            }
            else if(map.get(nums[i]) == 1){
                res ^= nums[i];
                map.put(nums[i],2);
            }
        }
        return res;
    }
    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<bits.length;j++){
                bits[j]+=(nums[i]&1);
                nums[i]>>>=1;
            }
        }
        System.out.println(Arrays.toString(bits));
        for(int j=0;j<bits.length;j++){
            bits[j]=bits[j]%3;
        }
        System.out.println(Arrays.toString(bits));
        int res = 0;
        for(int j=0;j<bits.length;j++){
            res<<=1;
            res |=bits[31-j];
        }
        return res;
    }
    public int singleNumber3(int[] nums){
        int[] bits = new int[2];    //init:[0,0]
        for(int num:nums){
            bits[0] = bits[0] ^num & ~bits[1];
            bits[1] = bits[1] ^num & ~bits[0];
        }
        return bits[0];
    }
    public static void main(String[] args){
        FindSingleNumberInArray obj = new FindSingleNumberInArray();
        int[] arr = {3,4,3,3};
        int res = obj.singleNumber3(arr);
        System.out.println(res);
    }
}

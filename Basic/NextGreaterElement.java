package Basic;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement {
    HashMap<Integer,Integer> map;
    int[] res;
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        res = new int[nums1.length];
        map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        System.out.println(map);
        for(int i=0;i<nums1.length;i++){
            int index = map.get(nums1[i]);
            int j = index+1;
            for(;j<nums2.length;j++){
                if(nums2[j] > nums2[index])break;
            }
            System.out.println(j);
            if(j>=nums2.length)res[i] = -1;
            else res[i] = nums2[j];
        }
        return res;
    }
    public static void main(String[] args){
        NextGreaterElement obj = new NextGreaterElement();
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] res = obj.nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
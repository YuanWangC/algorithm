package algorithm;
import java.util.HashMap;
//摩尔投票法
public class MajorityElement {
	/*
	public int majorityElement(int[] nums) {
		int vote = 0;
		int mode = -1;
		for(int i = 0;i<nums.length;i++) {
			if(vote == 0) {
				mode = nums[i];
			}
			if(nums[i] == mode) {
				vote++;
			}
			else {
				vote--;
			}
			System.out.println(vote);
		}
		int count = 0;
		for(int num:nums) {
			if(num == mode)count++;
		}
		System.out.println("*********");
		System.out.println(mode);
		System.out.println(count);
		if(count > nums.length/2)
			return mode;
		return -1;
	}*/
	 public int majorityElement(int[] nums) {
	        int k = nums.length/2;
	        HashMap<Integer,Integer> h =new HashMap<>();
	        int i=0;
	        for(;i<nums.length;i++){
	            if(!h.containsKey(nums[i])){
	                h.put(nums[i],1);
	            }    
	            else{
	                int count = h.get(nums[i])+1;
	                h.put(nums[i],count);
	                System.out.println(count);
	                if(count > k) {
	                	return nums[i];
	                }
	            }
	        }
	        return -1;
	        //遍历完整个数组
	        //if(i == nums.length && h.get(nums[--i])>= k)
	         //   return nums[nums.length-1];
	        //return nums[i];
	    }
	public static void main(String[] args) {
		//int[] arr = {1,2,2,2,3,6,2,1};
		int[] arr = {1,2,2,3,4,2};
		MajorityElement m = new MajorityElement();
		int key = m.majorityElement(arr);
		System.out.print(key);
	}
}

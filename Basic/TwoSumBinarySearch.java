package algorithm;

import java.util.Arrays;

public class TwoSumBinarySearch {
	int target;
	public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <2 || target < 0)return new int[0];
        if(nums.length ==2) {
        	if(nums[0]+nums[1] == target)return nums;
        	else return new int[0];
        }
        int left = 0,right = nums.length-1;
        this.target = target;
        int[] res = binarySearch(nums,left,right);
        return res;
    }
	private int[] binarySearch(int[] nums, int left, int right) {
		while(left<=right) {
			if(nums[left]+nums[right] == target) {
				return new int[] {nums[left],nums[right]};
			}
			else if(nums[left]+nums[right] < target) {
				left++;
			}
			else if(nums[left]+nums[right] > target) {
				right--;
			}
		}
		return new int[0];
	}
	public static void main(String[] args) {
		TwoSumBinarySearch t= new TwoSumBinarySearch();
		 //int[] arr = {18,19,25,30,39,41,61,77,88,97};
		 //int key = 59;
		 //int[] arr = {16,16,18,24,30,32};
		 //int key = 48;
		 //int[] arr = {2,7,11,15};
		 //int key = 9;
		 //int[] arr = {10,26,30,31,47,60};
		 //int key = 41;
		 int[] arr = {10,18,25,33,36,50,50,52,57,74};
		 int key = 126;
		 int res[] = t.twoSum(arr, key);
		 System.out.print(Arrays.toString(res));
	 }
}

package algorithm;

import java.util.Arrays;

public class BinarySearch1 {
	public int search(int[] nums, int target) {
		if (nums.length == 0)return -1;
        int left = binarySearchLeft(nums,target);
        //System.out.print(Arrays.toString(nums));
        System.out.println(left);
        int right = binarySearchRight(nums,target);
        //System.out.print(Arrays.toString(nums));
        System.out.println(right);
        if(left!=-1 && right!=-1)
        	return right-left+1;
        return -1;
    }

	public int binarySearchLeft(int[] nums, int target) {
		int left = 0,right = nums.length-1;
		while(left <= right) {
			int mid = left+(right-left)/2;
			if(nums[mid]<target) {
				left = mid+1;
			}
			else if(nums[mid]>target) {
				right = mid-1;
			}
			else if(nums[mid] == target) {
				right = mid-1;
			}
		}
		//left>nums.length-1在前防止越界
		if(left>nums.length-1 || nums[left]!=target)
			return -1;
		return left;
	}

	public int binarySearchRight(int[] nums, int target) {
		int left = 0,right = nums.length-1;
		//此处必须为<=，循环中止条件为left>right，返回right
		//使用<时，中止时left=right，收缩左边界时left = mid+1,left对应的不是target
		while(left <= right) {
			int mid = left+(right-left)/2;
			//System.out.println(left);
			//System.out.println(right);

			if(nums[mid] > target) {
				right = mid-1;
			}
			else if(nums[mid] < target) {
				left = mid+1;
			} 
			else if(nums[mid] == target){
				left = mid+1;
			}
		}
		//System.out.println(right);
		//right<0在前防止越界
		if(right<0 || nums[right]!=target)
			return -1;
		return right;
		
	}
	public static void main(String[] args) {
		BinarySearch1 s = new BinarySearch1();
		//输入必须是升序排序数组
		//int[] arr = {5,7,7,8,8,8,8,8,10};
		int[] arr = {1,3,8};
		int target = 8;
		int res = s.search(arr, target);
		System.out.print(res);
	}
}

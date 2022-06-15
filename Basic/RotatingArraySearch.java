package algorithm;

public class RotatingArraySearch {
	 public boolean search(int[] nums, int target) {
	        int i = 0,j = nums.length-1;
	        while(i<=j){
	            int mid = i+(j-i)/2;
	            if(nums[mid] == target){
	                return true;
	            }
	            if(nums[i] == nums[mid]) {
	            	i++;
	            }
	            //mid处于数组倒置范围中,后半部分有序
	            else if(nums[i]>nums[mid]){
	            	//在有序部分找
	            	if(nums[mid]<target && nums[j]>=target) {
	            		i = mid+1;
	            	}
	            	//有序部分没有target
	            	else {
	            		j = mid-1;
	            	}
	            }
	            //mid处于顺序范围内,前半部分有序
	            else if(nums[i]<nums[mid]){
	            	//在有序部分找
	            	if(nums[mid] > target && nums[i]<=target) {
	            		j = mid-1;
	            	}
	            	//有序部分没有target
	            	else {
	            		i = mid+1;
	            	}
	            }
	        }
	        return false;
	    }
	 public static void main(String[] args) {
		 RotatingArraySearch r=new RotatingArraySearch();
		 //int[] arr = {1,0,1,1,1};
		 //int target = 0;
		 //int[] arr = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
		 //int target = 13;
		 int[] arr = {2,5,6,0,0,1,2};
		 int target = 3;
		 boolean res = r.search(arr, target);
		 System.out.print(res);
	 }
}

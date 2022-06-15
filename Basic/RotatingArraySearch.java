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
	            //mid�������鵹�÷�Χ��,��벿������
	            else if(nums[i]>nums[mid]){
	            	//�����򲿷���
	            	if(nums[mid]<target && nums[j]>=target) {
	            		i = mid+1;
	            	}
	            	//���򲿷�û��target
	            	else {
	            		j = mid-1;
	            	}
	            }
	            //mid����˳��Χ��,ǰ�벿������
	            else if(nums[i]<nums[mid]){
	            	//�����򲿷���
	            	if(nums[mid] > target && nums[i]<=target) {
	            		j = mid-1;
	            	}
	            	//���򲿷�û��target
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

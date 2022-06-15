package algorithm;

public class ReversePairs {
	public int count = 0;
	public int reversePairs(int[] nums) {
		//注意整理边界条件
		if(nums.length == 0)return 0;
		int left = 0,right = nums.length-1;
		partition(nums,left,right);
		return count;
    }
	public int[] partition(int[] nums,int left,int right) {
		if(left == right) {
			int[] arr = {nums[left]};
			return arr;
		}
		int mid = left+(right-left)/2;
		int[] arr1 = partition(nums,left,mid);
		int[] arr2 = partition(nums,mid+1,right);
		return merge(arr1,arr2);
	}
	public int[] merge(int[] arr1,int[] arr2) {
		int count = 0;
		int[] arr = new int[arr1.length+arr2.length]; 
		int left1 = 0,left2 = 0;
		int index = 0;
		int right1=arr1.length-1;
		while(left1<arr1.length && left2<arr2.length) {
			if(arr2[left2]<arr1[left1]) {
				this.count+=right1-left1+1;
				arr[index++]=arr2[left2++];
			}
			else if(arr2[left2]>=arr1[left1]) {
				arr[index++]=arr1[left1++];
			}
		}
		while(left1<arr1.length) {
			arr[index++]=arr1[left1];
			left1++;
		}
		while(left2<arr2.length) {
			arr[index++]=arr2[left2];
			left2++;
		}
		return arr;
	}
	public static void main(String[] args) {
		ReversePairs r = new ReversePairs();
		int[] arr = {};
		//int[] arr= {7,5,6,4};
		r.reversePairs(arr);
		System.out.print(r.count);
	}
}

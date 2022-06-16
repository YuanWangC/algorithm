package Basic;

import java.util.Arrays;
import java.util.Comparator;
class AComparator implements Comparator<String>{
	@Override
	public int compare(String s1,String s2) {
		return (s1+s2).compareTo(s2+s1);
	}
	
}
public class ArrayToMinNumber {
	 public String minNumber(int[] nums) {
	     String[] s = new String[nums.length];
	     for(int i=0;i<nums.length;i++){
	         s[i] = String.valueOf(nums[i]);
	     }
	     Arrays.sort(s,new AComparator());
	     String res = "";
	     for(int i=0;i<nums.length;i++){
	    	 res+=s[i];
	     }
	     return res;
	 }
	 public String quickSortGetMinNumber(int[] nums) {
		 if(nums == null)return "";
		 if(nums.length <2)return String.valueOf(nums[0]);
		 String[] s = new String[nums.length];
		 
	     for(int i=0;i<nums.length;i++){
	         s[i] = String.valueOf(nums[i]);
	     }
		 int left = 0,right = s.length-1;
		 quickSort(s,left,right);
		 

		 StringBuilder res = new StringBuilder();  
		 for (String i : s)
	            res.append(i);
		 return res.toString();
	 }
	 private void quickSort(String[] nums, int left, int right) {

		if(left>=right)return;
		int key = left+(int)(Math.random()*(right-left+1));
		System.out.print(nums[key]);
		swap(nums,key,right);
		int[] part = partition(nums,left,right);
		System.out.println(Arrays.toString(nums));
		quickSort(nums,left,part[0]);
		quickSort(nums,part[1]+1,right);
	}
	private int[] partition(String[] nums, int left, int right) {
		int less = left-1,more=right;
		while(left<more) {

			if((nums[left]+nums[right]).compareTo(nums[right]+nums[left])<=0) {
				swap(nums,++less,left++);
			}

			else if((nums[left]+nums[right]).compareTo(nums[right]+nums[left])>0) {
				swap(nums,--more,left);
			}
		}
		swap(nums,right,left);

		return new int[] {less,more};
		
	}
	private void swap(String[] nums, int key, int right) {
		String temp = nums[key];
		nums[key] = nums[right];
		nums[right] = temp;
		
	}
	public static void main(String[] args) {
		 ArrayToMinNumber a= new ArrayToMinNumber();
		 int[] arr = {3,30,34,5,9};
		 //String res = a.minNumber(arr);
		 //System.out.print(res);
		 String res= a.quickSortGetMinNumber(arr);
		 System.out.print(res);
	 }
}

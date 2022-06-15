package dataStructure;

import java.util.Arrays;

// ±º‰O(nlogn);ø’º‰O(n)
public class MergeSort {
	public int[] mergeSort(int[] arr) {
		if(arr == null || arr.length<2) return arr;
		int left = 0,right = arr.length-1;
		int[] arrRes = partition(arr,left,right);
		return arrRes;
	}
	public int[] partition(int[] arr,int left,int right) {
		if(left==right) return new int[] {arr[left]};
		int mid = left+(right-left)/2;
		int[] arrLeft = partition(arr,left,mid);
		int[] arrRight = partition(arr,mid+1,right);
		int[] arrRes = merge(arrLeft,arrRight);
		return arrRes;
	}
	public int[] merge(int[] arrLeft,int[] arrRight) {
		int left = 0,right = 0,index = 0;
		int[] arrRes = new int[arrLeft.length+arrRight.length];
		while(left<arrLeft.length && right<arrRight.length) {
			if(arrLeft[left]<arrRight[right]) {
				arrRes[index++]=arrLeft[left++];
			}
			else if(arrRight[right]<=arrLeft[left]) {
				arrRes[index++]=arrRight[right++];
			}
		}
		while(left<arrLeft.length) {
			arrRes[index++]=arrLeft[left++];
		}
		while(right<arrRight.length) {
			arrRes[index++]=arrRight[right++];
		}
		return arrRes;
	}
	public static void main(String[] args) {
		int[] arr = {3,30,34,3,9,5};
		MergeSort m = new MergeSort();
		int[] res = m.mergeSort(arr);
		System.out.println(Arrays.toString(res));
	}
}

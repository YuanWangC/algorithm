package dataStructure;

import java.util.Arrays;

//时间O(n^2);空间O(1)
public class SelectSort {
	public void selectSort(int[] arr) {
		if(arr==null || arr.length<2)return;
		int start = 0;
		//从第一个位置开始，将剩余数组中的最小值依次选择放到位置上
		while(start<arr.length) {
			int min = start;
			for(int i = start;i<arr.length;i++) {
				if(arr[i]<arr[min])min = i;
			}
			swap(arr,min,start++);
		}
	}
	public void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {3,30,34,3,9,5};
		SelectSort s = new SelectSort();
		s.selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

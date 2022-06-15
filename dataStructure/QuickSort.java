package dataStructure;

import java.util.Arrays;

//时间O(nlogn);空间O(1ogn)
public class QuickSort {
	
	public void quicksort(int[] arr) {
		if(arr == null || arr.length <2)return;
		int left = 0,right = arr.length-1;
		quickSort(arr,left,right);
	}
	public void quickSort(int[] arr, int left, int right) {
		if(left<right) {
			//取出任意值放到right位置上
			int rand = left+(int)(Math.random()*(right-left+1));
			System.out.println(rand);
			swap(arr,rand,right);
			//将right位置上的值排到确定位置，返回两个区间
			int[] temp = partition(arr,left,right);
			//在两个区间[left,less-1][more,right]上继续排序
			quickSort(arr,left,temp[0]-1);
			quickSort(arr,temp[1]+1,right);
		}
		
	}
	//以arr[right]为划分值，less和more作为小于区和大于区的边界
	public int[] partition(int[] arr, int left, int right) {
		//[left,right]为闭区间，初始less为left-1,more在right(划分值)位置上
		int less = left-1,more = right;
		while(left<more) {
			//对于所有小于划分值的值，交换到less位置上
			if(arr[left]<arr[right]) {
				swap(arr,++less,left++);
			}
			//对于所有大于划分值的值，交换到more位置上，left不能变，因为换过来的值还未遍历
			else if(arr[left]>arr[right]){
				swap(arr,--more,left);
			}
			//保留了等于区
			else {
				left++;
			}
		}
		//从right上交换到确定的位置
		swap(arr,more,right);
		//返回less+1，tmp[0]-1;返回less,tmp[0]不变
		return new int[] {less+1,more};
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		QuickSort a= new QuickSort();
		 int[] arr = {3,30,34,3,9,5};
		 a.quicksort(arr);
		 System.out.print(Arrays.toString(arr));
	 }

}

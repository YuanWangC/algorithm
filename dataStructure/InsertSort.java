package dataStructure;

import java.util.Arrays;

//时间O(n^2);空间O(1)
public class InsertSort {
	public void insertSort2(int[] arr) {
		//假定前缀数组已排好序，将下一个值向前交换到不能再交换为止
		if(arr==null || arr.length<2)return;
		//i的取值范围[0,arr.length-1)【是已排好序子数组的范围，将最后一个插入时，范围取到arr.length-2】
		//j的取值范围(0,i+1]【因为要与j-1交换，不取0】
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j>0; j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr,j-1,j);
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	public void insertSort(int[] arr) {
		//假定前缀数组已排好序，将下一个值插入其中，直到结束
		if(arr==null || arr.length<2)return;
		for(int i = 1;i<arr.length;i++) {
			insert(arr,i);
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public void insert(int[] arr, int index) {
		int temp = arr[index];
		//在[0,index)范围内选择插入位置
		for(int i = 0;i<index;i++) {
			if(arr[i]>temp) {
				//将从i到index-1的数往后挪一格[i,index-1]->[i+1,index]
				for(int j = index;j>=i+1;j--) {
					arr[j]=arr[j-1];
				}
				//再将被插入数放到i位置上
				arr[i] = temp;
				break;
			}
		}	
	}

	public static void main(String[] args) {
		int[] arr = {3,30,34,3,9,5};
		InsertSort i = new InsertSort();
		//i.insertSort(arr);
		i.insertSort2(arr);
		System.out.println(Arrays.toString(arr));
	}
}

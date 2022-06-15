package dataStructure;

import java.util.Arrays;

//ʱ��O(n^2);�ռ�O(1)
public class SelectSort {
	public void selectSort(int[] arr) {
		if(arr==null || arr.length<2)return;
		int start = 0;
		//�ӵ�һ��λ�ÿ�ʼ����ʣ�������е���Сֵ����ѡ��ŵ�λ����
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

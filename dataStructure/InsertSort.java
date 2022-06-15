package dataStructure;

import java.util.Arrays;

//ʱ��O(n^2);�ռ�O(1)
public class InsertSort {
	public void insertSort2(int[] arr) {
		//�ٶ�ǰ׺�������ź��򣬽���һ��ֵ��ǰ�����������ٽ���Ϊֹ
		if(arr==null || arr.length<2)return;
		//i��ȡֵ��Χ[0,arr.length-1)�������ź���������ķ�Χ�������һ������ʱ����Χȡ��arr.length-2��
		//j��ȡֵ��Χ(0,i+1]����ΪҪ��j-1��������ȡ0��
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
		//�ٶ�ǰ׺�������ź��򣬽���һ��ֵ�������У�ֱ������
		if(arr==null || arr.length<2)return;
		for(int i = 1;i<arr.length;i++) {
			insert(arr,i);
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public void insert(int[] arr, int index) {
		int temp = arr[index];
		//��[0,index)��Χ��ѡ�����λ��
		for(int i = 0;i<index;i++) {
			if(arr[i]>temp) {
				//����i��index-1��������Ųһ��[i,index-1]->[i+1,index]
				for(int j = index;j>=i+1;j--) {
					arr[j]=arr[j-1];
				}
				//�ٽ����������ŵ�iλ����
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

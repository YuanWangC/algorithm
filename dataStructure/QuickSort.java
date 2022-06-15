package dataStructure;

import java.util.Arrays;

//ʱ��O(nlogn);�ռ�O(1ogn)
public class QuickSort {
	
	public void quicksort(int[] arr) {
		if(arr == null || arr.length <2)return;
		int left = 0,right = arr.length-1;
		quickSort(arr,left,right);
	}
	public void quickSort(int[] arr, int left, int right) {
		if(left<right) {
			//ȡ������ֵ�ŵ�rightλ����
			int rand = left+(int)(Math.random()*(right-left+1));
			System.out.println(rand);
			swap(arr,rand,right);
			//��rightλ���ϵ�ֵ�ŵ�ȷ��λ�ã�������������
			int[] temp = partition(arr,left,right);
			//����������[left,less-1][more,right]�ϼ�������
			quickSort(arr,left,temp[0]-1);
			quickSort(arr,temp[1]+1,right);
		}
		
	}
	//��arr[right]Ϊ����ֵ��less��more��ΪС�����ʹ������ı߽�
	public int[] partition(int[] arr, int left, int right) {
		//[left,right]Ϊ�����䣬��ʼlessΪleft-1,more��right(����ֵ)λ����
		int less = left-1,more = right;
		while(left<more) {
			//��������С�ڻ���ֵ��ֵ��������lessλ����
			if(arr[left]<arr[right]) {
				swap(arr,++less,left++);
			}
			//�������д��ڻ���ֵ��ֵ��������moreλ���ϣ�left���ܱ䣬��Ϊ��������ֵ��δ����
			else if(arr[left]>arr[right]){
				swap(arr,--more,left);
			}
			//�����˵�����
			else {
				left++;
			}
		}
		//��right�Ͻ�����ȷ����λ��
		swap(arr,more,right);
		//����less+1��tmp[0]-1;����less,tmp[0]����
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

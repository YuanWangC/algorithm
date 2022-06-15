package dataStructure;

import java.util.Arrays;

//ʱ��O(nlogn);�ռ�O(1)
public class HeapSort {
	public void heapSort(int[] arr) {
		if(arr==null || arr.length<2) return;
		int heapsize = arr.length;
		//����
		heapBuild(arr,heapsize);
		System.out.println(Arrays.toString(arr));
		//��ʼ������
		swap(arr,0,--heapsize);
		while(heapsize > 0) {
			heapify(arr,0,heapsize);
			swap(arr,0,--heapsize);
			System.out.println(Arrays.toString(arr));
		}
		
	}
	public void heapBuild(int[] arr, int heapsize) {
		/*
		 * �������ַ�����heapify���϶��£�heapInsert���¶���
		 */
		for(int i=heapsize-1;i>=0;i--) {
			heapify(arr,i,heapsize);
		}
		
		/*for(int i=0;i<heapsize;i++) {
		*	heapInsert(arr,i,heapsize);
		*}
		**/
		
	}
	public void heapInsert(int[] arr, int child, int heapsize) {
		int parent = (child-1)/2;
		while(parent>=0) {
			if(arr[child]>arr[parent]) {
				swap(arr,child,parent);
				//��Ҫ�����滻�±�
				child = parent;
				parent = (child-1)/2;
			}
			//��Ҫ����break
			//������ڵ���󣬲���Ҫ�ټ�����ȥ
			else break;
		}
	}
	public void heapify(int[] arr, int root,int heapsize) {
		int lchild = 2*root+1;
		while(lchild<heapsize) {
			int largest = lchild;
			if(lchild+1<heapsize && arr[lchild+1]>arr[lchild]) {
				largest = lchild+1;
			}
			if(arr[largest] <arr[root]) {
				largest = root;
			}
			if(largest != root){
				swap(arr,largest,root);
				//��Ҫ�����滻�±�
				root = largest;
				lchild = 2*root+1;
			}
			//��Ҫ����break
			//���������root�ڵ㣬����Ҫ�ټ�����ȥ
			else break;
		}
		
	}
	public void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {3,34,30,7,88,9,5};
		HeapSort h = new HeapSort();
		h.heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

package algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

import dataStructure.QuickSort;

public class GetLeastNumbersQuickSelect {
	int k;
	public int[] getLeastNumbers(int[] arr, int k) {
		if(arr == null || arr.length<k || k<=0)return new int[0];
		int[] res = new int[k];
		this.k = k;
		quickSelect(arr,0,arr.length-1);
		for(int i=0;i<k;i++)
			res[i] = arr[i];
		return res;
	}
	private void quickSelect(int[] arr, int left, int right) {
		if(left>=right)return;
		int temp = left+(int)Math.random()*(right-left+1);
		swap(arr,temp,right);
		int[] res = partition(arr,left,right);
		if(res[0] == k-1)return;
		quickSelect(arr,left,res[0]-1);
		quickSelect(arr,res[1]+1,right);
		
	}
	private int[] partition(int[] arr, int left, int right) {
		int less = left-1,more = right;
		while(left<more) {
			if(arr[left]<arr[right]) {
				swap(arr,++less,left++);
			}
			else if(arr[left]>arr[right]) {
				swap(arr,--more,left);
			}
			else {
				left++;
			}
		}
		swap(arr,left,right);
		return new int[] {less+1,more};
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	//大根堆（优先队列）
	public int[] getLeastNumbers2(int[] arr, int k) {
        //优先队列（大根堆）
        if(k==0 || k>arr.length || arr.length==0)return new int[0];
        PriorityQueue<Integer> p = new PriorityQueue<>((v1,v2)->v2-v1);
        
        for(int i = 0;i<arr.length;i++){
            if(p.size()<k){
                p.offer(arr[i]);
            }
            else{
                if(arr[i]<p.peek()){
                    p.poll();
                    p.offer(arr[i]);
                }
            }
            //System.out.print(p);
        }
        int[] res = new int[k];
        int i = 0;
        while(!p.isEmpty()) {
        	res[i++]=p.poll();
        }
        return res;
    }
	public static void main(String[] args) {
		GetLeastNumbersQuickSelect a= new GetLeastNumbersQuickSelect();
		 int[] arr = {3,30,34,4,9,50};
		 int key = 3;
		 int res[] = a.getLeastNumbers(arr,key);
		 System.out.print(Arrays.toString(res));
		 int res2[] = a.getLeastNumbers2(arr,key);
		 System.out.print(Arrays.toString(res2));
	 }
}

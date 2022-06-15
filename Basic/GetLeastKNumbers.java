package algorithm;
import java.util.Arrays;
import java.util.PriorityQueue;
//求最小的k个数
public class GetLeastKNumbers {
	/*
	public int[] getLeastNumbers1(int[] arr, int k) {
       //小根堆排序（从大到小，基于小根堆排序；从小到大，基于大根堆排序）
		if(k==0)return new int[0];
		//heapInsert产生小根堆
		for(int i=0;i<arr.length;i++)
			heapInsert(arr,i);
		int  size = arr.length;
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
		//交换固定位置，把大的数依次固定
		swap(arr,0,--size);
		while(size>0) {
			//重建堆，把较大的数提上来
			heapify(arr,0,size);
			swap(arr,0,--size);
		}
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
		return Arrays.copyOfRange(arr, 0, k);
    }
	public void heapInsert(int[] arr,int i) {
		int parent = (i-1)/2;
		//当执行到arr[0]时，parent和i相等，会退出循环
		while(arr[parent]>arr[i]) {
				swap(arr,i,parent);
				i = parent;
				parent = (i-1)/2;
		}
		
	}
	public void swap(int[] arr, int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void heapify(int[] arr,int index,int heapsize) {
		int lchild = index*2+1;
		while(lchild<heapsize) {
			//首先求出左右子节点（如果存在右节点）之间的最小值
			int smallest = lchild;
			if(lchild+1<heapsize && arr[lchild+1]<arr[lchild])
				smallest = lchild+1;
			else {
				smallest = lchild;
			}
			//求出当前节点和子节点间的最小值下标
			if(arr[smallest]>arr[index])
				smallest = index;
			//System.out.println("############");
			//System.out.println(smallest);
			//如果下标不动，退出
			if(smallest==index)break;
			//否则交换与子节点的位置，重复以上过程直到当前节点没有子节点为止
			swap(arr,index,smallest);
			index = smallest;
			lchild = 2*index+1;
		}
	}
	
	public int[] getLeastNumbers2(int[] arr, int k) {
		//优先队列
        if(k==0)return new int[0];
        PriorityQueue<Integer> p = new PriorityQueue<>(k);
        for(int i:arr)p.add(i);
        int[] res = new int[k];
        for(int i = 0;i<k;i++) {
            res[i] = p.poll();
        }
        return res;
	}
	*/
	/*
	 *大根堆排序
	 */
	 public int[] getLeastNumbers(int[] arr, int k) {
	        if(k==0)return new int[0];
	        for(int i=0;i<arr.length;i++)
	            heapInsert(arr,i);
	        int heapsize = arr.length;
	        swap(arr,0,--heapsize);
	        while(heapsize>0){
	            heapify(arr,0,heapsize);
	            swap(arr,0,--heapsize);
	        }    

	        return Arrays.copyOfRange(arr,0,k);
	    }
	    public void heapify(int[] arr,int index,int heapsize){
	        int lchild = 2*index+1;
	        int largest = -1;
	        while(lchild<heapsize){
	            if(lchild+1<heapsize && arr[lchild]<arr[lchild+1])
	                largest=lchild+1;
	            else {
	            	largest = lchild;
	            }
	            if(arr[index]>arr[largest])
	                largest=index;
	            if(index == largest)break;
	            swap(arr,index,largest);
	            index = largest;
	            lchild = 2*index+1;
	        }
	    }
	    public void heapInsert(int[] arr,int index){
	        while(arr[index] > arr[(index-1)/2]){
	            swap(arr,index,(index-1)/2);
	            index = (index-1)/2;
	        }
	    }

	    public void swap(int[] arr,int i,int j){
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    } 
	   
	public static void main(String[] args) {
		GetLeastKNumbers g = new GetLeastKNumbers();
		//int[] arr = {0,0,0,2,0,5};
		int[] arr = {9,9,8,2,0,5};
		int k = 3;
		//int[] res = g.getLeastNumbers2(arr, k);
		//int[] res = g.getLeastNumbers1(arr, k);
		int[] res = g.getLeastNumbers(arr, k);
		System.out.println();
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);
	}
}

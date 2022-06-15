package algorithm;
import java.util.Arrays;
import java.util.PriorityQueue;
//����С��k����
public class GetLeastKNumbers {
	/*
	public int[] getLeastNumbers1(int[] arr, int k) {
       //С�������򣨴Ӵ�С������С�������򣻴�С���󣬻��ڴ��������
		if(k==0)return new int[0];
		//heapInsert����С����
		for(int i=0;i<arr.length;i++)
			heapInsert(arr,i);
		int  size = arr.length;
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
		//�����̶�λ�ã��Ѵ�������ι̶�
		swap(arr,0,--size);
		while(size>0) {
			//�ؽ��ѣ��ѽϴ����������
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
		//��ִ�е�arr[0]ʱ��parent��i��ȣ����˳�ѭ��
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
			//������������ӽڵ㣨��������ҽڵ㣩֮�����Сֵ
			int smallest = lchild;
			if(lchild+1<heapsize && arr[lchild+1]<arr[lchild])
				smallest = lchild+1;
			else {
				smallest = lchild;
			}
			//�����ǰ�ڵ���ӽڵ�����Сֵ�±�
			if(arr[smallest]>arr[index])
				smallest = index;
			//System.out.println("############");
			//System.out.println(smallest);
			//����±겻�����˳�
			if(smallest==index)break;
			//���򽻻����ӽڵ��λ�ã��ظ����Ϲ���ֱ����ǰ�ڵ�û���ӽڵ�Ϊֹ
			swap(arr,index,smallest);
			index = smallest;
			lchild = 2*index+1;
		}
	}
	
	public int[] getLeastNumbers2(int[] arr, int k) {
		//���ȶ���
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
	 *���������
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

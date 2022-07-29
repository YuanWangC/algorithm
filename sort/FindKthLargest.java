import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<Integer>((a,b)->{
            return b-a;
        });
        for(int i:nums){
            que.add(i);
        }
        System.out.println(que);
        for(int i=0;i<k-1;i++){
            System.out.println(que.poll());
        }
        return que.poll();
    }
    public int findKthLargest2(int[] arr, int k) {
        for(int i=0;i<arr.length;i++){
            int l = arr.length-1-i;
            if(i==arr.length-k)break;
            for(int j=0;j<l;j++){
                if(arr[j]>arr[j+1])swap(arr,j,j+1);
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-k];
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        int[] arr = {1,2,5,3,41,2,7};
        FindKthLargest o = new FindKthLargest();
        int res = o.findKthLargest2(arr,2);
        System.out.println(res);
    }
}

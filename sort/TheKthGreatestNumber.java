import java.util.Scanner;

public class TheKthGreatestNumber {
    int k;
    public void swap(int[] arr,int i,int j){
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int partition(int[] arr,int left,int right){
        int more = right;
        while(left<more){
            while(left<more && arr[left]<=arr[right]){
                left++;
            }
            while(left<more && arr[more]>=arr[right]){
                more--;
            }
            if(left<more)swap(arr,left,more);
        }
        swap(arr,right,more);
        // System.out.println(Arrays.toString(arr));
        return more;
    }
    public void quicksort(int[] arr,int left,int right){
        if(left>=right)return;
        int choseIndex = left+(int)(Math.random()*(right-left+1));
        swap(arr,choseIndex,right);
        int pos = partition(arr,left,right);
        if(pos == arr.length-k)return;
        quicksort(arr,left,pos-1);
        quicksort(arr,pos+1,right);
    }
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length)return -1;
        this.k = k;
        quicksort(nums,0,nums.length-1);
        // System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }
    public static void main(String[] args){
        TheKthGreatestNumber obj = new TheKthGreatestNumber();
//        int[] arr = {3,2,1,5,6,4};
//        int k = 2;
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int res = obj.findKthLargest(arr,k);
        System.out.println(res);
    }
}

public class BinarySearch {
    public int search(int[] arr,int target){
        int start = 0,end= arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target)return mid;
            if(arr[mid]<target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        int target = 15;
        BinarySearch obj = new BinarySearch();
        int res = obj.search(arr,target);
        System.out.println(res);
    }
}

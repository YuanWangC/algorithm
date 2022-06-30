package Basic;

public class InsertPositionBinarySearch {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int ans = nums.length;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]>=target){
                ans = mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            // System.out.println(mid+" "+ans);
        }
        return ans;
    }
    public static void main(String[] args){
        InsertPositionBinarySearch obj = new InsertPositionBinarySearch();
        int[] arr = {1,3,5,6};
        int target = 5;
        int res = obj.searchInsert(arr,target);
        System.out.println(res);
    }
}

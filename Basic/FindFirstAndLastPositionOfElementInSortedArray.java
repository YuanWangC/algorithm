package Basic;

import java.util.Arrays;

//查找一个数的第一个位置和最后一个位置，如果target不存在，就返回{-1，-1}
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int search(int[] nums,int target){
        int left = 0,right = nums.length-1;
//        注意初始值赋nums.length，其他值不好判断
        int pos = nums.length;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>=target){
                pos = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return pos;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0)return new int[]{-1,-1};
//        查找大于等于这个数target的最小下标（最左）
        int pos = search(nums,target),pos2;
        if(pos <nums.length && nums[pos] == target){
//            查找大于等于target+1的最小下标（最左），再减一就是target最右下标
            pos2 = search(nums,target+1)-1;
            return new int[]{pos,pos2};
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] arr = {5,7,7,8,8,10};
        int target = 8;
        int[] res = obj.searchRange(arr,target);
        System.out.println(Arrays.toString(res));
    }
}

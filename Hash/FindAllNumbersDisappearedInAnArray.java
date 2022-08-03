import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
    查找数组中所有出现重复的数字，数组内数字的取值范围[1,n]
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            //  均摊时间复杂度，将num[i]上的值改为i+1(0位置放1,1位置放2···n-1位置放n)
            while(nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        // System.out.println(Arrays.toString(nums));
        ArrayList<Integer> res = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)res.add(i+1);
        }
        return res;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        FindAllNumbersDisappearedInAnArray obj = new FindAllNumbersDisappearedInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = obj.findDisappearedNumbers(nums);
        System.out.println(res);
//        System.out.println(Arrays.toString(res.toArray()));
    }
}
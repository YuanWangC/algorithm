package Basic;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElementCircle {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        ArrayDeque<Integer> stk = new ArrayDeque();
//        两次进入循环，从2*nums.length-1开始，直到0，取余%nums.length保证在数组内部
        for(int i=2*nums.length-1;i>=0;i--){
            while(!stk.isEmpty() && nums[i%nums.length]>=stk.peek()){
                stk.pop();
            }
            if(stk.isEmpty())res[i%nums.length] = -1;
            else res[i%nums.length] = stk.peek();
            stk.push(nums[i%nums.length]);
            // System.out.println(Arrays.toString(res));
        }
        return res;
    }
    public static void main(String[] args){
        NextGreaterElementCircle obj = new NextGreaterElementCircle();
        int[] nums = {1,2,3,4};
        int[] res = obj.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
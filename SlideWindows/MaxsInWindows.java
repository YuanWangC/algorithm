import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxsInWindows {
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int right = 0;
        int[] maxs = new int[nums.length-k+1];
        int i = 0;
        Deque<Integer> que = new ArrayDeque();
        while(right<nums.length){
            if(!que.isEmpty() && right-que.peek()>=k){
                que.poll();
            }
            while(!que.isEmpty() && nums[right]>nums[que.peekLast()]){
                que.pollLast();
            }
            que.offer(right);
            if(right>=k-1)
                maxs[i++] = nums[que.peek()];
            right++;
        }
        return maxs;
    }
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> que = new ArrayDeque();
        int[] maxs = new int[nums.length-k+1];
        int index = 0;
        int i=0;
        while(i<=k-1){
            while(!que.isEmpty() && que.peekLast()<nums[i])
                que.removeLast();
            que.offer(nums[i++]);
        }
        maxs[index++] = que.peek();
        for(;i<nums.length;i++){
            if(!que.isEmpty() && que.peekFirst() == nums[i-k])
                que.removeFirst();
            while(!que.isEmpty() && que.peekLast()<nums[i])
                que.removeLast();
            que.offer(nums[i]);
            maxs[index++] = que.peek();
        }
        return maxs;
    }
    public static void main(String[] args){
        int k = 3;
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] res1 = maxSlidingWindow1(arr,k);
        System.out.println(Arrays.toString(res1));
        int[] res2 = maxSlidingWindow2(arr,k);
        System.out.println(Arrays.toString(res2));
    }
}
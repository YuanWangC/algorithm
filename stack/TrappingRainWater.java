import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    // 求每个节点左右两边的最大值（不包含当前节点）
    public static int trap1(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i=1;i<height.length;i++){
            left[i] = Math.max(left[i-1],height[i-1]);
        }
        for(int i=height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i+1]);
        }
        int res = 0;
        // Math.min(left[i],right[i])-height[i],出现“凹”形时加入结果，否则取零
        for(int i=0;i<height.length;i++){
            res+=Math.max(0,Math.min(left[i],right[i])-height[i]);
        }
        return res;
    }
    // 单调递减栈
    public static int trap2(int[] height) {
        Deque<Integer> stk = new ArrayDeque();
        int index = 0;
        int sum = 0;

        while(index<height.length){
            // 空栈||小于栈顶直接入栈
            if(stk.isEmpty() || height[index]<=height[stk.peek()]){
                stk.push(index++);
            }
            else{
                //去掉栈顶（小于height[index]），“凹”形的垫底
                int cur = stk.pop();
                if(stk.isEmpty()) continue;
                // 按照下标求宽度
                int width = index-stk.peek()-1;
                // “凹”形两边取短，得到“长”，计算面积
                sum+=width*(Math.min(height[index],height[stk.peek()])-height[cur]);
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(arr));
        System.out.println(trap2(arr));
    }
}
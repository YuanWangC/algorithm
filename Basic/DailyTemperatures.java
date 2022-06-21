package Basic;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for (int i=temperatures.length-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[i]>=temperatures[stk.peek()]){
                stk.pop();
            }
            res[i] = stk.isEmpty()?0:(stk.peek()-i);
            stk.push(i);
        }
        return res;
    }
    public static void main(String[] args){
        DailyTemperatures obj = new DailyTemperatures();
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] res = obj.dailyTemperatures(nums);
        System.out.println(Arrays.toString(res));
    }
}

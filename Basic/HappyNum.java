package Basic;

import java.util.Scanner;

public class HappyNum {
    public int getSum(int n){
        int sum = 0;
        while(n!=0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int num) {
        int slow = num,fast = num;
        fast = getSum(getSum(num));
        while(slow!=fast){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
            // System.out.println(slow+" "+fast);
        }
        return fast == 1;
    }
    public static void main(String[] args){
        HappyNum obj = new HappyNum();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            boolean res = obj.isHappy(n);
            System.out.println(res);
        }

    }
}

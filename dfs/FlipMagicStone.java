import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FlipMagicStone {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] zero = new int[n];
        int[] one = new int[n];
        HashMap<Integer,Integer> same = new HashMap<>();
//        数组需要一个一个输入
        for(int i=0;i<n;i++){
            zero[i] = in.nextInt();
            same.put(zero[i],same.getOrDefault(zero[i],0)+1);
        }
        for(int i=0;i<n;i++){
            one[i] = in.nextInt();
            same.put(one[i],same.getOrDefault(one[i],0)+1);
        }
        int target = (n+1)/2;
        List<Integer> accepted = new ArrayList<>();
        for(Integer k:same.keySet()){
            if(same.get(k)>=target){
                accepted.add(k);
            }
        }
        System.out.println(accepted);
        System.out.println(same);
        int min = n+1;
        for(int i:accepted){
            int countZ = 0;
            int countO = 0;
            int needFlip;
            for(int j=0;j<n;j++){
                System.out.println(zero[j]+" "+one[j]);
                if(zero[j] == i)countZ++;
                else if(one[j] == i)countO++;
            }
            System.out.println(countO);
            System.out.println(countZ);
            System.out.println(target);
            if(countZ>=target){
                min = 0;
                break;
            }
            else{
                needFlip = target-countZ;
                if(countO<needFlip) continue;
            }
            min = Math.min(min,needFlip);
        }
        if(min == n+1) System.out.println(-1);
        System.out.println(min);
    }
}

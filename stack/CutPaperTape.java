import java.util.Scanner;

public class CutPaperTape {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] tape = new int[n];
        int[] bigger = new int[n+1];
        int[] smaller = new int[n+2];
        for(int i=0;i<n;i++){
            tape[i] = in.nextInt();
        }
//        每个位置及以前大于等于0的数量
        for(int i=1;i<=n;i++){
            if(tape[i-1]>=0)bigger[i] = bigger[i-1]+1;
            else bigger[i] = bigger[i-1];
        }
//        每个位置及以后小于等于0的数量
        for(int i=n;i>=1;i--){
            if(tape[i-1]<=0)smaller[i] = smaller[i+1]+1;
            else smaller[i] = smaller[i+1];
        }
        int min = n, res=n;
//        求纸带每个空隙的非法情况最小值
//        此处计数与tape无关，只与bigger和smaller有关，
//        bigger的第0个位置在tape[0]之前，smaller[1]在tape[0]上，求的是tape[0]之前的位置的异常数目
        for(int i=0;i<=n;i++){
            res = bigger[i]+smaller[i+1];
            min = Math.min(min,res);
        }
        System.out.println(min);
    }
}

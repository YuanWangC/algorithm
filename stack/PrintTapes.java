import java.util.Scanner;
/*
input:
5
0 -1 1 1 -1
 */
public class PrintTapes {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] tape = new int[n];
        int[] bigger = new int[n+1];
        int[] smaller = new int[n+2];
        for(int i=0;i<n;i++){
            tape[i] = in.nextInt();
        }
        for(int i=1;i<=n;i++){
            if(tape[i-1]<=0){
                smaller[i] = smaller[i-1]+1;
            }else{
                smaller[i] = smaller[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(tape[i]>=0){
                bigger[i] = bigger[i+1]+1;
            }else{
                bigger[i] = bigger[i+1];
            }
        }
        int min = n, res=n;
        for(int i=0;i<=n;i++){
            res = bigger[i]+smaller[i+1];
            min = res<min?res:min;
        }
        System.out.println(min);
    }
}

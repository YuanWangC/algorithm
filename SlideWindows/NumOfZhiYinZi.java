import java.util.*;
/*
2
20 8
1 2 3 2 6 5 2 1
17 10
1 4 5 7 10 8 7 17 2 8
 */
public class NumOfZhiYinZi {
    HashMap<Integer,Integer> need = new HashMap();
    public void primeNum(int n, int m) {
        if (n < m)
            return;
        else {
            if (n % m == 0) {
                need.put(m,need.getOrDefault(m,0)+1);
                primeNum(n / m, m);
            } else
                primeNum(n, m + 1);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        while(m>0) {
            m--;
            int n = in.nextInt();
            int len = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++)
                arr[i] = in.nextInt();
            NumOfZhiYinZi obj = new NumOfZhiYinZi();
            obj.primeNum(n,2);
            int vaild = 0;
            int min = arr.length+1;
            int left = 0,right = 0;
            HashMap<Integer,Integer> window = new HashMap();
            while(right<len){
                int c = arr[right];
                right++;
                if(obj.need.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0)+1);
                    if(window.get(c).equals(obj.need.get(c))){
                        vaild++;
                    }
                }
                while(vaild >= obj.need.size()){
                    if(min>right-left){
                        min = right-left;
                    }
                    int l = arr[left];
                    left++;
                    if(obj.need.containsKey(l)){
                        if(window.get(l).equals(obj.need.get(l))){
                            vaild--;
                        }
                        window.put(l,window.get(l)-1);
                    }
                }
            }
            if(min == arr.length+1)System.out.println(0);
            else System.out.println(min);
        }
    }
}

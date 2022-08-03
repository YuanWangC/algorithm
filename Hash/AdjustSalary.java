import java.util.Arrays;
import java.util.HashMap;


public class AdjustSalary {
    public int check(char[] sc,int left,int right){
        if(left>right)return 0;
        int res = 0;
        for(int i=left;i<=right;i++){
            if(sc[i] =='1'){
                res = res<<1;
                res = res+1;
            }
            else res = res<<1;
        }
        return res;
    }
    public String[] adjust(String s){
        HashMap<Integer,Integer> memo = new HashMap<>();
        char[] sc = s.toCharArray();
//        System.out.println(Arrays.toString(sc));
        int res = 0;
        for(int i=0;i<sc.length;i++){
            if(sc[i]=='1'){
                res = res<<1;
                res = res+1;
            }
            else res = res<<1;
            memo.put(i,res);
        }
        System.out.println(memo);
        int i=0,j=0;
        for(;i<sc.length;i++){
            int val = memo.get(i);
            j=i+1;
            for(;j<sc.length;j++){
                System.out.println(i+" "+j);
                int res1 = check(sc,i+1,j);
                int res2 = check(sc,j+1,sc.length-1);
                if(res1!=res2)continue;
                if(res1==val && res2 == val)
                    return new String[]{s.substring(0,i+1),s.substring(i+1,j+1),s.substring(j+1,sc.length)};
                System.out.println(val+" "+res1+" "+res2);
            }
        }
        return new String[0];
    }
    public static void main(String[] args){
        String s = "1010010";
        AdjustSalary obj = new AdjustSalary();
        String[] res = obj.adjust(s);
        System.out.println(Arrays.toString(res));
    }
}

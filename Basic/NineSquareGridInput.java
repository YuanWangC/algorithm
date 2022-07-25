package Basic;

import java.util.*;

public class NineSquareGridInput {
    HashMap<Character,int[]> memo = new HashMap<>();
    HashMap<Integer,Integer> count = new HashMap<>();
    public void build(){
        memo.put('@',new int[]{1,1});
        memo.put('!',new int[]{1,2});
        memo.put('.',new int[]{1,3});
        memo.put('/',new int[]{1,4});
        memo.put('a',new int[]{2,1});
        memo.put('b',new int[]{2,2});
        memo.put('c',new int[]{2,3});
        memo.put('d',new int[]{3,1});
        memo.put('e',new int[]{3,2});
        memo.put('f',new int[]{3,3});
        memo.put('g',new int[]{4,1});
        memo.put('h',new int[]{4,2});
        memo.put('i',new int[]{4,3});
        memo.put('j',new int[]{5,1});
        memo.put('k',new int[]{5,2});
        memo.put('l',new int[]{5,3});
        memo.put('m',new int[]{6,1});
        memo.put('n',new int[]{6,2});
        memo.put('o',new int[]{6,3});
        memo.put('p',new int[]{7,1});
        memo.put('q',new int[]{7,2});
        memo.put('r',new int[]{7,3});
        memo.put('s',new int[]{7,4});
        memo.put('t',new int[]{8,1});
        memo.put('u',new int[]{8,2});
        memo.put('v',new int[]{8,3});
        memo.put('w',new int[]{9,1});
        memo.put('x',new int[]{9,2});
        memo.put('y',new int[]{9,3});
        memo.put('z',new int[]{9,4});
    }
    public int[][] countInput(String s){
        build();
        for(int i=0;i<s.length();i++){
            int[] k = memo.get(s.charAt(i));
            if(count.containsKey(k[0])){
                count.put(k[0],count.get(k[0])+k[1]);
            }else{
                count.put(k[0],k[1]);
            }
        }
        int[][] res = new int[s.length()][2];
        int index = 0;
        for(Map.Entry<Integer,Integer> m:count.entrySet()){
            res[index++] = new int[]{m.getKey(),m.getValue()};
        }
        return Arrays.copyOfRange(res,0,index);
    }
    public static void main(String[] args){
        NineSquareGridInput obj = new NineSquareGridInput();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[][] realRes = obj.countInput(s);
        for(int i=0;i<realRes.length;i++)
            System.out.println(Arrays.toString(realRes[i]));
    }
}

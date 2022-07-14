package Basic;

import java.util.*;

public class City {
    int[][] memo;
    ArrayList<int[]> path = new ArrayList<>();
    int k;
    List<List<int[]>> res = new ArrayList<>();
    public void count(int[] x,int[] y,int k) {
        memo = new int[x.length][3];
        for(int i=0;i<x.length;i++){
            memo[i][0] = x[i]-k;
            memo[i][1] = x[i]+k;
            memo[i][2] = y[i];
        }
    }
    public int isQualify(List<int[]> path,int[] x){
        for(int i=0;i<path.size();i++){
            int[] pi = path.get(i);
            for(int j=i+1;j<path.size();j++){
                int[] pj = path.get(j);
                int pos = pj[0]+k;
//                System.out.println(Arrays.toString(pi)+" "+x[j]);
                if(pi[0]<pos && pi[1]>pos){
                    continue;
                }
                else{
                    return 0;
                }
            }
        }
        int count = 0;
        for(int[] p:path) {
            count += p[2];
            System.out.println(p[0]+3);
            System.out.println(Arrays.toString(p));
        }
        System.out.println(count);
        return count;
    }
    public void choose(int index){
        if(index>=memo.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<memo.length;i++){
            path.add(memo[i]);
            choose(i+1);
            path.remove(path.size()-1);
        }
    }
    public int getRes(int[] x){
        int sum = 0;
        for(List<int[]> p:res){
            sum=Math.max(isQualify(p,x),sum);
        }
        return sum;
    }
    public static void main(String[] args){
        City c = new City();
        int[] x = {1,2,4,3,5};
        int[] y = {3,1,2,1,3};
        int k = 3;
        c.k = k;
        c.count(x,y,k);
        c.choose(0);
        int res = c.getRes(x);
        System.out.println(res);
    }
}

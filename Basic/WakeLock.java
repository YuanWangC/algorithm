package Basic;

import java.util.*;

public class WakeLock {
    public ArrayList<Integer> getWakeLockContribution(List<List<Integer>> wakelock){
        ArrayList<Integer> res = new ArrayList<>(wakelock.size());
        if(wakelock.size()==0)return res;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(List<Integer> list:wakelock){
            for(Integer k:list){
                if(min>k)min = k;
                if(max<k)max = k;
            }
        }
        int[][] count = new int[max-min+1][wakelock.size()];
        for(int j=0;j<wakelock.size();j++){
            List<Integer> list = wakelock.get(j);
            for(int i=0;i<list.size();i+=2){
                int start = list.get(i)-min;
                int end = list.get(i+1)-min;
                for(int k=start;k<end;k++)
                    count[k][j]++;
            }
        }
        double[] sum = new double[wakelock.size()];
        for(int i=0;i<count.length;i++){
            List<Integer> belong = new ArrayList<>();
            for(int j=0;j<count[i].length;j++) {
                if (count[i][j] == 1) {
                    belong.add(j);
                }
            }
            if(belong.size()==1) sum[belong.get(0)]++;
            else{
                for(Integer b:belong){
                    sum[b]+=(1.0/belong.size());
                }
            }
        }
        for(int i=0;i<wakelock.size();i++)
            res.add((int)sum[i]);
        return res;
    }
    public static void main(String[] args){
        int[] arr1 = {4,2};
        int[] arr2 = {3,2};
//        int[] arr1 = {1234,1240};
//        int[] arr2 = {1236,1238,1245,1250};
//        int[] arr1 = {1234,1235};
//        int[] arr2 = {1236,1238};
        List<List<Integer>> wl = new ArrayList<>();
        List<Integer> wl1 = new ArrayList<>();
        List<Integer> wl2 = new ArrayList<>();
        for(int i:arr1){
            wl1.add(i);
        }
        for(int i:arr2){
            wl2.add(i);
        }
        wl.add(wl1);
        wl.add(wl2);
        WakeLock obj = new WakeLock();
        System.out.println(obj.getWakeLockContribution(wl));
    }
}

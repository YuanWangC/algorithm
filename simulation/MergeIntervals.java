package simulation;
import java.util.*;
public class MergeIntervals {
    public static int[][] merge1(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(min > intervals[i][0])min = intervals[i][0];
            if(max < intervals[i][1])max = intervals[i][1];
        }
        // System.out.println(min+" "+max);
//        1.作出位图（左开右闭），记录单独出现的点
        int[] bits = new int[max-min+1];
        List<Integer> single = new ArrayList();
        List<int[]> res = new ArrayList();
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start == end && !single.contains(start)){
                //  System.out.println(start);
                single.add(start);
            }else{
                while(start<end){
                    bits[start-min] = 1;
                    start++;
                }
            }
        }
//                2.单独点排序
        if(single.size()!=0)Collections.sort(single);
        // System.out.println(Arrays.toString(bits));
        // System.out.println(single);
        int count = 0;
//        3.计数，记录区间
        for(int i=0;i<bits.length;i++){
            if(bits[i] == 1)count++;
            else if(count!=0){
                // System.out.println(count+" "+i+" "+min);
                int start = i-count;
                int[] r = {start+min,i+min};
                res.add(r);
                count=0;
//                4.判断所有单独节点，是否在区间内
                int index = 0;
                while(index<single.size()){
                    if(r[0]<=single.get(index) && r[1]>=single.get(index))
                        single.remove(index);
                    else index++;
                }
            }
        }
        // System.out.println(single);
//        5.分别记录区间节点和单独节点
        int[][] result = new int[res.size()+single.size()][2];
        for(int i=0;i<res.size();i++){
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }
        for(int i=res.size();i<result.length;i++){
            result[i][0] = single.get(i-res.size());
            result[i][1] = single.get(i-res.size());
        }
        return result;
    }

    public static int[][] merge2(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList();
        Arrays.sort(intervals,(o1,o2)->{
            return o1[0]-o2[0];
        });
        res.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] cur = intervals[i];
            int[] last = res.getLast();
            if(cur[0]<=last[1]){
                System.out.println(Arrays.toString(res.getLast()));
                last[1] = Math.max(last[1],cur[1]);
                System.out.println(Arrays.toString(res.getLast()));
            }else{
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);
    }
    public static void main(String[] args) {
//        int[][] arr = {{1,1},{1,5}};
//        int[][] arr = {{1,4},{4,5}};
//        int[][] arr = {{2,3},{1,5}};
//        int[][] arr = {{1,1},{1,1},{1,5}};
//        int[][] arr = {{5,5},{2,3},{1,5}};
        int[][] arr = {{3,3},{2,7},{1,5}};
//        int[][] arr = {{1,5},{6,6},{7,8}};

//        int[][] res = MergeIntervals.merge1(arr);
        int[][] res = MergeIntervals.merge2(arr);
        for(int[] r:res)
            System.out.println(Arrays.toString(r));
    }
}
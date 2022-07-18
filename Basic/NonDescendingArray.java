package Basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class NonDescendingArray {
    int count = 0;
    String arr2;
    public int[] move(int[] arr,int des, int index){
        int[] res = new int[arr.length];
        res[des] = arr[index];
        if(des == 0){
            for(int i=0;i<=index-1;i++){
                res[i+1] = arr[i];
            }
            for(int i=index+1;i<arr.length;i++){
                res[i] = arr[i];
            }
        }
        else{
            for(int i=0;i<=index-1;i++){
                res[i] = arr[i];
            }
            for(int i=index+1;i<arr.length;i++){
                res[i-1] = arr[i];
            }
        }
//        System.out.println(Arrays.toString(res));
        return res;
    }
    public void bfs(int[] arr){
        ArrayDeque<int[]> que = new ArrayDeque();
//        HashSet<String> set = new HashSet<>();
        String arrs = Arrays.toString(arr);
//        String arrs = arr.toString();
        if(arrs.equals(this.arr2))return;
        que.offer(arr);
//        set.add(arrs);
        while(!que.isEmpty()){
            int size = que.size();
//            System.out.println(set.size());
//            System.out.println(set);
            for(int i=0;i<size;i++){
                int[] cur = que.poll();
                String curs = Arrays.toString(cur);
//                String curs = cur.toString();
                if(curs.equals(arr2))return;
                for(int j=0;j<cur.length;j++){
//                    此处尤其注意
                    int[] curF = move(cur,0,j);
//                    String curFS = Arrays.toString(curF);
//                    String curFS = curF.toString();
//                    此处需要提前类型转换，尤其注意
//                    if(!set.contains(curFS)){
                        que.offer(curF);
//                        set.add(curFS);
//                    }
                    int[] curL = move(cur,arr.length-1,j);
//                    String curLS = Arrays.toString(curL);
//                    String curLS = curL.toString();
//                    if(!set.contains(curLS)){
                        que.offer(curL);
//                        set.add(curLS);
//                    }
                }
            }
           this.count++;
        }
    }
    public static void main(String[] args){
        NonDescendingArray obj = new NonDescendingArray();
        int[] arr = {3,2,1};
//        int[] arr = {6,5,4,3,2,1};
//        int[] arr = {4,5,3,2,1,6};
        int[] arr3 = Arrays.copyOfRange(arr,0,arr.length);
        Arrays.sort(arr3);
        obj.arr2 = Arrays.toString(arr3);
//        obj.arr2 = arr3.toString();
        System.out.println(obj.arr2);
        obj.bfs(arr);
        System.out.println(obj.count);
    }
}

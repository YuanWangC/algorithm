package simulation;

import java.util.*;

public class partitionArray {
    public static int bfs(List<Integer> arr){
        Deque<List<Integer>> res = new ArrayDeque();
        res.offer(arr);
        int step = 1;
        while(!res.isEmpty()){
            int size = res.size();
            for(int i=0;i<size;i++){
                List<Integer> cur = res.poll();
                boolean flag = false;
                for(Integer k:cur){
                    if(k!=1){
                        flag = true;
                        break;
                    }
                }
                if(!flag)break;
                List<Integer> next = new ArrayList<>();
                for(int j = 0;j<cur.size();j++) {
                    int val = cur.get(j);
                    if (val == 1) {
                        next.add(1);
                    } else if (val <= 3) {
                        next.add(val - 1);
                        next.add(1);
                    } else {
                        int half = (int) Math.sqrt(val);
                        if (half * half == val) {
                            next.add(half);
                            next.add(half);
                        } else {
                            while (half > 1) {
                                if (val % half == 0) break;
                                half--;
                            }
                            next.add(half);
                            next.add(val / half);
                        }
                    }
                }
                res.offer(next);
            }
            step++;
        }
        return step;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++)
            arr.add(in.nextInt());

        System.out.println(bfs(arr));

    }
}

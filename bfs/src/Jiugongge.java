package Basic;

import java.util.ArrayList;
import java.util.List;

public class Jiugongge {
    int[] line = {0,1,2};
    int[] row = {0,3,6};
    int[] diagonal1 = {0,4,8};
    int[] diagonal2 = {2,4,6};
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] visited = new boolean[9];
    public boolean check(int[] arr){
        long sumline = -1,sumRow = -1, sumd1= 1,sumd2 = 1;;
        for(int i=0;i<3;i++){
            int temp = 1;
            for(int j=0;j<3;j++)
                temp *= arr[line[j]+3*i];
            if(sumline!=-1 && temp !=sumline)return false;
            sumline = temp;
        }
        for(int i=0;i<3;i++){
            int temp = 1;
            for(int j=0;j<3;j++)
                temp *= arr[row[j] + i];
            if(sumRow!=-1 && temp !=sumRow)return false;
            sumRow = temp;
        }
        if(sumline!=sumRow)return false;
        for(int i:diagonal1)
            sumd1 *= arr[i];
        for(int i:diagonal2)
            sumd2 *= arr[i];
        if(sumd1!=sumd2)return false;
        if(sumd1!=sumRow)return false;
        return true;
    }
    public void dfs(int[] arr){
        if(path.size() == arr.length){
            boolean f = check(path.stream().mapToInt(Integer::intValue).toArray());
            if(f) res.add(new ArrayList<>(path));
            return;
        }
        if(path.size() > arr.length)return;
        for(int i=0;i<arr.length;i++){
            if(visited[i])continue;
            visited[i] = true;
            path.add(arr[i]);
            dfs(arr);
            path.remove(path.size()-1);
            visited[i] = false;
        }

    }
    public static void main(String[] args){
        int[] arr = {10,36,75,225,30,4,12,25,90};
        Jiugongge obj = new Jiugongge();
        obj.dfs(arr);
        for(List<Integer> r:obj.res)
            System.out.println(r);
    }
}

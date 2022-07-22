package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PossibleBipartition {
    boolean[] group;
    boolean[] visited;
    boolean flag = true;
    public void ingroup(List<Integer>[] graph,int i){
        if(graph[i].size() == 0)return;
        for(Integer k:graph[i]){
            if(!visited[k]){
                group[k] = !group[i];
                visited[k] = true;
//                递归
                ingroup(graph,k);
            }
            else{
                if(group[k] == group[i]){
                    flag = false;
                    return;
                }
            }
        }
    }
    public List<Integer>[] build(int n, int[][] dislikes){
        List<Integer>[] graph = new List[n+1];
        for(int i=0;i<=n;i++)
            graph[i] = new ArrayList<>();
        for(int[] d:dislikes){
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        return graph;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n <=1)return true;
//        这是无向图，需要建立起两个方向的边
//        每个节点的边数不定时添加，所以用List组织每个节点的边；
//        节点数一定，所以用数组组织每个节点
        List<Integer>[] graph = build(n,dislikes);
        // System.out.println(dislike);
        group = new boolean[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i])continue;
            ingroup(graph,i);
            visited[i] = true;
        }
        // System.out.println(Arrays.toString(group));
        return flag;
    }
    public static void main(String[] args){
        PossibleBipartition obj = new PossibleBipartition();
        int n = 5;
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        boolean res = obj.possibleBipartition(n,dislikes);
        System.out.println(res);
    }
}
public class IsGraphBipartite {
    boolean[] flag;
    boolean[] color;
    boolean res = true;
    public void dfs(int[][] graph,int i){
        for(int k=0;k<graph[i].length;k++){
            //注意graph[i]中存储的是节点ID的列表
            int j = graph[i][k];
            if(flag[j]){
                if(color[i] == color[j]){
                    res = false;
                    return;
                }
            }
            else{
                flag[j] = true;
                //二分图上色，使用boolean数组足矣
                color[j] = !color[i];
                dfs(graph,j);
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        flag = new boolean[graph.length];
        color = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(flag[i])continue;
            dfs(graph,i);
            flag[i] = true;
        }
        // System.out.println(set1);
        // System.out.println(set2);
        return res;
    }
    public static void main(String[] args){
        IsGraphBipartite obj = new IsGraphBipartite();
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean res = obj.isBipartite(graph);
        System.out.println(res);

    }
}

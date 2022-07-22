package bfs;

import java.util.Arrays;

public class NumberOfEnclaves {
    boolean[][] visited;
    int count = 0;
    int m,n;
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 ||i>=n ||j>=m)return;
        if(grid[i][j] == 0)return;
        if(visited[i][j])return;
        visited[i][j] = true;
        count++;
        for(int[] d:directions){
            dfs(grid,i+d[0],j+d[1]);
        }
    }
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        // System.out.println(m+" "+n);
        visited = new boolean[n][m];
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1)
                    sum++;
            }
        }
        // System.out.println(sum);
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(grid,i,0);
            }
            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                dfs(grid,i,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i] == 1 && !visited[0][i]){
                dfs(grid,0,i);
            }
            if(grid[n-1][i] == 1 && !visited[n-1][i]){
                dfs(grid,n-1,i);
            }
        }
        // System.out.println(count);
        return sum-count;
    }
    public static void main(String[] args){
        NumberOfEnclaves obj = new NumberOfEnclaves();
        int[][] arr = {{0,1,1,0,0,1,0},{1,1,1,1,1,0,1},{1,0,1,1,0,0,0}};
        int res = obj.numEnclaves(arr);
        System.out.println(res);
    }
}
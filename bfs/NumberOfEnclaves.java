

import java.util.Arrays;
/*
需要计数的是封闭陆地的数量，就需要先将边边角角都淹没，然后再逐个岛屿计数（淹没）
 */
public class NumberOfEnclaves {
    int count = 0;
    int m,n;
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 ||i>=n ||j>=m)return;
        if(grid[i][j] == 0)return;
        grid[i][j] = 0;
        count++;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||j==0||i== grid.length-1||j== grid[0].length-1) &&grid[i][j] == 1)
                    dfs(grid,i,j);
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] ==1){
                    count = 0;
                    dfs(grid, i, j);
                    sum+=count;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args){
        NumberOfEnclaves obj = new NumberOfEnclaves();
        int[][] arr = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        int res = obj.numEnclaves(arr);
        System.out.println(res);
    }
}
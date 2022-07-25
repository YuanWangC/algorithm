import java.util.Arrays;
/*
最佳做法：首先淹没grid1没有但是grid2有的陆地，相连部分也变成海洋，之后只用处理还是陆地的位置，直接计数
 */
public class CountSubIslands {
//    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public void dfs(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)return;
        if(grid[i][j] == 0)return;
        grid[i][j] = 0;
//        使用方向数组确实很慢TAT，直接传参直接打败95%
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1 && grid1[i][j] == 0){
                    dfs(grid2,i,j);
                }
            }
        }
        for(int[] g:grid2)
            System.out.println(Arrays.toString(g));
        int count = 0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1){
                    System.out.println(i+" "+j);
                    dfs(grid2,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        CountSubIslands obj = new CountSubIslands();
        int res = obj.countSubIslands(grid1,grid2);
        System.out.println(res);
    }
}

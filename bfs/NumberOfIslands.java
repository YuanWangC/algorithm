/*
直接计算相连陆地数量，这些陆地用visited标记，不重复计数
 */
public class NumberOfIslands {
    int count = 0;
    boolean visited[][];
    int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};
    public void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length)return;
        if(grid[i][j] == '0')return;
        if(visited[i][j])return;
        visited[i][j] = true;
        for(int[] d:directions){
            dfs(grid,i+d[0],j+d[1]);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)return 0;
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        NumberOfIslands obj = new NumberOfIslands();
        String[][] grid = {{"1","1","1","1","0"}, {"1","1","0","1","0"}, {"1","1","0","0","0"},{"0","0","0","0","0"}};
        char[][] gridChar = new char[grid.length][grid[0].length];
        obj.visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                gridChar[i][j] = grid[i][j].charAt(0);
            }
        }
        int res = obj.numIslands(gridChar);
        System.out.println(res);
    }
}

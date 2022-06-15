package algorithm;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class MaxPresentTwice {
	//每个位置的最大值max
    int[][] memo;
    //每个位置的最大值path
    HashMap<Integer,ArrayList<Integer[]>> path;
    public boolean isVailed(int[][] grid,int x,int y){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length;
    }
    public int dfs(int[][] grid,int x,int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length)return 0;
        if(memo[x][y]!=0)return memo[x][y];
        int right = dfs(grid,x+1,y);
        int down = dfs(grid,x,y+1);
        int max = grid[x][y];  
        ArrayList<Integer[]> p = null;
        if(!path.containsKey(x*grid[0].length+y)){
            p = new ArrayList<>();
            p.add(new Integer[]{x,y});
        }
        else{
            p = path.get(x*grid[0].length+y);
        }
        //不要遗漏right==down的情况
        if(isVailed(grid,x+1,y) && right>=down){
            max+=right;
            //注意此处需要把子节点积累的path接上
            p.addAll(path.get((x+1)*grid[0].length+y));
        }
        else if(isVailed(grid,x,y+1) && right<down){
            max+=down;
            p.addAll(path.get(x*grid[0].length+y+1));
        }
        memo[x][y] = max;
        path.put(x*grid[0].length+y,p);
        return max;
    }
    public int maxValue(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        path = new HashMap();
        int res1 = dfs(grid,0,0);
        System.out.println(res1);
        for(int[] m:memo)
            System.out.println(Arrays.toString(m));
        for(int i=0;i<path.get(0).size();i++){
            int x = path.get(0).get(i)[0];
            int y = path.get(0).get(i)[1];
            grid[x][y] = 0;
        }
        for(int[] g:grid)
           System.out.println(Arrays.toString(g));    
        memo = new int[grid.length][grid[0].length];
        path = new HashMap();
        int res2 = dfs(grid,0,0);
        return res2;
    }
    public static void main(String[] args) {
    	int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
    	MaxPresentTwice m = new MaxPresentTwice();
    	int result = m.maxValue(grid);
    	System.out.println(result);
    }
}

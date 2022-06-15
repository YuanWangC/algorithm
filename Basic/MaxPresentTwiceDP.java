package algorithm;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
public class MaxPresentTwiceDP {
	    HashMap<Integer,ArrayList<Integer[]>> path;
	    public int maxValue(int[][] grid) {
	        path = new HashMap();
	        int row = grid.length;
	        int col = grid[0].length;
	        int[][] dp = new int[row][col];
	        //提前将所有节点值加入自己的路径中，不用每次都判断是否存在了
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                ArrayList<Integer[]> p = new ArrayList<>();
	                p.add(new Integer[]{i,j});
	                path.put(i*col+j,p);
	            }
	        }
	        dp[row-1][col-1] = grid[row-1][col-1];
	        for(int i=row-2;i>=0;i--){
	            dp[i][col-1] = grid[i][col-1]+dp[i+1][col-1];
	            ArrayList<Integer[]> p1  = path.get(i*col+col-1);
	            p1.addAll(path.get((i+1)*col+col-1));
	            path.put(i*col+col-1,p1);
	        }
	        for(int j=col-2;j>=0;j--){
	            dp[row-1][j] = grid[row-1][j]+dp[row-1][j+1];
	            ArrayList<Integer[]> p2  = path.get((row-1)*col+j);
	            p2.addAll(path.get((row-1)*col+j+1));
	            path.put((row-1)*col+j,p2);
	        }
	        for(int i=row-2;i>=0;i--){
	            for(int j=col-2;j>=0;j--){
	                dp[i][j] = grid[i][j]+Math.max(dp[i+1][j],dp[i][j+1]);
	                ArrayList<Integer[]> p = path.get(i*col+j);
	                if(dp[i+1][j]<dp[i][j+1])
	                    p.addAll(path.get(i*col+j+1));
	                else p.addAll(path.get((i+1)*col+j));
	                path.put(i*col+j,p);
	            }
	        }
	         for(Map.Entry<Integer,ArrayList<Integer[]>> e:path.entrySet()){
	             System.out.println(e.getKey()+" "+e.getValue());
	             for(Integer[] i:e.getValue())
	            	 System.out.println(i[0]+" "+i[1]);
	         }
//	         for(Integer[] e:path.get(0)){
//	             System.out.println(e[0]+" "+e[1]);
//	         }
	        return dp[0][0];
	    }
	    
	public static void main(String[] args) {
		MaxPresentTwiceDP m =new MaxPresentTwiceDP();
		int[][] grid  = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		m.maxValue(grid);
       for(Integer[] p:m.path.get(0)) {
           	 int i = p[0];
           	 int j = p[1];
           	 grid[i][j] = 0;
        }
       for(int[] g:grid) {
    	   System.out.println(Arrays.toString(g));
       }
       m.maxValue(grid);
	}
}

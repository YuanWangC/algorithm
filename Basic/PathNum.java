package Basic;

public class PathNum {
    public int uniquePathsWithObstacles(int[][] m) {
        if(m[0][0] == 0 || m[m.length-1][m[0].length-1]==0)return 0;
        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = 1;

        for(int i=1;i<m.length;i++)
            if(m[i][0] == 0)dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];

        for(int i=1;i<m[0].length;i++)
            if(m[0][i] == 0)dp[0][i] = 0;
            else dp[0][i] = dp[0][i-1];

        for(int i=1;i<m.length;i++){
            for(int j=1;j<m[0].length;j++){
                if(m[i][j]==0)dp[i][j]=0;
                else dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m.length-1][m[0].length-1];
    }

    public static void main(String[] args){
        PathNum obj = new PathNum();
//        int[][] matrix = {{1,1},{0,1}};
//        int[][] matrix = {{1,0},{0,1}};
        int[][] matrix = {{1,1,1,1,1,0,1,0},{0,0,0,1,0,1,0,0},{1,1,1,1,1,0,0,0},{1,0,1,0,0,1,1,0}};
//        int[][] matrix = {{1}};
        int res = obj.uniquePathsWithObstacles(matrix);
        if(res == 0){
            System.out.println(0);
            System.out.println(res);
        }
        else {
            System.out.println(matrix.length+matrix[0].length-2);
            System.out.println(res);
        }
    }
}

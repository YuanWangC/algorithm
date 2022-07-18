package Basic;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class PathNum {
    HashMap<Integer,Integer> memo = new HashMap<>();
    int min = Integer.MAX_VALUE;
    boolean[][] visited;
    int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(int[][] m,int i,int j,int path){
        if(i<0 || i>=m.length || j<0 || j>=m[0].length)return;
        if(visited[i][j])return;
        if(m[i][j] == 0)return;
        if (i == m.length - 1 && j == m[0].length - 1) {
            if(path<=min){
                if(!memo.containsKey(path))
                    memo.put(path,1);
                else memo.put(path,memo.get(path)+1);
                min = path;
            }
            return;
        }
        visited[i][j] = true;
        path++;
        for(int[] d:direct){
            dfs(m,i+d[0],j+d[1],path);
        }
        visited[i][j] = false;
    }
    int count = 0;
    int path = 0;
    public void bfs(int[][] m){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        if(m[0][0] == 0)return;
        que.offer(new int[]{0,0});
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int[] cur = que.poll();
                if(cur[0] == m.length-1 && cur[1] == m[0].length-1){
                    this.count++;
                }
                for(int[] d:direct){
                    int nx = cur[0]+d[0];
                    int ny = cur[1]+d[1];
                    if(nx<0 || ny<0 || nx>=m.length|| ny>=m[0].length)continue;
                    if(m[nx][ny] == 0)continue;
                    que.offer(new int[]{nx,ny});
                }
            }
            if(this.count!=0){
                return;
            }
            this.path++;
        }
        if(this.count == 0)this.path = 0;
    }
    public void uniquePathsWithObstacles(int[][] m) {
        if(m[0][0] == 0 || m[m.length-1][m[0].length-1]==0)return;
        visited = new boolean[m.length][m[0].length];
//        dfs(m,0,0,0);
        bfs(m);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                matrix[i][j] = in.nextInt();
        }
        if(n==1 && matrix[0][0] == 1){
            System.out.println(1);
            System.out.println(1);
        }
        PathNum obj = new PathNum();
        obj.uniquePathsWithObstacles(matrix);
//        if(obj.min == Integer.MAX_VALUE){
//            System.out.println(0);
//            System.out.println(0);
//        }
//        else {
//            System.out.println(obj.min);
//            System.out.println(obj.memo.get(obj.min));
//        }
        System.out.println(obj.path);
        System.out.println(obj.count);
    }
}

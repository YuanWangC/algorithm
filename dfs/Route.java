import java.util.Scanner;

public class Route {
    int steps = Integer.MAX_VALUE;
    boolean flag = true;
    int k;
    boolean[][] visited;
    public void walk(int[][] arr,int i,int j,int times,int step,int pre){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length)return;
        if(visited[i][j])return;
        if(i==arr.length-1 && j==arr[0].length-1){
            steps = Math.min(step,steps);
            return;
        }
        if(times<=0){
            flag = false;
            return;
        }
        if(Math.abs(pre-arr[i][j])>k)times--;
        visited[i][j] = true;
        walk(arr,i+1,j,times,step+1,arr[i][j]);
        walk(arr,i-1,j,times,step+1,arr[i][j]);
        walk(arr,i,j+1,times,step+1,arr[i][j]);
        walk(arr,i,j-1,times,step+1,arr[i][j]);
        visited[i][j] = false;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
            }
        }
        Route obj= new Route();
        obj.k = k;
        obj.visited = new boolean[m][n];
        obj.walk(arr,0,0,3,0,arr[0][0]);
        if(obj.steps == Integer.MAX_VALUE && obj.flag == false){
            System.out.println(-1);
        }else {
            System.out.println(obj.steps);
        }
    }
}

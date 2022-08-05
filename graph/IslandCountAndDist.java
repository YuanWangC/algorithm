import java.util.*;

class UnionFind{
    int count;
    int[] center;
    int[] size;
    int max = 0;
    List<int[]>[] points;
    public UnionFind(int row,int col){
        this.count = row*col;
        this.center = new int[this.count];
        size = new int[this.count];
        points = new List[this.count];
    }
    public void makeSets(){
        for(int i=0;i<center.length;i++){
            center[i] = i;
            size[i] = 1;
        }
    }
    public int find(int cur){
        while(center[cur] != cur){
            center[cur] = center[center[cur]];
            cur = center[cur];
        }
        return cur;
    }
    public void union(int pos1,int pos2){
        int cen1 = find(pos1);
        int cen2 = find(pos2);
        if(cen1 == cen2)return;
        if(size[cen1]<size[cen2]){
            center[cen1] = cen2;
            size[cen2] += size[cen1];
        }
        else {
            center[cen2] = cen1;
            size[cen1] += size[cen2];
        }
        this.count--;
    }
    public boolean isConnect(int pos1,int pos2){
        return find(pos1)==find(pos2);
    }
    public int getDistance(int i,int j,int k,int m){
        return Math.abs(i-k)+Math.abs(j-m);
    }
    public int getMax(){
        for(List<int[]> l:points){
            if(l != null){
                for(int i=0;i<l.size();i++){
                    int[] pi = l.get(i);
                    for(int j=0;j<l.size();j++) {
                        int dist = getDistance(pi[0], pi[1], l.get(j)[0], l.get(j)[1]);
                        if(max<dist)max = dist;
                    }
                }
            }
        }
        return max;
    }
}
public class IslandCountAndDist {
    int col;
    int row;
    int max = 0;
    List<int[]> path = new ArrayList<>();
    int[][] directions = {{1, 0}, {0, 1},{-1, 0}, {0, -1}};
    public int getIndex(int x,int y){
        return x*col + y;
    }
    public boolean isVailed(int x,int y){
        return x>=0 && x<row && y>=0 && y<col;
    }
    public int getDistance(int i,int j,int k,int m){
        return Math.abs(i-k)+Math.abs(j-m);
    }
    public int count(int[][] board){
        col = board[0].length;
        row = board.length;
        UnionFind u = new UnionFind(row,col);
        u.makeSets();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 0) u.count--;
                if(board[i][j] == 1){
                    int center = u.find(getIndex(i, j));
                    for(int[] d:directions){
                        int newx = i+d[0];
                        int newy = j+d[1];
                        if(isVailed(newx,newy) && board[newx][newy] == 1) {
                            u.union(getIndex(i, j), getIndex(newx, newy));
                            if(u.points[center] == null) {
                                u.points[center] = new ArrayList<>();
                            }
                            u.points[center].add(new int[]{newx, newy});
                        }
                    }
                }
            }
        }
        u.getMax();
        max = u.max;
        return u.count;
    }
    public void countDFS(int[][] board,int i,int j){
        if(!isVailed(i,j))return;
        if(board[i][j] == 0)return;
        board[i][j] = 0;
        path.add(new int[]{i,j});
        countDFS(board,i+1,j);
        countDFS(board,i,j+1);
        countDFS(board,i-1,j);
        countDFS(board,i,j-1);
    }
    public static void main(String[] args){
        IslandCountAndDist object= new IslandCountAndDist();
        Scanner in = new Scanner(System.in);
        object.row = in.nextInt();
        object.col = in.nextInt();
        int[][] matrix = new int[object.row][object.col];
        for(int i=0;i<object.row;i++){
            for(int j=0;j<object.col;j++){
                matrix[i][j] = in.nextInt();
            }
        }
//        int count = object.count(matrix);
//        System.out.println(count);
//        System.out.println(object.max);
        int count =0;
        for(int i=0;i<object.col;i++){
            for(int j=0;j<object.row;j++){
                if(matrix[i][j] == 1){
                    count++;
                    object.countDFS(matrix,i,j);
                    for(int i2=0;i2<object.path.size();i2++){
                        int[] pi = object.path.get(i);
                        for(int j2=0;j2<object.path.size();j2++) {
                            int dist = object.getDistance(pi[0], pi[1], object.path.get(j2)[0], object.path.get(j2)[1]);
                            if(object.max<dist)object.max = dist;
                        }
                    }
                    object.path = new ArrayList<>();
                }
            }
        }
        System.out.println(count);
        System.out.println(object.max);
    }
}

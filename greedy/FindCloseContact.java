import java.util.*;
/*
L
6 5
A B C D E
F G H I J
K L M N O
P Q R S T
U V W X Y
Z 0 1 2 3
 */
public class FindCloseContact {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
    boolean[][] visited;
    public boolean isVaild(String[][] names,int x,int y){
        return x>=0 && x< names.length &&y>=0 && y<names[0].length;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String name = in.next();
        int m = in.nextInt();
        int n = in.nextInt();
        String[][] names = new String[m][n];
        List<String> res = new ArrayList<>();
        int[] target = null;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                names[i][j] = in.next();
                if(names[i][j].equals(name))target = new int[]{i,j};
            }
        }
        if(target == null) System.out.println(res);
        FindCloseContact obj = new FindCloseContact();
        obj.visited = new boolean[m][n];
        obj.visited[target[0]][target[1]] = true;
        List<String> first = new ArrayList<>();
        List<int[]> secondindex = new ArrayList<>();
        for(int[] d:obj.directions){
            int newX = target[0]+d[0];
            int newY = target[1]+d[1];
            if(obj.isVaild(names,newX,newY) && !obj.visited[newX][newY]){
                obj.visited[newX][newY] = true;
                first.add(names[newX][newY]);
                secondindex.add(new int[]{newX,newY});
            }
        }
        Collections.sort(first);
        List<String> second = new ArrayList<>();
        for(int[] s:secondindex){
            for(int[] d:obj.directions){
                int newX = s[0]+d[0];
                int newY = s[1]+d[1];
                if(obj.isVaild(names,newX,newY) && !obj.visited[newX][newY]){
                    obj.visited[newX][newY] = true;
                    second.add(names[newX][newY]);
                }
            }
        }
        Collections.sort(second);
        first.addAll(second);
        System.out.println(first);
    }
}

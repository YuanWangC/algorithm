import java.util.ArrayDeque;
import java.util.HashSet;

public class SlidingPuzzle {
    int[][] neighbor = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    HashSet<String> set = new HashSet<>();
    String target = "123450";
    int count = 0;
    public void bfs(String arr){
        ArrayDeque<String> que = new ArrayDeque<>();
        que.offer(arr);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                String cur = que.poll();
                if(cur.equals(target))return;
                int index = cur.indexOf('0');
//                System.out.println(cur+" "+index);
                for(int j=0;j<neighbor[index].length;j++){
                    //注意此处换的不是j，而是neighbor[index][j]中保存的序号
                    String s = swap(cur,index,neighbor[index][j]);
                    if(set.contains(s))continue;
                    set.add(s);
                    que.offer(s);
//                    System.out.println(s);
                }
            }
            count++;
        }
        count = -1;
    }
    public String swap(String s,int i,int j){
        char[] sc = s.toCharArray();
        sc[i] = sc[j];
        sc[j] = '0';
        return new String(sc);
    }
    public int slidingPuzzle(int[][] board) {
        char[] arr = new char[6];
        int  k = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                arr[k++] = (char)(board[i][j]+'0');
            }
        }
//        System.out.println(arr);
        if(String.valueOf(arr).equals(target))return 0;
        bfs(String.valueOf(arr));
        return count;
    }
    public static void main(String[] args){
        SlidingPuzzle object= new SlidingPuzzle();
        int[][] board = {{4,1,2},{5,0,3}};
//        int[][] board = {{1,2,3},{5,4,0}};
        int res = object.slidingPuzzle(board);
        System.out.println(res);
    }
}

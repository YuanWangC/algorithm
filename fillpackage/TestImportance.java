import java.util.*;

/*
11 5
8 4
2 2
6 2
9 7
 */
public class TestImportance {
    public static void main(String[] args){
        TestImportance obj = new TestImportance();
        Scanner in = new Scanner(System.in);
        int[] work = new int[5];
        int[] imp = new int[5];
        for(int i=0;i<5;i++){
            work[i] = in.nextInt();
            imp[i] = in.nextInt();
        }
        int[][] dp = new int[6][21];
        int[][] res = new int[6][21];
        for(int i=1;i<=5;i++){
            for(int j=1;j<=20;j++) {
                if (j >= work[i-1]) {
                    if(dp[i - 1][j]>dp[i - 1][j - work[i-1]] + imp[i-1]){
                        dp[i][j] = dp[i - 1][j];
                        res[i][j] = 0;
                    } else if(dp[i - 1][j]<dp[i - 1][j - work[i-1]] + imp[i-1]){
                        dp[i][j] = dp[i - 1][j - work[i-1]] + imp[i-1];
                        res[i][j] = 1;
                    }
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                    res[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(res[5]));
    }
}
class Player{
    int pid;
    String name;
}
class Play {
    HashMap<Integer, List<Integer>> teams = new HashMap<>();

    public int Create(int pid) {
        List<Integer> t = new ArrayList<>();
        t.add(pid);
        teams.put(pid,t);
        return pid;
    }
    public boolean Request(int pid,int tid) {
        List<Integer> t = teams.get(tid);
        if(t.size()==5)return false;
        t.add(pid);
        teams.put(pid,t);
        return true;
    }
    public static void main(String[] args){
        Player[] ps = new Player[10000];
        for(int i=1;i<10000;i++){
            ps[i-1] = new Player();
            ps[i-1].name = "robot"+i;
            ps[i-1].pid = i;
        }
    }
}
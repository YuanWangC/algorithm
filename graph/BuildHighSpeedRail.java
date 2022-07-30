import javax.management.relation.InvalidRelationTypeException;
import java.util.*;

public class BuildHighSpeedRail {
    int n;
    HashMap<Integer,List<List<Integer>>> graph = new HashMap();
    boolean[] visited;
    int count = 1;
    int costMin = Integer.MAX_VALUE;
    boolean flag = false;
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[][] haveto;
    HashSet<Integer> set = new HashSet<>();
    public void build(int[][] arr){
        for(int[] a:arr){
            ArrayList<Integer> l1 = new ArrayList<>();
            l1.add(a[1]);
            l1.add(a[2]);
            List<List<Integer>> ll1 = graph.getOrDefault(a[0],new ArrayList<>());
            ll1.add(l1);
            graph.put(a[0],ll1);

            ArrayList<Integer> l2 = new ArrayList<>();
            l2.add(a[0]);
            l2.add(a[2]);
            List<List<Integer>> ll2 = graph.getOrDefault(a[1],new ArrayList<>());
            ll2.add(l2);
            graph.put(a[1],ll2);
        }
        System.out.println(graph);
    }
    public void dfs(int index,int costCur){
        if(set.size() == n){
            flag = true;
            System.out.println(index+" "+costCur+" "+Arrays.toString(visited));
            for(int[] a:haveto){
                int find = path.indexOf(a[0]);
                if(find<path.size()-1) {
                    if(path.get(find+1)==a[1])
                    continue;
                }
                else if(find>0 && path.get(find-1)==a[1])continue;
                else return;
            }
            if(costCur<costMin){
                costMin = costCur;
            }
            return;
        }
        for(List<Integer> l:graph.get(index)){
            int next = l.get(0);
            System.out.println(next);
            if(visited[next])continue;
            if(set.contains(next))continue;
            visited[next] = true;
            path.add(next);
            set.add(next);
            dfs(next,costCur+l.get(1));
            set.remove(next);
            path.remove(path.size()-1);
            visited[next] = false;
        }
    }
    public boolean check(int[][] arr){
        for(int i=1;i<n;i++){
            dfs(i,0);
            if(!flag) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int n = 3,s = 3,l = 1;
        int[][] arr = {{1,2,10},{1,3,100},{2,3,50}};
        int[][] haveto = {{1,3}};
        BuildHighSpeedRail obj = new BuildHighSpeedRail();
        obj.build(arr);
        obj.n = 3;
        obj.visited = new boolean[n+1];
        obj.haveto = haveto;
        boolean res = obj.check(arr);
        if(!res) System.out.println(-1);
        else{
            System.out.println(obj.costMin);
        }
    }
}

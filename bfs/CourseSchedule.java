import java.util.*;

public class CourseSchedule {
    boolean flag = true;
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, List<Integer>> memo = new HashMap();
    public void bfs(int index){
        ArrayDeque<Integer> que = new ArrayDeque();
        que.offer(index);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Integer cur = que.poll();
                if(set.contains(cur)){
                    flag = false;
                    return;
                }
                if(memo.get(cur) == null)continue;
                set.add(cur);
                for(Integer k:memo.get(cur)){
                    System.out.println(k);
                    que.offer(k);
                }
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1)return true;
        for(int[] p:prerequisites){
            List<Integer> l;
            if(memo.containsKey(p[1])){
                l = memo.get(p[1]);
            }
            else{
                l = new LinkedList();
            }
            l.add(p[0]);
            memo.put(p[1],l);
        }
        System.out.println(memo);
        for(int i=0;i<numCourses;i++){
            if(set.contains(i))continue;
            bfs(i);
            System.out.println(set);
            if(!flag)break;
        }
        return flag;
    }
    public static void main(String[] args){
        CourseSchedule obj = new CourseSchedule();
        int num = 5;
        int[][] courses = {{1,4},{2,4},{3,1},{3,2}};
        boolean res = obj.canFinish(num,courses);
        System.out.println(res);
    }
}

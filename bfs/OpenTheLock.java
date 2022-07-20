import java.util.ArrayDeque;
import java.util.HashSet;

public class OpenTheLock {
    HashSet<String> dead;
    HashSet<String> set;
    int count = 0;
    public String change(String s,int index,boolean flag){
        StringBuilder sb = new StringBuilder(s);
        char c = s.charAt(index);
        if(flag){
            if(c!='9')c++;
            else c='0';
        }
        else{
            if(c!='0')c--;
            else c='9';
        }
        sb.replace(index,index+1,String.valueOf(c));
        return sb.toString();
    }
    public void bfs(String s,String target){
        if(dead.contains(s)){
            count = -1;
            return;
        }
        ArrayDeque<String> que = new ArrayDeque();
        que.add(s);
        set.add(s);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                String cur = que.poll();
                if(cur.equals(target))return;
                for(int j=0;j<4;j++){
                    String s1 = change(cur,j,true);
                    if(!dead.contains(s1) && !set.contains(s1)){
                        set.add(s1);
                        que.offer(s1);
                    }
                    String s2 = change(cur,j,false);
                    if(!dead.contains(s2) && !set.contains(s2)){
                        set.add(s2);
                        que.offer(s2);
                    }
//                     System.out.println(s1+" "+s2);
                }
            }
            count++;
        }
        count = -1;
    }
    public int openLock(String[] deadends, String target) {
        dead = new HashSet();
        set = new HashSet();
        for(String s:deadends)
            dead.add(s);
        bfs("0000",target);
        return count;
    }
    public static void main(String[] args){
        OpenTheLock obj = new OpenTheLock();
        String[] dead = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        long start = System.currentTimeMillis();
        int res = obj.openLock(dead,target);
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
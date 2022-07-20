import java.util.HashSet;

public class OpenTheLockBidirectionalBFS {
    HashSet<String> dead;
    HashSet<String> used;
    HashSet<String> que1;
    HashSet<String> que2;
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
        if(dead.contains(s))return;
        que1.add(s);
        que2.add(target);
        //需要used来维护一个非环路，不走回头路
        used.add(s);
        HashSet<String> que = que1;
        while(!que.isEmpty()){
            HashSet<String> temp = new HashSet<>();
            for(String cur:que){
                if(dead.contains(cur))continue;
                //与上一层出现交集，路通了
                if(que2.contains(cur))return;
                //在此处添加到used中，在子节点添加的话，que和que2就不会出现交集
//                used.add(cur);
                for(int i=0;i<s.length();i++) {
                    String s1 = change(cur, i, true);
                    if(!used.contains(s1)) {
                        temp.add(s1);
//                        used.add(s1);
                    }
                    String s2 = change(cur,i, false);
                    if(!used.contains(s2)) {
                        temp.add(s2);
//                        used.add(s2);
                    }
                }
            }
            count++;
            que = que2;
            que2 = temp;
        }
    }
    public int openLock(String[] deadends, String target) {
        dead = new HashSet();
        used = new HashSet<>();
        que1 = new HashSet<>();
        que2 = new HashSet<>();
        for(String s:deadends)
            dead.add(s);
        bfs("0000",target);
        return count;
    }
    public static void main(String[] args){
        OpenTheLockBidirectionalBFS obj = new OpenTheLockBidirectionalBFS();
        String[] dead = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        long start = System.currentTimeMillis();
        int res = obj.openLock(dead,target);
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

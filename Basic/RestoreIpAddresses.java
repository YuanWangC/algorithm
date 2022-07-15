package Basic;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> sb = new ArrayList<>();
    List<String> res = new ArrayList<>();
//    首先，需要装4个篮子，每个篮子里的数需要满足区间[0,255]
    public void check(String s,StringBuilder sb2, int buckets,int start){
        if(buckets == 4){
            String ip1 = String.join("",sb);
//            System.out.println(ip1);
            if(ip1.length()<s.length())return;
            String ip2 = String.join(".",sb);
            res.add(ip2);
            return;
        }
        if(buckets>4)return;
        for(int i=start+1;i<=s.length();i++){
            String cur = s.substring(start,i);
//            System.out.println(start+" "+cur);
            if(Integer.parseInt(cur) > 255){
                break;
            }
//            注意像00,01,020这样的数是不合法的
            if(cur.length()>1 && cur.charAt(0) == '0'){
                break;
            }
//            System.out.println("after: "+cur);
            sb.add(cur);
            check(s,sb2,buckets+1,i);
            sb.remove(sb.size()-1);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<=3)return res;
        String[] sc = new String[s.length()];
        for(int i=0;i<s.length();i++){
            sc[i] = s.substring(i,i+1);
        }
        if(sc.length == 4){
            res.add(String.join(".",sc));
            return res;
        }
        StringBuilder sb = new StringBuilder();
        check(s,sb,0,0);
//        for(String s2:res)
//            System.out.println(s2);
        return res;
    }
    public static void main(String[] args){
        RestoreIpAddresses object= new RestoreIpAddresses();
//        String str = "10203040";
//        String str = "25525511135";
        String str = "010010";
        List<String> res = object.restoreIpAddresses(str);
        for(String s:res)
            System.out.println(s);
    }
}

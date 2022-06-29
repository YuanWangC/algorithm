package String;
import java.util.Scanner;
public class BackspaceStringCompare {
    public boolean backspaceCompare1(String s, String t) {
        int i=s.length()-1,j=t.length()-1;
        int snum = 0,tnum = 0;
        while(true){
            while(i>=0){
                if(s.charAt(i) == '#'){
                    snum++;
                }
                else{
                    if(snum>0) snum--;
                    else break;
                }
                i--;
            }
            while(j>=0){
                if(t.charAt(j) == '#'){
                    tnum++;
                }
                else{
                    if(tnum>0) tnum--;
                    else break;
                }
                j--;
            }
            // System.out.println(i+" "+j);
            if(i<0 && j<0)return true;
            else if(j<0 || i<0)return false;
            if(s.charAt(i) == t.charAt(j)){
                i--;
                j--;
            }
            else break;
        }
        return false;
    }
    public String solveString(String s){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            while(i<s.length() && s.charAt(i) != '#'){
                sb.append(s.charAt(i++));
            }
            // System.out.println(i+" "+sb);
            while(i<s.length() && s.charAt(i) == '#'){
                if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
                i++;
            }
        }
        return sb.toString();
    }
    public boolean backspaceCompare2(String s, String t) {
        String s2 = solveString(s);
        String t2 = solveString(t);
        // System.out.println("res:"+s2+" "+t2);
        if(t2.equals(s2))return true;
        return false;
    }
    public static void main(String[] args){
        BackspaceStringCompare obj = new BackspaceStringCompare();
        Scanner in = new Scanner(System.in);
        while(!in.hasNext("q")){
            String s = in.nextLine();
            System.out.println("input s:"+s);
            String t = in.nextLine();
            System.out.println("input t:"+t);
            boolean res = obj.backspaceCompare2(s,t);
            System.out.println(res);
        }
    }

}
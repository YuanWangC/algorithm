package String;
import java.util.Scanner;
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
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
        if(i<0 && j<0)return true;
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
            boolean res = obj.backspaceCompare(s,t);
            System.out.println(res);
        }
    }

}
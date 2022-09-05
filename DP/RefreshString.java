package DP;

public class RefreshString {
    public static String count(String s,int k){
        int firstMax = 0;
        int[] sc = new int[s.length()];
        for(int i=0;i<s.length();i++)
            sc[i] = s.charAt(i)-'a';
        int preMax = 0;
        boolean has = false;
        for(int i=0;i<sc.length;i++){
            if(sc[i]>k){
                has =true;
                firstMax = sc[i];
                break;
            }
            if(preMax<sc[i]) preMax = sc[i];
        }
        System.out.println(firstMax+" "+preMax+" "+k);
        int target = firstMax-(k-preMax);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sc.length;i++){
            if(sc[i]<=preMax){
                sb.append('a');
            }else if(has){
                if(sc[i]>target && sc[i]<=firstMax){
                    sb.append((char)(target+'a'));
                }
                else sb.append((char)(sc[i]+'a'));
            }else sb.append((char)(sc[i]+'a'));
        }
        return new String(sb);
    }
    public static void main(String[] args){
        String s = "gndcafb";
        int k = 5;
        System.out.println(count(s,k));
    }
}
/*
输入：
4
3 2
acb
4 5
fgde
7 5
gndcafb
4 19
ekyv
输出：
aaa
agaa
bnbbabb
aapp
 */
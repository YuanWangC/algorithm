package Basic;

import java.util.ArrayDeque;

public class DecodeString {
    public String decodeString(String s) {
        ArrayDeque<String[]> stk = new ArrayDeque();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+(s.charAt(i)-'0');
            }
            else if(s.charAt(i) == '['){
                stk.push(new String[]{res.toString(),String.valueOf(num)});
                res = new StringBuilder();
                num = 0;
            }
            else if(s.charAt(i) == ']'){
                String[] cur = stk.pop();
                int n = Integer.parseInt(cur[1]);
                // System.out.println(res +" "+ n);
                StringBuilder temp = new StringBuilder();
                for(int k=0;k<n;k++){
                    temp.append(res);
                }
                res = temp.insert(0,cur[0]);
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        DecodeString obj = new DecodeString();
        String res = obj.decodeString("abc3[a3[d]bdf]def");
        System.out.println(res);
    }
}

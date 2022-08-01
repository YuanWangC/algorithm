import java.util.ArrayDeque;

public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayDeque<Character> stk = new ArrayDeque();
        char[] sc = s.toCharArray();
        if(sc.length==0)return false;
        if(sc.length%2!=0)return false;
        if(sc[0] != '[' && sc[0] != '(' && sc[0] != '{')return false;
        int index = 1;
        stk.push(sc[0]);
//        遍历直到字符串每一个都被判断过，栈为空不是条件，因为匹配过程中会出现栈空情况
        while(index<sc.length){
//            一步一步遍历字符串
            if((sc[index] == '[' ||sc[index] == '(' || sc[index] == '{')){
                stk.push(sc[index]);
            }
            else{
//                需要反括号时没有可与之匹配的，false
                if(stk.isEmpty())return false;
                char cur = stk.peek();
                // System.out.println(cur +" "+ sc[index]);
                if(cur == '[' && sc[index] == ']'){
                    stk.pop();
                }
                else if(cur == '(' && sc[index] == ')'){
                    stk.pop();
                }
                else if(cur == '{' && sc[index] == '}'){
                    stk.pop();
                }
//                其他组合都是false
                else return false;
            }
            index++;
        }
        if(stk.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args){
        ValidParentheses obj = new ValidParentheses();
        String s = ")))(((";
        boolean res = obj.isValid(s);
        System.out.println(res);
    }
}
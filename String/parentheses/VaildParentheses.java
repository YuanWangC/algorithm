package String.parentheses;

import java.util.Stack;

class VaildParentheses {
    public boolean isValid(String s) {
        Stack st = new Stack();
        if(s.length() ==0)return true;
        if(s.length()%2!=0)return false;
        if(s.charAt(0) == ')' || s.charAt(0) == ']' ||s.charAt(0) == '}')return false;
        st.push(s.charAt(0));
        int index = 1;
        while(index<s.length()){
            if(s.charAt(index) == '(' || s.charAt(index) == '[' || s.charAt(index) == '{')
                st.push(s.charAt(index));
            else{
                if(st.isEmpty())return false;
                char top = (char)st.peek();
                if((s.charAt(index) == ')' && top == '(') ||(s.charAt(index) == ']' && top == '[')||(s.charAt(index) == '}' && top == '{')){
                    st.pop();
                }
                else return false;
            }
            index++;
        }
        if(!st.isEmpty())return false;
        return true;
    }
}
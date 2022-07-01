package Basic;

import java.util.Stack;

public class HTMLmatch {
    public int getLeftTag(String s,int index){
        int right = -1;
        for (;index<s.length();index++){
            if(s.charAt(index) == '<' || (s.charAt(index)<=122 && s.charAt(index)>=97)){
                continue;
            }
            else if(s.charAt(index) == '>') {
                right = index;
                break;
            }
            else break;
        }
        if(right == index)return -1;
        return right;
    }
    public int getRightTag(String s,int index,String left){
        int right = -1;
        String l = "</"+left.substring(1,left.length()-1)+">";
        if(!s.substring(index,index+l.length()).equals(l))return right;
        return index+l.length();
    }
    public boolean isValid(String s) {
        Stack st = new Stack();
        if(s.length() ==0)return true;
        if(s.charAt(0) != '<' || s.charAt(s.length()-1) != '>')return false;
        int right = getLeftTag(s,0);
        if(right ==-1)return false;
        st.push(s.substring(0,right+1));
        int index = right+1;
        if(index>s.length())return false;
        while(index<s.length()){
            if(s.charAt(index)<=122 && s.charAt(index)>=97)
                index++;
            else if(!st.isEmpty() && s.charAt(index) == '<' && s.charAt(index+1) == '/'){
                index = getRightTag(s,index,(String)st.peek());
                if(index == -1)return false;
                st.pop();
            }
            else if(st.isEmpty() || s.charAt(index) == '<'){
                int temp = index;
                index = getLeftTag(s,index)+1;
                if(index == -1)return false;
                st.push(s.substring(temp,index));
            }
            else return false;
            System.out.println(st);
        }
        if(st.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args){
        HTMLmatch obj = new HTMLmatch();
        boolean res = obj.isValid("<a></>");
        System.out.println(res);
    }
}

package Basic;

public class ExpressionTimeCount {
    public int count(String s){
        if(s.length()<2)return 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '*'){
                res+=2;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                res+=1;
            }
            else if(s.charAt(i) == '/'){
                res+=4;
            }
        }
        return res;
    }
    public static void main(String[] args){
        ExpressionTimeCount obj = new ExpressionTimeCount();
        String s  = "a*(b-c)";
        int res = obj.count(s);
        System.out.println(res);
    }
}

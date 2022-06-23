package Basic;

public class StringRepresentNumbers {
    public boolean checkDouble(String s, int start, int end){
        boolean hasDecimal=false, signBit = false;
        if(!signBit && (s.charAt(start) == '+' || s.charAt(start) == '-')){
            signBit = true;
            start++;
        }
        if(start == end)return false;
        if(start+1 == end && s.charAt(start) == '.')return false;
        while(start<end){
            if(!hasDecimal && s.charAt(start) == '.'){
                start++;
                hasDecimal= true;
            }
            else if(s.charAt(start)>=48 && s.charAt(start)<=57){
                start++;
            }
            else return false;
        }
        return true;
    }
    public boolean checkInt(String s, int start, int end){
        boolean signBit = false;
        if(!signBit && (s.charAt(start) == '+' || s.charAt(start) == '-')){
            signBit = true;
            start++;
        }
        if(start == end)return false;
        while(start<end){
            if(s.charAt(start)>=48 && s.charAt(start)<=57){
                start++;
            }
            else return false;
        }
        return true;
    }
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0)return false;
        int start = 0;
        int e = 0;
        boolean res = true;
        boolean hasE = false;
        while(e<s.length()){
            if(!hasE && (s.charAt(e) == 'e' || s.charAt(e) == 'E')){
                hasE = true;
                if(e==start || s.length() == e+1)return false;
                res &= (checkDouble(s,start,e)||checkInt(s,start,e));
                res &= checkInt(s,e+1,s.length());
                break;
            }
            e++;
        }
        // System.out.println(checkInt(s,0,s.length()));
        // System.out.println(checkDouble(s,0,s.length()));
        if(hasE)return res;
        else res = (checkDouble(s,0,s.length())||checkInt(s,0,s.length()));
        return res;
    }
    public static void main(String[] args){
        StringRepresentNumbers obj = new StringRepresentNumbers();
        String[] strs1 = {"+100", "5e2", "-123", "3.1416", "-1.1E-16", "0123"};
        String[] strs2 = {"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
        for(String s:strs1)
            System.out.println(obj.isNumber(s));
        for(String s:strs2)
            System.out.println(obj.isNumber(s));
    }
}

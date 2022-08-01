package String;

class RegexMatchRecursion {
    public boolean isMatch(String s, String p) {
        // System.out.println(s+" "+p);
        if(s.length() == 0 && p.length()==0)return true;
        if(s.length()==0 && p.length()>0){
            if(p.length()%2!=0)return false;
            int i=1;
            while(i<p.length()){
                if(p.charAt(i) != '*')return false;
                i+=2;
            }
            return true;
        }
        if(p.length()==0)return false;
        if(p.length() == 1 && s.length() == 1) {
            if(p.charAt(0) == '.')return true;
            return s.charAt(0) == p.charAt(0);
        }
        char c3 = '#';
        if (p.length() > 1) {
            c3 = p.charAt(1);
        }
        if(c3 != '*'){
            if(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                return isMatch(s.substring(1),p.substring(1));
            else return false;
        }
        else{
            if(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                return isMatch(s.substring(1),p.substring(0)) || isMatch(s.substring(0),p.substring(2));
            else
                return isMatch(s.substring(0),p.substring(2)); 
        }
    }
}
import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0,right = 0,valid = 0;
        HashMap<Character,Integer> window = new HashMap();
        HashMap<Character,Integer> need = new HashMap();
        for(int i=0;i<s1.length();i++)
            need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);

        while(right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c)))
                    valid++;
            }

            if(right-left>=s1.length()){
                if(valid == need.size())return true;
                char l = s2.charAt(left);
                left++;
                if(need.containsKey(l)){
                    if(need.get(l).equals(window.get(l)))
                        valid--;
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        PermutationInString obj=new PermutationInString();
        String s1 = "";
        String s2 = "";
        boolean res = obj.checkInclusion(s1,s2);
        System.out.println(res);
    }
}

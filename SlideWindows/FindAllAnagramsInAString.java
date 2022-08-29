import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
    找出s中所有包含p的排列的子串索引起始位置
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int left = 0,right = 0,valid = 0;
        List<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> window = new HashMap();
        HashMap<Character,Integer> need = new HashMap();
        for(int i=0;i<p.length();i++)
            need.put(p.charAt(i),need.getOrDefault(p.charAt(i),0)+1);

        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c)))
                    valid++;
            }

            while(right-left>=p.length()){
                if(valid == need.size()){
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;
                if(need.containsKey(l)){
                    if(need.get(l).equals(window.get(l)))
                        valid--;
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        List<Integer> res = obj.findAnagrams(s,p);
        System.out.println(res);
    }
}

import java.util.HashMap;
/*
    统计s中自含有另一个字符串t非所有字符的最短子字符串
 */
public class ShortestStringWithAllCharacters {
    public String minWindow(String s, String t) {
        if(s.equals(t))return t;
        int left = 0,right = 0;
        HashMap<Character,Integer> need = new HashMap();
        HashMap<Character,Integer> window = new HashMap();
        int vaild = 0;
//        最小值初始化尽可能大一些
        int min = Integer.MAX_VALUE;
        String res = "";
//        String想要使用for each，就需要使用toCharArray转换
        for(char c:t.toCharArray())
            need.put(c,need.getOrDefault(c,0)+1);
        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
//                window统计的是窗口中合格的字符的数量
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    vaild++;
                }
            }
//            此处指的是所有的有效字符已经被包括在窗口里面了
            while(vaild >= need.size()){
//                包含有效值，才能继续计算最短字符串长度
                if(min>right-left){
                    // System.out.println("run here");
                    min = right-left;
                    res = s.substring(left,right);

                }
                char l = s.charAt(left);
                left++;
                if(need.containsKey(l)){
                    if(window.get(l).equals(need.get(l))){
                        vaild--;
                    }
//                    vaild和窗口window内的字符数量的统计没有关系
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        ShortestStringWithAllCharacters obj = new ShortestStringWithAllCharacters();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = obj.minWindow(s,t);
        System.out.println(res);
    }
}
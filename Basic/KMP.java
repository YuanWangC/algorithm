package Basic;

public class KMP {
    int[][] dfa;
    private void buildDFA(String pattern){
        dfa = new int[pattern.length()][256];
        int pre = 0;
        dfa[0][pattern.charAt(0)] = 1;
        for(int i=1;i<pattern.length();i++){
            for(int j=0;j<256;j++){
//                如果匹配就推进状态
                if(j == pattern.charAt(i))
                    dfa[i][j]=i+1;
                else
//                    如果不匹配，就查找pre上对应字符的所指的位置
                    dfa[i][j] = dfa[pre][j];
            }
//            pre更新，按照目前已匹配的字符和原始pre更新
            pre = dfa[pre][pattern.charAt(i)];
//            System.out.println(pre+" "+pattern.charAt(i));
        }
    }

    private boolean search(String pattern, String txt) {
        int pos = 0;
        for(int i=0;i<txt.length();i++){
             pos = dfa[pos][txt.charAt(i)];
             System.out.println(txt.charAt(i)+" "+pos);
             if(pos == pattern.length()){
//                 计算在txt串上，pattern头部到达的位置
                 int res = i-pattern.length()+1;
                 System.out.println("match success at: "+res);
                 return true;
             }
         }
        return false;
    }
    public static void main(String[] args){
        KMP obj = new KMP();
//        String pattern = "abababac";
//        String txt = "aababaabababac";
        String pattern = "ABABC";
        String txt = "ABABAABABC";
        obj.buildDFA(pattern);
        boolean res = obj.search(pattern,txt);
        System.out.println(res);
    }
}

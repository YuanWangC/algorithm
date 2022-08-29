public class AfterReplacementLongestSameSubString {
    public static int characterReplacement(String s, int k) {
        int left = 0,right = 0;
        int count= 0;
        int res=0;
        int[] alp = new int[26];
        while(right<s.length()){
            char c = s.charAt(right++);
            alp[c-'A']++;
            count = Math.max(count,alp[c-'A']);
            while(right-left>count+k){
                alp[s.charAt(left++)-'A']--;
            }
            res = Math.max(res,right-left);

        }
        return res;
    }
    public static void main(String[] args){
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}

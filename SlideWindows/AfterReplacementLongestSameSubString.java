public class AfterReplacementLongestSameSubString {
    public static int characterReplacement(String s, int k) {
        int left = 0,right = 0;
        int count= 0;
        int res=0;
        int[] alp = new int[26];
        while(right<s.length()){
            char c = s.charAt(right);
            alp[c-'A']++;
            //求出现频次最大的字母
            count = Math.max(count,alp[c-'A']);
            //数组长度需要满足条件小于count+k，否则需要将left前移
            //此时把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
            while(right-left+1>count+k){
                alp[s.charAt(left++)-'A']--;
            }
            res = Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
    public static void main(String[] args){
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}

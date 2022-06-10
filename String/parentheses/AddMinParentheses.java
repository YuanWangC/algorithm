class AddMinParentheses{
    public int minAddToMakeValid(String s) {
        if(s.length() ==1)return 1;
        int right = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                right++;
            else right--;
            if(right<0) {
                right=0;
                count++;
            }
            // System.out.println(i+" "+right);
        }
        // count是未被匹配到的右括号
        // right是未被匹配到的左括号数量（需要right个右括号匹配）
        return count+right;
    }
}
class AddParenthesesDerivation {
    public int minInsertions(String s) {
        if(s.length() == 1 && s.charAt(0) == '(')return 2;
        // 插入次数
        int count = 0; 
        // 需要右括号的数量
        int right = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                right+=2;
                if(right%2!=0){
                    count++;
                    right--;
                }
            } 
            else if(s.charAt(i) == ')'){
                right--;
                // 右括号开始富余
                if(right<0){
                    count++;
                    // 左括号需要两个右括号，已有一个，因此需求变为1
                    right=1;
                }
            }
        }
        return count+right;
    }
}
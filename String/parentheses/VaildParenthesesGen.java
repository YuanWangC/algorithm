class VaildParenthesesGen {
    List<String> res;
    int n;
    public void dfs(int index,int right,int left,StringBuilder path){
        // System.out.println(index+" "+right+" "+left+" "+path);
        if(right>n || left>n)return;
        // 剪枝：左括号不超过n，右括号不超过左括号数
        if(right>left)return;
        if(index>=n && path.length()>=2*n){
            res.add(path.toString());
            return;
        }
        StringBuilder leftPath = new StringBuilder(path).append('(');
        dfs(index+1,right,left+1,leftPath);
        StringBuilder rightPath = new StringBuilder(path).append(')');
        dfs(index+1,right+1,left,rightPath);
    }
    public List<String> generateParenthesis(int n) {
        res =new ArrayList<>();
        this.n = n;
        StringBuilder path = new StringBuilder();
        dfs(0,0,0,path);
        return res;
    }
}
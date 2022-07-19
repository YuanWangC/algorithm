public class TreePathSumEqualsTarget {
    public boolean dfs(TreeNode root,int target){
        if(root == null)return false;
        if(root.left == null && root.right == null && target == root.val)return true;
        boolean l = dfs(root.left,target-root.val);
        //  这样剪枝可以提高效率
        if(l)return l;
        boolean r = dfs(root.right,target-root.val);
        //  这样剪枝可以提高效率
        return r;
    }
    public static void main(String[] args){
        TreePathSumEqualsTarget obj = new TreePathSumEqualsTarget();
        String[] s = {"5","4","8","11","null","13","4","7","2","null","null","null","1"};
        TreeNode root = TreeNode.Build(s);
        int target = 22;
        boolean res = obj.dfs(root,target);
        System.out.println(res);
    }
}

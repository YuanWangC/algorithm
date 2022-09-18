package Tree;

public class PathSum {
    static boolean flag = false;
    public static void check(TreeNode root,int sum){
        if(flag)return;
        if(root == null)return;
        if(root.left == null && root.right == null && sum == root.val){
            flag = true;
            return;
        }
//        用减法求是否存在该路径和，可以减少记录target和sum的变量
        check(root.left,sum-root.val);
        if(flag)return;
        check(root.right,sum-root.val);
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        check(root,targetSum);
        return flag;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        String[] arr = {"5","4","8","11","null","13","4","7","2","null","null","null","1"};
        TreeNode.Build(root,arr);
        PathSum.hasPathSum(root,22);
        System.out.println(PathSum.flag);
    }
}
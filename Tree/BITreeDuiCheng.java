
/*
    轴对称的二叉树判断
 */
public class BITreeDuiCheng {
    public boolean check(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 != null)return false;
        if(root2 == null && root1 != null)return false;
        if(root1 == null && root2 == null)return true;
        boolean out = check(root1.left,root2.right);
        boolean in = check(root1.right,root2.left);
        return out&in&root1.val == root2.val;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        if(root.right == null && root.left == null)return true;
        return check(root.left,root.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        String[] arr = {"1","2","2","3","4","4","3"};
//        String[] arr = {"1","2","2","null","3","null","3"};
        TreeNode.Build(root,arr);
        BITreeDuiCheng obj = new BITreeDuiCheng();
        boolean res = obj.isSymmetric(root);
        System.out.println(res);
    }
}

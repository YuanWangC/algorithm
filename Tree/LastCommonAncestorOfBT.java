public class LastCommonAncestorOfBT {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(root == p || root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null)return root;
        if(left==null && right==null)return null;
        return left==null?right:left;
    }
    public static void main(String[] args){
        String[] arr = {"5","10","4","7","8","3","6"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,arr);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        TreeNode res = LastCommonAncestorOfBT.lowestCommonAncestor(root,q,p);
        if(res!=null) System.out.println(res.val);
        else System.out.println(res);
    }
}
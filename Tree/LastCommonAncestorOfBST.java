package Tree;

import java.util.HashMap;

public class LastCommonAncestorOfBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer,Integer>map = new HashMap<>();
        if(root==null)return root;
        if(root==q ||root==p)return root;
//        统一节点的大小，使p节点小于q节点
        if(p.val>q.val)return lowestCommonAncestor(root,q,p);
//        所以，p节点要在左子树，q节点在右子树
        if(root.val<q.val && root.val>p.val)return root;
        if(root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val)
            return lowestCommonAncestor(root.right,p,q);
        return null;
    }
    public static void main(String[] args){
        String[] arr = {"6","2","8","0","4","7","9","null","null","3","5"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,arr);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right.left;
        TreeNode res = LastCommonAncestorOfBST.lowestCommonAncestor(root,q,p);
        if(res!=null) System.out.println(res.val);
        else System.out.println(res);
    }
}
package Tree;

public class ChangeBTSTreeIntoPlusTree {
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)return null;
        convertBST(root.right);
        if(pre!=null)
            root.val+=pre.val;
        pre = root;
        convertBST(root.left);
        return root;
    }
    public static void main(String[] args){
        String[] arr = {"0","-1","2","-3","null","null","4"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root ,arr);
        TreeNode root2 = new ChangeBTSTreeIntoPlusTree().convertBST(root);
        TreeNode.Intravel(root2);
    }
}
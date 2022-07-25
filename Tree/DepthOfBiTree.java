public class DepthOfBiTree {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.right == null && root.left == null)return 1;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        String[] arr = {"3","9","20","null","null","15","7"};
//        String[] arr = {"1","2","2","null","3","null","3"};
        TreeNode.Build(root,arr);
        DepthOfBiTree obj = new DepthOfBiTree();
        int res = obj.maxDepth(root);
        System.out.println(res);
    }
}

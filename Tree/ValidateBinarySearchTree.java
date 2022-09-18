package Tree;

public class ValidateBinarySearchTree {
//    用中序遍历是否逆序判断
    TreeNode pre = null;
    public boolean isValidBST1(TreeNode root) {
        if(root==null)return true;
        boolean l = isValidBST1(root.left);
        if(!l)return false;
        if(pre!=null && root.val<=pre.val)return false;
        // pre在下一次转移之前赋值为root
        pre = root;
        return isValidBST1(root.right);
    }
//    前序遍历判断左右节点，是否符合取值范围要求
    public boolean isValidBST2(TreeNode root) {
        return isValid(root,null,null);
    }
    public boolean isValid(TreeNode root,TreeNode max,TreeNode min){
        if(root == null)return true;
        if(max!=null && root.val>=max.val)
            return false;
        if(min!=null && root.val<=min.val)
            return false;
//        左节点最大不超过root，最小不小于min
//        右节点最小不小于root，最大不超过max
//        max和min不着急赋值，后续遍历时会被后续的“root”分别赋值
        return isValid(root.left,root,min)&&isValid(root.right,max,root);
    }
    public static void main(String[] args){
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        String[] arr = {"5","1","4","null","null","3","6"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,arr);
        System.out.println(obj.isValidBST1(root));

    }
}
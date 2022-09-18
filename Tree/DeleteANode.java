package Tree;

public class DeleteANode {
    public TreeNode getMin(TreeNode root){
        while(root.left!=null)root = root.left;
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val == key){
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            TreeNode min = getMin(root.right);
            root.right = deleteNode(root.right,min.val);
            min.left = root.left;
            min.right = root.right;
            root = min;
        }
        else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
    public static void main(String[] args){
        DeleteANode obj = new DeleteANode();
        TreeNode root = new TreeNode();
        String[] arr = {"5","3","6","2","4","null","7"};
        TreeNode.Build(root,arr);
        obj.deleteNode(root,2);
        TreeNode.Intravel(root);
    }
}
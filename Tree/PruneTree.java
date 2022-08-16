import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
    剪枝，剪去二叉树中所有节点为0的子树
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            root = null;
        }
        return root;

    }
    public static void main(String[] args){
        PruneTree obj = new PruneTree();
        String[] arr = {"1","0","1","1","1","0","1"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root ,arr);
        root = obj.pruneTree(root);
        TreeNode.Pretravel(root);
    }
}

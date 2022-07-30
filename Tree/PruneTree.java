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
        String[] arr = {"1","0","1","0","0","0","1"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root ,arr);
        root = obj.pruneTree(root);
//        TreeNode.Pretravel(root);
        ConcurrentHashMap<Integer,Integer> memo = new ConcurrentHashMap();
        memo.put(1,2);
        int old = memo.put(1,5);
        int old2 = memo.put(2,5);
        System.out.println(old);
        System.out.println(old2);
    }
}

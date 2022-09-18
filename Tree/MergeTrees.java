package Tree;

public class MergeTrees {
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)return null;
        if(root1!=null && root2!=null){
            root1.val +=root2.val;
            root1.left = mergeTrees1(root1.left,root2.left);
            root1.right = mergeTrees1(root1.right,root2.right);
        }
        else if(root1==null && root2!=null){
            return root2;
        }
        return root1;
    }
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if(root1!=null && root2!=null){
            root = new TreeNode(root1.val+root2.val);
            root.left = mergeTrees2(root1.left,root2.left);
            root.right = mergeTrees2(root1.right,root2.right);

        }
        else if(root1==null && root2!=null){
            root = new TreeNode(root2.val);
            root.left = root2.left;
            root.right = root2.right;
        }
        else if(root1!=null && root2==null){
            root = new TreeNode(root1.val);
            root.left = root1.left;
            root.right = root1.right;
        }
        return root;
    }
    public static void main(String[] args){
        MergeTrees obj = new MergeTrees();
        String[] s1 = {"1","3","2","5"};
        TreeNode root1 =new TreeNode();
        TreeNode.Build(root1,s1);
        String[] s2 = {"2","1","3","null","4","null","7"};
        TreeNode root2 = new TreeNode();
        TreeNode.Build(root2,s2);
//        TreeNode root3 = obj.mergeTrees1(root1,root2);
//        TreeNode.Pretravel(root3);
        TreeNode root4 = obj.mergeTrees2(root1,root2);
        TreeNode.Pretravel(root4);
    }
}

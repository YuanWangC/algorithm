package Tree;

/*
    镜像的二叉树输出
 */
public class BiTreeJingXiang {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)return null;
        TreeNode temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = temp;
        return root;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        int[] arr = {4,2,7,1,3,6,9};
        String[] arrs = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            arrs[i] = String.valueOf(arr[i]);
        }
        TreeNode.Build(root,arrs);
        BiTreeJingXiang obj = new BiTreeJingXiang();
        obj.mirrorTree(root);
        TreeNode.Pretravel(root);
//        TreeNode.Posttravel(root);
//        TreeNode.Intravel(root);
    }
}

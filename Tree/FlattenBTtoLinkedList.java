//将所有二叉树节点转换为链表节点，链表指针为right
public class FlattenBTtoLinkedList {
    public static void flatten1(TreeNode root) {
        if(root == null)return;
//        叶子结点不需要处理
        if(root.left == null && root.right==null)return;
        flatten1(root.left);
        flatten1(root.right);
//        左子树在展开后，已经为null，所以不用再继续展开
        if(root.left == null)return;
        TreeNode r = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode last = root.right;
//        找到最后一个节点
        while(last.right!=null){
            last = last.right;
        }
        last.right = r;
    }
    static TreeNode pre = null;
    public static void flatten2(TreeNode root) {
        if(root == null)return;
        if(root.left == null && root.right == null)return;
        traverse(root);
    }
    public static void traverse(TreeNode root){
        if(root == null)return;
        traverse(root.right);
        traverse(root.left);
//        后序遍历，pre节点是已经整理好的链表的表头
//        只需要把头结点加上去就好了
        root.right = pre;
//        左子节点已经整理完了，直接赋null即可
        root.left = null;
//        pre转到当前节点
        pre = root;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        String[] arr = {"1","2","5","3","4","null","6"};
        TreeNode.Build(root,arr);
//        FlattenBTtoLinkedList.flatten1(root);
//        TreeNode.Pretravel(root);

        FlattenBTtoLinkedList.flatten2(root);
        TreeNode.Pretravel(root);
    }
}
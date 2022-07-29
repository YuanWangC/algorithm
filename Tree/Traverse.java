import java.util.ArrayDeque;

public class Traverse {
    public static void preTraverse(TreeNode root){
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        if(root!=null){
            stk.push(root);
        }
        while (!stk.isEmpty()){
            TreeNode cur = stk.pop();
            System.out.println(cur.val);
            if(cur.right!=null){
                stk.push(cur.right);
            }
            if(cur.left!=null){
                stk.push(cur.left);
            }
        }
    }

    public static void inTraverse(TreeNode root){
        if(root==null)return;
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stk.isEmpty()){
            while (cur!=null){
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            System.out.println(cur.val);
            if(cur.right!=null){
                cur = cur.right;
            }
            else cur = null;
        }
    }

    public static void postTraverse(TreeNode root){
        if(root==null)return;
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stk.isEmpty()) {
            while (cur != null) {
                stk.push(cur);
                cur = cur.left;
            }
            if(!stk.isEmpty()){
                cur = stk.peek();
                if(cur.right == null || cur.right == pre){
                    System.out.println(cur.val);
                    pre = stk.pop();
                    cur = null;
                }
                else{
                    cur = cur.right;
                }
            }
        }
    }
    public static void main(String[] args){
//        String[] s = {"1","2","3","4","null","null","null"};
        //String[] s = {"1","2","3","4","5","6","7"};
        String[] s = {"2","null","3","null","4","null","5","null","6"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,s);
//        TreeNode.Pretravel(root);
//        Traverse.preTraverse(root);
//        Traverse.inTraverse(root);
//        TreeNode.Intravel(root);
        TreeNode.Posttravel(root);
        Traverse.postTraverse(root);
    }

}

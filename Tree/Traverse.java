import com.sun.source.tree.Tree;

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
   public static TreeNode postStack(TreeNode root,int val){
        if(root == null)return null;
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stk.isEmpty()){
            while(cur!=null){
                stk.push(cur);
                cur =cur.left;
            }
            if(!stk.isEmpty()){
                cur = stk.peek();
                if(cur.right == null || cur.right == pre){
                    if(cur.val == val)return pre;
//                    System.out.println(cur.val);
                    pre = stk.pop();
                    cur = null;

                }else{
                    cur = cur.right;
                }
            }
        }
        return null;
   }
    public static TreeNode inStack(TreeNode root,int val){
        if(root == null)return null;
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur!=null || !stk.isEmpty()){
            while(cur!=null){
                stk.push(cur);
                cur =cur.left;
            }
            cur = stk.pop();
//            System.out.println(cur);
            if(cur.val == val)return pre;
            pre = cur;
            if(cur.right !=null){
                cur = cur.right;
            }
            else {
                cur = null;
            }
        }
        return null;
    }
    static TreeNode pre = null;
    static TreeNode res = null;
    public void inStack2(TreeNode t, int val){
        if(t == null)return;
        inStack2(t.left,val);
//        System.out.println(t.val);
        if(t.val == val){
            this.res = this.pre;
            return;
        }
        this.pre = t;
        inStack2(t.right,val);
    }
    public void preStack2(TreeNode t, int val){
        if(t == null)return;
        if(t.val == val) {
            this.res = this.pre;
            return;
        }
        this.pre = t;
        preStack2(t.left,val);
        preStack2(t.right,val);
    }
    public void postStack2(TreeNode t,int val){
        if(t == null)return;
        postStack2(t.left,val);
        postStack2(t.right,val);
        if(t.val == val) {
            this.res = this.pre;
        }
        this.pre = t;
    }
    public static TreeNode preStack(TreeNode root,int val){
        if(root == null)return null;
        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        TreeNode cur = null;
        TreeNode pre = null;
        stk.push(root);
        while(!stk.isEmpty()){
            pre = cur;
            cur = stk.pop();
            if(cur.val == val)return pre;
            if(cur.right!=null){
                stk.push(cur.right);
            }
            if(cur.left!=null){
                stk.push(cur.left);
            }
        }
        return null;
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
        String[] s = {"1","2","3","4","5","6","7"};
//        String[] s = {"2","null","3","null","4","null","5","null","6"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,s);
//        TreeNode.Pretravel(root);
//        Traverse.preTraverse(root);
//        Traverse.inTraverse(root);
//        TreeNode.Intravel(root);
//        TreeNode.Posttravel(root);
        Traverse.postTraverse(root);
//        System.out.println(Traverse.postStack(root, 4).val);
//        System.out.println(Traverse.inStack(root, 4).val);
//        System.out.println(Traverse.preStack(root, 4).val);
//        new Traverse().inStack2(root,1);
//        new Traverse().preStack2(root,4);
        new Traverse().postStack2(root,1);
        System.out.println(Traverse.res.val);
    }

}

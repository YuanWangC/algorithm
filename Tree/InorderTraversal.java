package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null)return res;
        ArrayDeque<TreeNode> stk = new ArrayDeque();
        TreeNode cur = root;
        while(cur!=null || !stk.isEmpty()){
            while(cur!=null){
                stk.push(cur);
                cur = cur.left;
            }
            cur = stk.pop();
            res.add(cur.val);
//            有右向右
            if(cur.right!=null){
                cur = cur.right;
            }else{
//                无右出栈
                cur = null;
            }
        }
        return res;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode();
        String[] arr = {"1","null","2","3"};
        TreeNode.Build(root,arr);
        System.out.println(InorderTraversal.inorderTraversal(root));
    }
}
package Tree;

import java.util.HashMap;

public class HouseRobberiii {
    public int rob1(TreeNode root) {
        int[] res = Traverse(root);
        return Math.max(res[0],res[1]);
    }
    public int[] Traverse(TreeNode root){
        int[] res =  new int[2];
        if(root == null)return res;
        int[] left = Traverse(root.left);
        int[] right = Traverse(root.right);
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = left[0]+right[0]+root.val;
        return res;
    }
    HashMap<TreeNode,Integer> memo = new HashMap();
    public int rob2(TreeNode root) {
        if(root == null)return 0;
        if(memo.containsKey(root))return memo.get(root);
        int _do = root.val;
        if(root.left!=null){
            _do += rob2(root.left.left)+rob2(root.left.right);
        }
        if(root.right!=null){
            _do +=rob2(root.right.left)+rob2(root.right.right);
        }
        int not_do = rob2(root.left)+rob2(root.right);
        int res = _do>not_do?_do:not_do;
        memo.put(root,res);
        return res;
    }
    public static void main(String[] args){
        String[] arr = {"3","2","3","null","3","null","1"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,arr);
        System.out.println(new HouseRobberiii().rob1(root));
        System.out.println(new HouseRobberiii().rob2(root));
        System.out.println((int)(2.111*10)/10);
        System.out.println((int)(2.111*100)/100);
    }
}
package Basic;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    List<Integer> res = new ArrayList();

    public void dfs(TreeNode root,int value){
        if(root == null)return;
        int v = root.val+10*value;
        // System.out.println(v);
        if(root.left==null &&root.right==null){
            res.add(v);
            return;
        }
        dfs(root.left,v);
        dfs(root.right,v);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        dfs(root,0);
        int sum = 0;
        for(Integer i:res)
            sum+=i;
        return sum;
    }
    public static void main(String[] args){
        PathSum object= new PathSum();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        int res = object.sumNumbers(t);
        System.out.println(res);
    }
}

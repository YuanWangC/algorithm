package Basic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import Basic.TreeNode;

public class LowestCommonAncestor {
    ArrayList<List<Integer>> res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)return null;
        this.res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        DFSsearch(root,path,p.val);
        path = new LinkedList<Integer>();
        DFSsearch(root,path,q.val);
        System.out.println(res.get(0).size());
        System.out.println(res.get(1).size());
        int i = res.get(0).size()-1,j = res.get(1).size()-1,same = -1;
        int count = 0;
        while (i >= 0){
            //System.out.println(i);
            j = res.get(1).size()-1;
            while(j >= 0) {
                System.out.print(res.get(1).get(j));
                System.out.println(res.get(0).get(i));
                System.out.println(res.get(1).get(j).equals(res.get(0).get(i)));
            if(res.get(1).get(j) == res.get(0).get(i)){
                //System.out.print(res.get(1).get(j));
                //System.out.println(res.get(0).get(i));
                same = res.get(0).get(i);
                count++;
                break;
            }
            //System.out.println(same);
            j--;
        }
        i--;
        }
        System.out.println(count);
        return new TreeNode(same);
    }
    public void DFSsearch(TreeNode node,Deque<Integer> path,int val){
        if(node == null)return;
        path.addLast(node.val);
        //System.out.println(path);
        if(node.val == val){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        //System.out.println(path);
        DFSsearch(node.left,path,val);
        DFSsearch(node.right,path,val);
        //System.out.println(path);
        path.removeLast();
    }
}

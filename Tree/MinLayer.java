package Tree;

import java.util.ArrayDeque;

public class MinLayer {
    public int minDepth(TreeNode root) {
        ArrayDeque<TreeNode> que = new ArrayDeque();
        if(root == null)return 0;
        que.offer(root);
        int layer = 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                TreeNode cur = que.poll();
                if(cur.left == null && cur.right == null)return layer;
                if(cur.left!=null)
                    que.offer(cur.left);
                if(cur.right!=null)
                    que.offer(cur.right);
            }
            layer++;
        }
        return layer;
    }
    public static void main(String[] args){
//        String[] s = {"3","9","20","null","null","15","7"};
        String[] s = {"2","null","3","null","4","null","5","null","6"};
        MinLayer obj = new MinLayer();
        TreeNode root =new TreeNode();
        TreeNode.Build(root,s);
//        TreeNode.Pretravel(root);
        int res = obj.minDepth(root);
        System.out.println(res);
    }
}

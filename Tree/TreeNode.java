package Tree;

import java.util.ArrayDeque;

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.val = value;
        this.left = null;
        this.right = null;
    }
    TreeNode(){}
    public static TreeNode layerOrder(TreeNode root,String[] s){
        if(s.length==0 || s[0].equals("null"))return null;
        ArrayDeque<TreeNode> que= new ArrayDeque<>();
        root.val = Integer.parseInt(s[0]);
        que.offer(root);
        int index= 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int k=0;k<size;k++){
                TreeNode cur = que.poll();
                if(index<s.length && !s[index].equals("null")){
//                    System.out.println("node: "+s[index]);
                    cur.left = new TreeNode(Integer.parseInt(s[index]));
                    que.offer(cur.left);
                }
                index++;
                if(index<s.length && !s[index].equals("null")){
//                    System.out.println("node: "+s[index]);
                    cur.right = new TreeNode(Integer.parseInt(s[index]));
                    que.offer(cur.right);
                }
                index++;
            }
        }
        return root;
    }
    public static void Build(TreeNode root,String[] arr){
        if(arr.length == 0)return;
        root = layerOrder(root,arr);
    }
    public static void Pretravel(TreeNode t){
        if(t == null){
//            System.out.println("null");
            return;
        }
        System.out.println(t.val);
        Pretravel(t.left);
        Pretravel(t.right);
    }

    public static void Posttravel(TreeNode t){
        if(t == null)return;
        Posttravel(t.left);
        Posttravel(t.right);
        System.out.println(t.val);
    }
    public static void Intravel(TreeNode t){
        if(t == null)return;
        Intravel(t.left);
        System.out.println(t.val);
        Intravel(t.right);
    }
    public static void main(String[] args){
//        String[] s = {"1","2","3","4","null","null","null"};
        //String[] s = {"1","2","3","4","5","6","7"};
        String[] s = {"2","null","3","null","4","null","5","null","6"};
        TreeNode root = new TreeNode();
        TreeNode.Build(root,s);
        TreeNode.Pretravel(root);
    }

}
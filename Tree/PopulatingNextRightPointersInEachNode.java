package Tree;

import java.util.ArrayDeque;

class Node extends TreeNode{
    Node next;
    Node left;
    Node right;
    public Node(){
        super();
    }
    public Node(int value){
        super(value);
        this.left = null;
        this.right = null;
        this.next = null;
    }
    public static void travel2(Node root){
        System.out.println("run here");
        Node cur = root;
//        需要遍历到叶子结点，所以是cur!=null
        while(cur!=null){
            System.out.println(cur.val);
            Node temp = cur;
            while(temp!=null){
                System.out.println(temp.val);
                temp = temp.next;
            }
            cur = cur.left;
            System.out.println("run here");
            System.out.println(cur.val);
        }
    }
    public static Node layerOrder(String[] s){
        if(s.length==0 || s[0].equals("null"))return null;
        ArrayDeque<Node> que= new ArrayDeque<>();
        Node root = new Node(Integer.parseInt(s[0]));
        que.offer(root);
        int index= 1;
        while(!que.isEmpty()){
            int size = que.size();
            for(int k=0;k<size;k++){
                Node cur = que.poll();
                if(index<s.length && !s[index].equals("null")){
//                    System.out.println("node: "+s[index]);
                    cur.left = new Node(Integer.parseInt(s[index]));
                    que.offer(cur.left);
                }
                index++;
                if(index<s.length && !s[index].equals("null")){
//                    System.out.println("node: "+s[index]);
                    cur.right = new Node(Integer.parseInt(s[index]));
                    que.offer(cur.right);
                }
                index++;
            }
        }
        return root;
    }
    public static Node Build(String[] arr){
        if(arr.length == 0)return null;
        Node root = layerOrder(arr);
        return root;
    }
}
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root ==null)return root;
        Node cur = root;
        // 使用cur.left就不会走到最后一层，完美二叉树就不用再判断左右子节点是否存在了
        while(cur.left!=null){
            Node temp = cur;
            while(temp!=null){
                // if(temp.left!=null && temp.right!=null)
                temp.left.next = temp.right;
                if(temp.next!=null)
                    temp.right.next= temp.next.left;
                temp = temp.next;
            }
            cur = cur.left;
        }
        return root;
    }
    public static void main(String[] args){
        PopulatingNextRightPointersInEachNode obj = new PopulatingNextRightPointersInEachNode();
        String[] s = {"1","2","3","4","5","6","7"};

//        TreeNode r = new TreeNode();
//        TreeNode.Build(r,s);
//        System.out.println(r instanceof Node);   //false
//        父类实例不可以强制转换为子类，来调用子类方法
//        Node.travel((Node)r);   //ClassCastException

        Node root = new Node();
        TreeNode.Build(root,s);
//        Node.Build(s);    //子类调用自己的方法
//        System.out.println(root instanceof TreeNode);   //true
//        子类实例自动转换为父类，可以作为父类方法的形参
//        if(root instanceof TreeNode)
//            TreeNode.Pretravel(root);

        //子类自己的方法
        Node root2 = obj.connect(root);
        Node.travel2(root2);
        System.out.println("run here");
    }
}

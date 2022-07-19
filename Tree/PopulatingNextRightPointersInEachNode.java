import java.util.ArrayDeque;

class Node extends TreeNode{
    Node next;
    public Node(){
        super();
    }
    public Node(int value){
        super(value);
        this.next = null;
    }
    public static void travel(Node root){
        Node cur = root;
//        需要遍历到叶子结点，所以是cur!=null
        while(cur!=null){
            // System.out.println(cur.val);
            Node temp = cur;
            while(temp!=null){
                System.out.println(temp.val);
                temp = temp.next;
            }
            cur = (Node) cur.left;
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
                    que.offer((Node) cur.left);
                }
                index++;
                if(index<s.length && !s[index].equals("null")){
//                    System.out.println("node: "+s[index]);
                    cur.right = new Node(Integer.parseInt(s[index]));
                    que.offer((Node) cur.right);
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
                ((Node)temp.left).next = (Node) temp.right;
                if(temp.next!=null)
                    ((Node)temp.right).next= (Node) temp.next.left;
                temp = temp.next;
            }
            cur = (Node)cur.left;
        }
        return root;
    }
    public static void main(String[] args){
        PopulatingNextRightPointersInEachNode obj = new PopulatingNextRightPointersInEachNode();
        String[] s = {"1","2","3","4","5","6","7"};
        Node root = Node.Build(s);
//        子类实例自动转换为父类，作为父类方法的形参
//        TreeNode.Pretravel(root);
//        System.out.println(root instanceof TreeNode);   //true
        Node root2 = obj.connect(root);
        Node.travel(root2);
    }
}

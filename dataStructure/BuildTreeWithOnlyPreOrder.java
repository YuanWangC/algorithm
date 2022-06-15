package dataStructure;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int value){
		this.val = value;
		this.left = null;
		this.right = null;
	}
	TreeNode(){
	}
	public void TraversepreOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val);
		System.out.print(" ");
		TraversepreOrder(root.left);
		TraversepreOrder(root.right);
	}
}
public class BuildTreeWithOnlyPreOrder {
    String Sep = ",";
    String Null= "#";
    StringBuilder serializeTree = new StringBuilder();
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            serializeTree.append(Null).append(Sep);
            return serializeTree.toString();
        }
        serializeTree.append(root.val).append(Sep);
        serialize(root.left);
        serialize(root.right);
        return serializeTree.toString();
    }
    public TreeNode buildTree(TreeNode root,String[] s){
        if(index>=s.length) return root;
        if(s[index].equals(Null)) return null;
        root = new TreeNode(Integer.parseInt(s[index++]));
        root.left = buildTree(root.left,s);
        index++;
        root.right = buildTree(root.right,s);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(Sep);
        TreeNode dummyroot = new TreeNode(-1);
        TreeNode root = buildTree(dummyroot,s);
        return root;
    }
    public static void main(String[] args) {
    	BuildTreeWithOnlyPreOrder b = new BuildTreeWithOnlyPreOrder();
    	TreeNode root = new TreeNode(0);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(2);
    	root.left.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);
    	String data = b.serialize(root);
    	System.out.println(data);
    	TreeNode deRoot = b.deserialize(data);
    	deRoot.TraversepreOrder(deRoot);
    }
}

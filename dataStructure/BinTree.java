package dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode2{
	int data;
	TreeNode2 left;
	TreeNode2 right;
	TreeNode2(int value){
		this.data = value;
		this.left = null;
		this.right = null;
	}
	TreeNode2(){
	}
}
public class BinTree {
	public TreeNode2 BuildTree() {
		TreeNode2 head = new TreeNode2(1);
		head.left = new TreeNode2(2);
		head.right = new TreeNode2(3);
		head.left.left = new TreeNode2(4);
		head.right.left = new TreeNode2(5);
		head.right.right = new TreeNode2(6);
		head.left.left.right = new TreeNode2(7);
		return head;
	}
	
	public void TraversepreOrder(TreeNode2 root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data);
		System.out.print(" ");
		TraversepreOrder(root.left);
		TraversepreOrder(root.right);
	}
	public void TraverseInorder(TreeNode2 root) {
		if(root == null) {
			return;
		}
		TraverseInorder(root.left);
		System.out.print(root.data);
		System.out.print(" ");
		TraverseInorder(root.right);
	}
	public void TraversePostorder(TreeNode2 root) {
		if(root == null) {
			return;
		}
		TraversePostorder(root.left);	
		TraversePostorder(root.right);
		System.out.print(root.data);
		System.out.print(" ");
	}
	public void TraverseLayer(TreeNode2 root,int layer) {
		if(root == null) {
			return;
		}
		Queue<TreeNode2> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				TreeNode2 cur = q.poll();
				System.out.print(cur.data);
				System.out.print(" ");
				if(cur.left!=null)
					q.offer(cur.left);
				if(cur.right!=null)
					q.offer(cur.right);
			}
		}
	}
	public int BiTreeWidth(TreeNode2 root) {
		if(root == null) {
			return 0;
		}
		Queue<TreeNode2> q = new LinkedList<>();
		q.offer(root);
		HashMap<TreeNode2, Integer> h = new HashMap<>();
		h.put(root, 1);
		int max = Integer.MIN_VALUE;
		int CurNodesLayer = 0;
		int CountCurLayer = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				//System.out.println("before:"+CountCurLayer);
				
				TreeNode2 cur = q.poll();
				int curNodeLayer = h.get(cur);
				//System.out.println("node:"+cur.data+" "+curNodeLayer);
				//System.out.println(curNodeLayer+" equal "+CurNodesLayer);
				if(curNodeLayer == CurNodesLayer) {
					CountCurLayer+=1;
				}
				else {
					if(max<CountCurLayer) {
						//System.out.println("max:"+max);
						max=CountCurLayer;
					}
					CountCurLayer = 1;
					CurNodesLayer += 1;
					
				}
				//System.out.println("after:"+CountCurLayer);
				if(cur.left!=null) {
					q.offer(cur.left);
					h.put(cur.left, CurNodesLayer+1);
				}
				if(cur.right!=null) {
					
					q.offer(cur.right);
					h.put(cur.right, CurNodesLayer+1);
				}
			}
		}
		return max;
	}
	public static void printTree(TreeNode2 head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode2 head, int height, String to, int len) {
		if (head == null) {
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.data + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	public static void main(String[] args) {
		int[] preOrder = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
		//int[] preOrder = {3,9,20,15,7,4,5,6};
		BinTree biTree = new BinTree();
		TreeNode2 root = biTree.BuildTree();
		biTree.printTree(root);
		biTree.TraversepreOrder(root);
		System.out.print("\n");
		biTree.TraverseInorder(root);
		System.out.print("\n");
		biTree.TraversePostorder(root);
		System.out.print("\n");
		biTree.TraverseLayer(root, 0);
		System.out.print("\n");
		int width = biTree.BiTreeWidth(root);
		System.out.print(width);
	}
}

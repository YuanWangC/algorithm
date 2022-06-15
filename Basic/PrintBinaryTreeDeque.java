package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


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
}

public class PrintBinaryTreeDeque {
	public TreeNode BuildTree() {
		TreeNode head = new TreeNode(3);
		head.left = new TreeNode(9);
		head.right = new TreeNode(20);
		head.right.left = new TreeNode(15);
		head.right.right = new TreeNode(7);
		head.right.left.left = new TreeNode(6);
		head.right.left.right = new TreeNode(88);
		head.right.right.left = new TreeNode(44);
		head.right.right.right = new TreeNode(21);
		
		return head;
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)return new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp;
		Deque<TreeNode> dq = new LinkedList<>();
		dq.addLast(root);
		//每次处理两层
		while(!dq.isEmpty()) {
			//奇数层
			int size = dq.size();
			temp = new ArrayList<>();
			//处理当前所有队列中的节点（数目为奇数层节点数）
			for(int i = 0;i<size;i++) {
				//从头部读出
				TreeNode cur = dq.removeFirst();
				temp.add(cur.val);
				//从尾部添加
				if(cur.left!=null)
					dq.addLast(cur.left);
				if(cur.right!=null)
					dq.addLast(cur.right);
			}
			res.add(temp);
			//没有偶数层break
			if(dq.isEmpty())break;
			//处理偶数层
			temp = new LinkedList<>();
			size = dq.size();
			//处理当前所有队列中的节点（数目为偶数层节点数）
			for(int i = 0;i<size;i++) {
				//从尾部读出
				TreeNode cur = dq.removeLast();
				temp.add(cur.val);
				//从头部添加
				//注意这一层整体是从右向左添加（这样读出才是从左向右的）
				if(cur.right!=null)
					dq.addFirst(cur.right);
				if(cur.left!=null)
					dq.addFirst(cur.left);
			}
			res.add(temp);
			for(int i=0;i<res.size();i++) {
				System.out.println(res.get(i));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		PrintBinaryTreeDeque p = new PrintBinaryTreeDeque();
		TreeNode root = p.BuildTree();
		List<List<Integer>> res = p.levelOrder(root);
		System.out.println(res);
	}
}

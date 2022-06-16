package Basic;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import Basic.TreeNode;



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
		//ÿ�δ�������
		while(!dq.isEmpty()) {
			//������
			int size = dq.size();
			temp = new ArrayList<>();
			//����ǰ���ж����еĽڵ㣨��ĿΪ������ڵ�����
			for(int i = 0;i<size;i++) {
				//��ͷ������
				TreeNode cur = dq.removeFirst();
				temp.add(cur.val);
				//��β�����
				if(cur.left!=null)
					dq.addLast(cur.left);
				if(cur.right!=null)
					dq.addLast(cur.right);
			}
			res.add(temp);
			//û��ż����break
			if(dq.isEmpty())break;
			//����ż����
			temp = new LinkedList<>();
			size = dq.size();
			//����ǰ���ж����еĽڵ㣨��ĿΪż����ڵ�����
			for(int i = 0;i<size;i++) {
				//��β������
				TreeNode cur = dq.removeLast();
				temp.add(cur.val);
				//��ͷ�����
				//ע����һ�������Ǵ���������ӣ������������Ǵ������ҵģ�
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

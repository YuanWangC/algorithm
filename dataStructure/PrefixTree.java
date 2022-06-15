package dataStructure;

class PrefixNode{
	public int pass;
	public int end;
	public PrefixNode[] childs;
	public PrefixNode(int p,int e) {
		this.pass = p;
		this.end = e;
		childs = new PrefixNode[26];
	}
}

public class PrefixTree {
	public PrefixNode root = new PrefixNode(0,0);
	
	public void build(String[] s) {
		for(String subs:s) {
			char[] sc = subs.toCharArray();
			PrefixNode cur = root;
			cur.pass++;
			for(char c:sc) {
				int index = c-'a';
				if(cur.childs[index] == null)
					cur.childs[index] = new PrefixNode(1,0);
				else cur.childs[index].pass++;
				cur = cur.childs[index];
			}
			cur.end++;
		}
	}
	public void Traverse(PrefixNode n) {
		if(n==null)return;
		System.out.println(n.pass+" "+n.end);
		for(int i=0;i<26;i++){
			if(n.childs[i]!=null) {
				System.out.println((char)(i+'a'));
				Traverse(n.childs[i]);
			}
		}
	}
	
	public void insert(String s) {
		char[] sc = s.toCharArray();
		PrefixNode cur = root;
		cur.pass++;
		for(char c:sc) {
			int index = c-'a';
			if(cur.childs[index] == null)
				cur.childs[index] = new PrefixNode(1,0);
			else cur.childs[index].pass++;
			cur = cur.childs[index];
		}
		cur.end++;
	}
	public boolean remove(String s) {
		if(!this.search(s))return false;
		char[] sc = s.toCharArray();
		PrefixNode cur = root;
		for(char c:sc) {
			int index = c-'a';
			cur.childs[index].pass--;
			if(cur.childs[index].pass == 0) {
				cur.childs[index] = null;
				return true;
			}
			cur = cur.childs[index];
		}
		cur.end--;
		return true;
	}
	public boolean search(String s) {
		char[] sc = s.toCharArray();
		PrefixNode cur = root;
		for(char c:sc) {
			int index = c-'a';
			if(cur.childs[index] == null)return false;
			cur = cur.childs[index];
		}
		if(cur.end == 0)return false;
		return true;
	}
	
	public int prefixCount(String s) {
		char[] sc = s.toCharArray();
		PrefixNode cur = root;
		for(char c:sc) {
			int index = c-'a';
			if(cur.childs[index] == null)return 0;
			cur = cur.childs[index];
		}
		return cur.pass;
	}
	public int StringCount(String s) {
		char[] sc = s.toCharArray();
		PrefixNode cur = root;
		for(char c:sc) {
			int index = c-'a';
			if(cur.childs[index] == null)return 0;
			cur = cur.childs[index];
		}
		return cur.end;
	}
	public static void main(String[] args) {
		PrefixTree p =new PrefixTree();
		String[] s = {"abc","bc","bcd","acd","be"};
		p.build(s);
//		System.out.println("start:");
//		p.Traverse(p.root);
		p.insert("ade");
		System.out.println("start:");
		p.Traverse(p.root);
		boolean res = false;
//		boolean res = p.search("ade");
//		System.out.println(res);
//		System.out.println("start:");
//		p.Traverse(p.root);
		res = p.remove("ade");
		System.out.println(res);
		System.out.println("start:");
		p.Traverse(p.root);
		int count = p.prefixCount("b");
		System.out.println(count);
		int count2 = p.StringCount("bcs");
		System.out.println(count2);
	}
}

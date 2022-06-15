package algorithm;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import dataStructure.*;
public class UnionFind {
	public int count;
	public List<Set<Node>> nodeSet;
	public HashMap<Node,Node> leader; //<child,parent>
	public HashMap<Node,Integer> size;//��¼ÿ�������Ľڵ�����������unionʱͷ�ؽ���
	public void makeSets(Collection<Node> nodes) {
		this.count = nodes.size();
		this.nodeSet = new LinkedList<>();
		for(Node n:nodes) {
			HashSet<Node> ns = new HashSet();
			ns.add(n);
			this.nodeSet.add(ns);
		}
	}	
	public boolean isSameSet(Node from ,Node to) {
		Set fromSet = null,toSet = null;
		for(Set ns:this.nodeSet) {
			if(ns.contains(from))fromSet = ns;
			if(ns.contains(to))toSet = ns;
		}
		if(fromSet == toSet) return true;
		return false;
	}	
	public void union(Node from ,Node to) {
		Set fromSet = null,toSet = null;
		for(Set ns:this.nodeSet) {
			if(ns.contains(from))fromSet = ns;
			if(ns.contains(to))toSet = ns;
		}
		if(fromSet != toSet) {
			this.nodeSet.remove(fromSet);
			this.nodeSet.remove(toSet);
			fromSet.addAll(toSet);
			this.nodeSet.add(fromSet);
		}
	}
	public void makeSets2(Collection<Node> nodes) {
		this.count = nodes.size();
		this.leader = new HashMap(nodes.size());
		this.size = new HashMap(nodes.size());
		for(Node n:nodes) {
			leader.put(n, n);
			this.size.put(n, 1);
		}
	}
	public boolean isSameSet2(Node from ,Node to) {
		Node fromleader = this.find(from);
		Node toleader = this.find(to);
		if(fromleader == toleader) return true;
		return false;
	}
	public Node find(Node n) {
		Node res = null;
		if(this.leader.get(n) == n)return n;
		return find(this.leader.get(n));
	}
	//·��ѹ���ķ�ʽ���Ҹ��ڵ�
	public Node findWithCompression(Node n) {
		if(this.leader.get(n) == n)return n;
		leader.put(n, this.leader.get(this.leader.get(n)));
		return find(this.leader.get(n));
	}
	public void union2(Node from ,Node to) {
//		Node fromleader = this.find(from);
		Node fromleader = this.findWithCompression(from);
		int fromSize = this.size.get(fromleader);
//		Node toleader = this.find(to);
		Node toleader = this.findWithCompression(to);
		int toSize = this.size.get(toleader);
		//˭С˭��child�����������ڲ�ƽ��
		if(toSize>fromSize)
			this.leader.put(fromleader, toleader);
		else
			this.leader.put(toleader, fromleader);
		this.count--;
	}
}

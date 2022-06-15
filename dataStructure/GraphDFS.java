package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import dataStructure.AdjacencyList;

public class GraphDFS {
	Deque<Node> stk;
	boolean[] flag;
	public void dfs(AdjacencyList graph) {
		flag = new boolean[graph.nodes.size()+1];
		stk = new LinkedList<>();
		for(Entry m: graph.nodes.entrySet()){
			if(flag[(int) m.getKey()])continue;
			stk.addLast((Node)m.getValue());
			flag[(int) m.getKey()] =true;
			while(!stk.isEmpty()) {
//				System.out.print("stk:");
//				for(Node n:stk) {
//					System.out.print(n.value);
//				}
//				System.out.println();
				Node cur = stk.removeLast();
				System.out.println(cur.value);
				for(Node n:cur.nexts) {
					//stk.add(cur);
					if(flag[n.value])continue;
					stk.addLast(n);
					System.out.println("nexts:");
					System.out.print(n.value);
					flag[n.value] =true;
					break;
				}
				System.out.println();
			}
		}
		
	}
	//使用栈来避免重复遍历（去掉了遍历节点的循环）
	//从一个点遍历的连通图
	//输出不是普通的出栈顺序，而是入栈顺序
	//出栈用于判断是否将相邻节点遍历完毕
	public void dfs2(Node n) {
		HashSet<Node> nodes = new HashSet();
		Deque<Node> stk = new LinkedList<>();
		stk.addLast(n);
		nodes.add(n);
		System.out.println(n.value);
		while(!stk.isEmpty()) {
			Node cur = stk.removeLast();
			for(Node n2:cur.nexts) {
				if(nodes.contains(n2))continue;
				stk.addLast(cur);
				stk.addLast(n2);
				nodes.add(n2);
				System.out.println(n2.value);
				break;
			}
		}
	}
	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList();
		int[][] arr = {{1,2,4},{3,2,5},{4,1,3},{6,1,2},{9,4,5},{7,3,5},{7,3,4},{7,1,5},
				{1,4,2},{3,5,2},{4,3,1},{6,2,1},{9,5,4},{7,5,3},{7,4,3},{7,5,1}};
		AdjacencyList graph2 = graph.buildgraph2(graph,arr);
		graph.check(graph2);
		GraphDFS d = new GraphDFS();
//		
		d.dfs(graph2);
		d.dfs2(graph2.nodes.get(1));
	}
}


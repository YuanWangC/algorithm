package dataStructure;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class GraphBFS {
	Queue<Node> que;
	boolean[] flag;
	public void bfs(AdjacencyList graph) {
		que = new LinkedList<>();
		flag = new boolean[graph.nodes.size()+1];
		for(Entry n:graph.nodes.entrySet()) {
			if(flag[(int)n.getKey()])continue;
			que.offer((Node)n.getValue());
			flag[(int)n.getKey()]=true;
			while(!que.isEmpty()) {
				System.out.print("que:");
				for(Node n2:que) {
					System.out.print(n2.value);
				}
				System.out.println();
				Node cur = que.poll();
				System.out.println(cur.value);
				for(Node node:cur.nexts) {
					if(flag[node.value])continue;
					que.offer(node);
					flag[node.value]=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList();
		int[][] arr = {{1,2,4},{3,2,5},{4,1,3},{6,1,2},{9,4,5},{7,3,5},{7,3,4},{7,1,5},
				{1,4,2},{3,5,2},{4,3,1},{6,2,1},{9,5,4},{7,5,3},{7,4,3},{7,5,1}};
		AdjacencyList graph2 = graph.buildgraph2(graph,arr);
		graph.check(graph2);
		GraphBFS b = new GraphBFS();
		b.bfs(graph2);
	}
}

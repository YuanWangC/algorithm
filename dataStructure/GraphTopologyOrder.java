package dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class GraphTopologyOrder {
	//修改原graph
	public void tpSort(AdjacencyList graph) {
		while(!graph.nodes.isEmpty()) {
		for(Entry e:graph.nodes.entrySet()) {
			Node cur = (Node)e.getValue();
			if(cur.in == 0) {
				for(Node n2:cur.nexts) {
					n2.in--;
				}
				cur.edges = null;
				cur.out = 0;
				cur.nexts = null;
				graph.nodes.remove(cur.value);
				System.out.println(cur.value);
				break;
			}			
		}
		}
	}
	//不修改原graph，用HashMap组织节点和剩余入度数量
	//用队列组织入度为0的节点，出队列时，修改它们出度对应的节点的入度
	public void tpSort2(AdjacencyList graph) {
		HashMap<Node,Integer> inmap= new HashMap();
		Queue<Node> zeroInNode = new LinkedList<>();
		
		for(Node n:graph.nodes.values()) {
			inmap.put(n, n.in);
			if(n.in ==0)zeroInNode.add(n);
		}
		
		while(!zeroInNode.isEmpty()) {
			Node cur = zeroInNode.poll();
			System.out.println(cur.value);
			for(Node n:cur.nexts) {
				int in = inmap.get(n);
				in--;
				if(in == 0) {
					zeroInNode.add(n);
				}
				inmap.put(n,in);
			}
		}
	}
	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList();
		int[][] arr = {{1,2,4},{3,2,5},{4,3,1},{6,1,2},{9,4,5},{7,3,5},{7,3,4},{7,1,5}};
		AdjacencyList graph2 = graph.buildgraph2(graph,arr);
		graph.check(graph2);
		GraphTopologyOrder tp = new GraphTopologyOrder();
		tp.tpSort2(graph2);
		tp.tpSort(graph2);
	}
}

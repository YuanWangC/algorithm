package algorithm;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import dataStructure.AdjacencyList;
import dataStructure.GraphDFS;
import dataStructure.Edge;
import dataStructure.Node;

class EdgeComparator implements Comparator<Edge>{
	@Override
	public int compare(Edge e1,Edge e2) {
		return e1.weight-e2.weight;
	}
}
public class Prim {
	public void prim(AdjacencyList graph) {
		PriorityQueue<Edge> edges = new PriorityQueue<>(new EdgeComparator());
		HashSet<Node> nodes = new HashSet();
		ArrayList<Edge> res = new ArrayList();
//		for(Node n:graph.nodes.values())
		for(Entry n:graph.nodes.entrySet()) {
			Node cur = (Node) n.getValue();
			if(nodes.contains(cur))continue;
			nodes.add(cur);
			for(Edge e:cur.edges) {
				if(edges.contains(e))continue;
				edges.add(e);
			}
			System.out.println("pq:");
			for(Edge e1:edges)
				System.out.println(e1.weight);
			while(!edges.isEmpty()) {
				Edge min = edges.poll();
				if(res.contains(min))continue;
				if(nodes.contains(min.to))continue;
				res.add(min);
				nodes.add(min.to);
				for(Edge e:min.to.edges)edges.add(e);
			}
		}
		System.out.println("res:");
		for(Edge e:res)System.out.println(e.weight+" "+e.from.value+" "+e.to.value);
	
	}
	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList();
		int[][] arr = {{1,2,4},{3,2,5},{4,1,3},{6,1,2},{9,4,5},{7,3,5},{7,3,4},{7,1,5},
				{1,4,2},{3,5,2},{4,3,1},{6,2,1},{9,5,4},{7,5,3},{7,4,3},{7,5,1}};
		AdjacencyList graph2 = graph.buildgraph2(graph,arr);
		graph.check(graph2);
		Prim p = new Prim();
		p.prim(graph2);
	}
}

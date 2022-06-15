package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import dataStructure.AdjacencyList;
import dataStructure.Edge;
import dataStructure.GraphDFS;
import dataStructure.Node;
import algorithm.UnionFind;

class KruComparator implements Comparator<Edge>{
	@Override
	public int compare(Edge e1,Edge e2) {
		return e1.weight-e2.weight;
	}
}

public class Kruskal {
	
	public void kruskal(AdjacencyList graph) {
		PriorityQueue<Edge> pq = new PriorityQueue(new KruComparator());
		HashMap<Node,Set> sets = new HashMap();
		for(Node n:graph.nodes.values()) {
			Set s = new HashSet();
			s.add(n);
			sets.put(n,s);
		}
		ArrayList<Edge> res = new ArrayList();
		for(Edge e:graph.edges)
			pq.add(e);
//		Iterator it = graph.edges.iterator();
//		while(it.hasNext()) {
//			pq.add((Edge) it.next());
//		}
		for(Edge e:pq)
			System.out.println(e.weight);
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			Node fromNode = cur.from;
			Node toNode = cur.to;
			if(sets.get(fromNode).equals(sets.get(toNode))) continue;
			else {
				res.add(cur);
				Set s = sets.get(fromNode);
				s.addAll(sets.get(toNode));
				sets.put(toNode,s);
				sets.put(fromNode,s);
				if(s.size() == graph.nodes.size())break;
			}
			
		}
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i).weight);
			System.out.print(res.get(i).from.value);
			System.out.println(res.get(i).to.value);
		}
	}
	//²¢²é¼¯
	public void kruskal2(AdjacencyList graph) {
		UnionFind u = new UnionFind();
//		u.makeSets(graph.nodes.values());
		u.makeSets2(graph.nodes.values());
		PriorityQueue<Edge> pq = new PriorityQueue<>(new KruComparator());
		for(Edge e:graph.edges) {
			pq.add(e);
		}
		
		Set<Edge> res =  new HashSet();
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			Node from  = cur.from;
			Node to = cur.to;
//			if(!u.isSameSet(from,to)) {
			if(!u.isSameSet2(from,to)) {
				res.add(cur);
//				u.union(from,to);
				u.union2(from,to);
			}
		}
		for(Edge e:res){
			System.out.println(e.weight+" "+e.from.value+" "+e.to.value);
		}
	}
	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList();
		int[][] arr = {{1,2,4},{3,2,5},{4,1,3},{6,1,2},{9,4,5},{7,3,5},{7,3,4},{7,1,5},
				{1,4,2},{3,5,2},{4,3,1},{6,2,1},{9,5,4},{7,5,3},{7,4,3},{7,5,1}};
		AdjacencyList graph2 = graph.buildgraph2(graph,arr);
		graph.check(graph2);
		Kruskal k = new Kruskal();
		k.kruskal(graph2);
		k.kruskal2(graph2);
	}
}

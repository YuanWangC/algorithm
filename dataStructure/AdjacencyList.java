package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import dataStructure.Node;
import dataStructure.Edge;

public class AdjacencyList {
	public HashMap<Integer,Node> nodes;
	public HashSet<Edge> edges;
	public AdjacencyList() {
		this.nodes = new HashMap();
		this.edges = new HashSet();
	}
	public AdjacencyList buildgraph(AdjacencyList graph, int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == i)continue;
			Node parent = null;
			if(graph.nodes.containsKey(arr[i])) {
				parent = graph.nodes.get(arr[i]);
			}
			else {
			parent = new Node(arr[i]);
			}
			Node next =new Node(i);		
			parent.nexts.add(next);
			parent.in++;
			next.out++;
			next.nexts.add(parent);
			next.in++;
			parent.out++;
			graph.nodes.put(i, next);
			graph.nodes.put(arr[i], parent);
			Edge e = new Edge(Math.abs(arr[i]-i),parent,next);
			parent.edges.add(e);
			Edge e2 = new Edge(e.weight,next,parent);
			next.edges.add(e2);
			graph.edges.add(e);
			graph.edges.add(e2);
		}
		return graph;
	}
	public AdjacencyList buildgraph2(AdjacencyList graph, int[][] graph2) {
		int index=0;
		for(int i=0;i<graph2.length;i++) {
			Node from =null,to=null;
			if(graph.nodes.containsKey(graph2[i][1])) {
				from = graph.nodes.get(graph2[i][1]);
			}
			else{
				from = new Node(graph2[i][1]);
			}
			if(graph.nodes.containsKey(graph2[i][2])) {
				to = graph.nodes.get(graph2[i][2]);
			}
			else {
				to = new Node(graph2[i][2]);
			}	
			from.nexts.add(to);
//			System.out.println("from size: "+from.nexts.size());
			from.out++;
			to.in++;
			Edge e = new Edge(graph2[i][0],from,to);
			graph.edges.add(e);
			from.edges.add(e);
			graph.nodes.put(graph2[i][1],from);
			graph.nodes.put(graph2[i][2],to);
		}
		return graph;
	}
	
	public void check(AdjacencyList graph) {
		for(Integer k:graph.nodes.keySet()) {
			Node cur = graph.nodes.get(k);
			System.out.println(cur.value);
			System.out.println(cur.in+" "+cur.out);
			System.out.println("next size: "+cur.nexts.size());
			Iterator it = cur.nexts.iterator();
			while (it.hasNext()) {
				Node n = (Node) it.next();
				System.out.print(n.value+" ");
			}
			/*for(Node n:cur.nexts) {
			System.out.println(' '+n.value);
			}*/
			System.out.println();
		}
		for(Edge e:graph.edges) {
			System.out.println(e.weight+" "+e.from.value+" "+e.to.value);
		}
	}
	
	public static void main(String[] args) {
		
		//编号arr[i]是编号为i的相邻节点
		int[] graph0 = {5,2,2,4,2,1};
		AdjacencyList graph = new AdjacencyList();
		AdjacencyList graph1 = graph.buildgraph(new AdjacencyList(),graph0);
		graph.check(graph1);
		//[weight,from,to]数组
		int[][] graph2 = new int[6][3];
		for(int i=0;i<graph2.length;i++) {
			graph2[i][0] = i+1;
			graph2[i][1] = i;
			graph2[i][2] = (i+2)%graph2.length;
			System.out.print(Arrays.toString(graph2[i]));
			System.out.println();
		}
		AdjacencyList graph3 = graph.buildgraph2(new AdjacencyList(), graph2);
		graph.check(graph3);
		
	}
	
}

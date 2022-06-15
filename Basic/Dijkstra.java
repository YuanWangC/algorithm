package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import dataStructure.AdjacencyList;
import dataStructure.Edge;
import dataStructure.GraphDFS;
import dataStructure.Node;

class Distance{
	public Node n;
	public int distance;
	public Distance(Node n,int d){
		this.n = n;
		this.distance = d;
	}
}
class DistComparator implements Comparator<Distance>{
	@Override
	public int compare(Distance d1,Distance d2) {
		return d1.distance-d2.distance;
	}
}
public class Dijkstra {
	private void dijkstra(AdjacencyList graph,Node start) {
		//init
		PriorityQueue<Distance> pq = new PriorityQueue(new DistComparator()); 
		ArrayList<Distance> res = new ArrayList<>();
		for(Entry n:graph.nodes.entrySet()) {
			if(n.getValue() == start)pq.add(new Distance((Node)n.getValue(),0));
			else pq.add(new Distance((Node) n.getValue(), Integer.MAX_VALUE));
		}
		System.out.println(pq.size());
		for(Distance d2:pq)
			System.out.println(d2.n.value+" "+d2.distance);
		System.out.println();
		
		while(!pq.isEmpty()) {
			Distance cur = pq.poll();
			res.add(cur);
			for(Edge e:cur.n.edges) {
				int weight = e.weight;
				Node toNode = e.to;
				//no need to search min distance Node 
				//but hard to update the distance of toNode
				for(Distance d:pq) {
					if(d.n == toNode) {
						pq.remove(d);
						d.distance = Math.min(d.distance,cur.distance+weight);
						pq.add(d);
						break;
					}
				}
			}
			for(Distance d2:pq)
				System.out.println(d2.n.value+" "+d2.distance);
			System.out.println();
		}
		for(Distance d:res)
			System.out.println(d.n.value+" "+d.distance);
		return;
	}
	public void dijkstra2(AdjacencyList graph,Node start) {
		//init
		HashMap<Node,Integer> distance = new HashMap();
		HashSet<Node> selectNodes = new HashSet();
		ArrayList<Node> res = new ArrayList<>();
		selectNodes.add(start);
		res.add(start);
		for(Entry n:graph.nodes.entrySet()) {
			if(n.getValue() == start)distance.put((Node)n.getValue(), 0);
			else distance.put((Node)n.getValue(), Integer.MAX_VALUE);
		}
		
		for(Edge e:start.edges) {
			distance.put(e.to,e.weight);
		}
//		for(Node n:distance.keySet())
//			System.out.println(n.value+" "+distance.get(n));
//		System.out.println();
		Node minNode = start;
		while(minNode!= null) {
			//need to search min distance Node 
			int mindis = Integer.MAX_VALUE;
			minNode = null;
			for(Entry d:distance.entrySet()) {
				if(!selectNodes.contains(d.getKey())) {
					if(distance.get(d.getKey()) < mindis) {
						mindis = distance.get(d.getKey());
						minNode = (Node)d.getKey();
					}
				}
			}
			if(minNode == null)break;
			selectNodes.add(minNode);
			res.add(minNode);
			//update the distance of related Node
			int dis = distance.get(minNode);
			for(Edge e:minNode.edges) {
				if(distance.get(e.to) == Integer.MAX_VALUE)
					distance.put(e.to, dis+e.weight);
				distance.put(e.to, Math.min(dis+e.weight, distance.get(e.to)));
			}
			for(Node n:distance.keySet())
				System.out.println(n.value+" "+distance.get(n));
			System.out.println();
		}	
		for(Node n:res)
			System.out.println(n.value);
	}
	
	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList();
		int[][] arr = {{1,2,4},{3,2,5},{4,1,3},{6,1,2},{9,4,5},{7,3,5},{7,3,4},{7,1,5}};
		AdjacencyList graph2 = graph.buildgraph2(graph,arr);
		graph.check(graph2);
		Dijkstra d = new Dijkstra();
		d.dijkstra(graph2,graph.nodes.get(1));
		System.out.println();
		d.dijkstra2(graph2,graph.nodes.get(1));
	}
}

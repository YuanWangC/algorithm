package dataStructure;
import dataStructure.Node;

public class Edge{
	public int weight;
	public Node from;
	public Node to;
	public Edge(int w,Node f ,Node t) {
		this.weight = w;
		this.from = f;
		this.to = t;
	}
}

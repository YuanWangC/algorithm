package dataStructure;

import java.util.ArrayList;
import dataStructure.Edge;
public class Node{
	public int value;
	public int in;
	public int out;
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;
	public Node(int val) {
		this.value = val;
		this.in = 0;
		this.out = 0;
		nexts = new ArrayList();
		edges = new ArrayList();
	}
}

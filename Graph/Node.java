package Graph;

import java.util.LinkedList;

public class Node {
	public LinkedList<Link> adjs;
	public int distance = Integer.MAX_VALUE;
	
	public Node(LinkedList<Link> list) {
		this.adjs = list;
	}
}

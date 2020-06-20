package Graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author zailinyuan
 * 
 * 	Adjacent List implement for the Graph.
 *
 */
public class Graph {
	// Costs:
	private static final int LARGE_COST = 250;
	private static final int SMALL_COST = 1;
	
	// Parameter setting:
	private int numOfNodes;		// Number of Nodes in the graph
	private int k;				// Number of paths with cost == 1
	private int[] pool = new Rack().getRack();
	
	// Graph part:
	private Node[] nodes;
	
	
	/**
	 * 	Constructor, and create the whoe graph:
	 * @param size
	 * @param k
	 * @throws Exception
	 */
	public Graph(int size, int k) throws Exception {
		this.numOfNodes = size;
		if(k >= Rack.NUM_OF_NODES) throw new Exception("K is too large, must be least than number of nodes - 1!");
		this.k = k;
		createGraph();
	}
	
	/**
	 * 	Filter out link with zero capacity:
	 */
	public int filter() {
		Link tar = new Link(0,0,0);
		int sum = 0;
		for(int i=0; i<nodes.length; ++i) {
			while(nodes[i].adjs.remove(tar)) {
				++sum;
			}
		}
		return sum;
	}
	
	
	/**
	 * 	Display graph structure:
	 */
	public void displayGraphStruct() {
		for(int i=0; i<nodes.length; ++i) {
			StringBuilder sb = new StringBuilder("Node " + (i+1) + ": ");
			for(Link l: nodes[i].adjs) {
				sb.append(l.destNodeNum + " -> ");
			}
			sb.append("null");
			System.out.println(sb.toString());
		}
	}
	
	
	/**
	 * 	Display graph cost:
	 */
	public void displayGraphCost() {
		for(int i=0; i<nodes.length; ++i) {
			StringBuilder sb = new StringBuilder("Node " + (i+1) + ": ");
			for(Link l: nodes[i].adjs) {
				sb.append(l.cost + " -> ");
			}
			sb.append("null");
			System.out.println(sb.toString());
		}
	}
	
	/**
	 * 	Display graph cost:
	 */
	public void displayGraphCapacity() {
		for(int i=0; i<nodes.length; ++i) {
			StringBuilder sb = new StringBuilder("Node " + (i+1) + ": ");
			for(Link l: nodes[i].adjs) {
				sb.append(l.capacity + " -> ");
			}
			sb.append("null");
			System.out.println(sb.toString());
		}
	}
	
	/**
	 * @return The graph we have
	 */
	public Node[] getGraph() {
		return nodes;
	}
	
	/**
	 * 	Create the graph.
	 */
	private void createGraph() {
		this.nodes = new Node[this.numOfNodes];  	// Nodes array
		for(int i=0; i<nodes.length; ++i) {
			nodes[i] = new Node(adjList(i));
		}
	}
	
	/**
	 * 
	 * @param n: the node to add adjacent list
	 * @return
	 */
	private LinkedList<Link> adjList(int n) {
		LinkedList<Link> adj = new LinkedList<Link>();
		Random r = new Random();
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<numOfNodes; ++i) {
			adj.add(new Link((i+1), LARGE_COST, Math.abs(pool[i] - pool[n])));
		}
		adj.remove(n);
		while(set.size() < k) {
			int num = r.nextInt(numOfNodes - 1);
			if(num != n) set.add(num);
			adj.get(num).cost = SMALL_COST;
		}
		
		return adj;
	}
}

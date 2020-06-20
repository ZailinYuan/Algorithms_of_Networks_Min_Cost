package project1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import Graph.Node;
import Graph.Link;

public class Dijasktra {
	
//	/**
//	 * 	Find out the min cost path and it's cost.
//	 * @param graph
//	 * @return
//	 */
//	public static int[] minCostPathSearch(Node[] graph) {
//		int[] tracker = new int[graph.length];
//		graph[0].distance = 0;
//		ArrayList<Integer> cloud = new ArrayList<>();
//		cloud.add(0);
//		
//		int curNode = 0;
//		while(cloud.size() < graph.length) {
//			LinkedList<Link> adj = graph[curNode].adjs;
//			
//			int minDistance = Integer.MAX_VALUE;
//			int tmp = curNode;
//			Iterator<Link> iter = adj.descendingIterator();
//			while(iter.hasNext()) {
//				Link link = iter.next();
//				int newCost = graph[curNode].distance + link.cost;
//				int tarNode = link.destNodeNum-1;
//				if(newCost < graph[tarNode].distance) {
//					graph[tarNode].distance = newCost;
//					tracker[tarNode] = curNode+1;
//				}
//				if(graph[tarNode].distance < minDistance) {
//					minDistance = graph[tarNode].distance;
//					tmp = tarNode;
//				}
//			}
//			curNode = tmp;
//			cloud.add(curNode);
//			System.out.println("Cur Node: " + curNode);
//		}
//		
//		return tracker;
//	}
	
	public static int[] minCostPathSearch(Node[] graph) {
		int[] tracker = new int[graph.length];
		Set<Integer> cloud = new HashSet<>();
		cloud.add(0);
		graph[0].distance = 0;
		helper(0, cloud, tracker, graph);
		return tracker;
	}
	
	private static void helper(int curNode, Set<Integer> cloud, int[] tracker, Node[] graph) {
		if(curNode == -1) return;
		int nextNode = -1;
		int minDistance = Integer.MAX_VALUE;
		LinkedList<Link> adj = graph[curNode].adjs;
		Iterator<Link> iter = adj.iterator();
		while(iter.hasNext()) {
			Link link = iter.next();
			int tarNode = link.destNodeNum-1;
			if(cloud.contains(tarNode)) continue;
			int newCost = graph[curNode].distance + link.cost;
			if(newCost < graph[tarNode].distance) {
				graph[tarNode].distance = newCost;
				tracker[tarNode] = curNode+1;
			}
			if(graph[tarNode].distance < minDistance) {
				minDistance = graph[tarNode].distance;
				nextNode = tarNode;
			}
		}
		if(nextNode != -1) cloud.add(nextNode);
		helper(nextNode, cloud, tracker, graph);
	}
	
	/**
	 * 	Print the min cost path and find out it's cost:
	 * @param tracker
	 * @return
	 */
	public static int minCostPath(int[] tracker, Node[] graph) {
		int cost = 0;
		int prev = tracker.length-1;
		String pathDistance = "null";
		String path = "null";
		while(tracker[prev] != 0) {
			pathDistance = graph[prev].distance + " -> " + pathDistance;
			path = (prev + 1) + " -> " + path; 
			cost += graph[prev].distance;
			prev = tracker[prev]-1;
		}
		pathDistance = "Distance of the path: " + pathDistance;
		path = "Path: " + path;
		System.out.println(pathDistance);
		System.out.println(path);
		return cost;
	}
}


package Graph;

import java.util.Iterator;
import project1.Dijasktra;

public class Tester {
	public static void main(String[] args) {
		Graph g;
		try {
			int sum = 0;
			for(int i=0; i<50; ++i) {
				g = new Graph(25, 15);
				int all = g.filter();
				int base = 25*24;
				System.out.println("Ratio: " + (double)(base-all)/base);
				
				g.displayGraphCost();
				
				int[] prev = Dijasktra.minCostPathSearch(g.getGraph());
				
				sum += Dijasktra.minCostPath(prev, g.getGraph());
			}
			System.out.println("Res: " + (double)sum / 50);
			
			// System.out.println("Cost of the mininum path: " + Dijasktra.minCostPath(prev, g.getGraph()));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
}

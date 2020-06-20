package Graph;

import java.util.LinkedList;

public class Rack {
	// Constants:
	public static final int NUM_OF_NODES = 25;
	private static final int[] ID = new int[] {2,0,2,1,4,6,8,5,5,0};
	
	// The array used to generate capacities:
	private int[] rack;
	
	
	public Rack() {
		this.rack = new int[NUM_OF_NODES];
		for(int i=0; i<rack.length; ++i) {
			rack[i] = ID[i % ID.length];
		}
	}
	
	/**
	 * 	Return rack for Graph.
	 * @return rack array.
	 */
	public int[] getRack() {
		return rack;
	}
	
	
	/**
	 * 	Displaying the rack:
	 * @return The rack.
	 */
	public String showRack() {
		StringBuilder sb = new StringBuilder("[");
		for(int i=0; i<rack.length-1; ++i) {
			sb.append(rack[i] + ", ");
		}
		sb.append(rack[rack.length-1] + "]");
		return sb.toString();
	}
}

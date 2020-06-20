package Graph;


public class Link {
	public int cost;
	public final int capacity;
	public int destNodeNum;
	
	public Link(int dest, int cost, int capactiy) {
		this.cost = cost;
		this.capacity = capactiy;
		this.destNodeNum = dest;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof Link)) return false;
		Link x = (Link)o;
		return this.capacity == x.capacity;
	}
	
	@Override
	public int hashCode() {
		return Integer.valueOf(this.capacity);
	}
}

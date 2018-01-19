package ratioGoogle;

public class Edge {
	
	public double weight;
	public Vertex src;
	public Vertex dest;
		
	public Edge(double weight, Vertex src, Vertex dest) {
		// TODO Auto-generated constructor stub
		this.weight = weight;
		this.src = src;
		this.dest = dest;
	}
	
	public String toString() {
		return "Dest: " + this.dest.label + " Weight: " + this.weight;  
	}

}

package ratioGoogle;

import java.util.*;

public class Vertex {
	
	public String label;
	public Set<Edge> edges;
	
	public Vertex(String label) {
		// TODO Auto-generated constructor stub
		this.label = label;
		this.edges = new HashSet<Edge>();
	}
	
	public void addEdge(int weight, Vertex dest) {
		edges.add(new Edge(weight, this, dest));
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public boolean equals(Vertex v) {
		return v.label.equals(this.label);
	}
	
	public String toString() {
		return this.label;
	}

}

package ratioGoogle;

import java.util.*;

public class Graph {
	
	
	//public Set<Vertex> vertices; pretty sure we don't need map but lets just keep it
	public Set<Edge> edges;
	
	public Map<Vertex, Set<Edge>> vertexMap;
	
	public Graph() {
		// TODO Auto-generated constructor stub
		vertexMap = new HashMap<Vertex, Set<Edge>>();
		//vertices = new HashSet<Vertex>();
		edges = new HashSet<>();
	}
	
	public void addEdge(Edge e) {
		edges.add(e);
	}
	
	public void addVertex(Vertex v) {
		vertexMap.put(v, v.edges);
		//vertices.add(v);
	}
	
	public boolean containsKey(Vertex v) {
		//return vertices.contains(v);
		Set<Vertex> s = vertexMap.keySet();
		for (Vertex vert : s) {
			if (vert.label.equals(v.label)) {
				return true;
			}
		}
		//return vertexMap.containsKey(v);
		return false;
	}
	
	public Set<Vertex> keySet(){
		return vertexMap.keySet();
	}
	
	public Vertex getVertex(Vertex v) {
		Set<Vertex> s = vertexMap.keySet();
		for (Vertex vert : s) {
			if (vert.label.equals(v.label)) {
				return vert;
			}
		}
		return null;
	}
	
	public Vertex getVertex(String str) {
		Set<Vertex> s = vertexMap.keySet();
		for (Vertex vert : s) {
			if (vert.label.equals(str)) {
				return vert;
			}
		}
		return null;
	}
	
	public String toString() {
		String s = "";
		for (Map.Entry<Vertex, Set<Edge>> entry : vertexMap.entrySet()) {
			s = s + entry.getKey().label + ": \n";
			Set<Edge> set = entry.getValue();
			for (Edge e : set) {
				s = s + e.toString() + "\n";
			}
			s = s + "\n";
		}
		return s;
	}

}

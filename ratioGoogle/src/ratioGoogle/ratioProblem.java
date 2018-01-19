package ratioGoogle;

import java.io.*;
import java.util.*;


public class ratioProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = readFile("source");
		
		//System.out.println(g);
		
		System.out.println("Ratios");
		
		questionFile("question", g);
	}
	
	public static Graph readFile(String str1) {
		File f = new File(str1);
		Scanner s;
		
		Graph g;
		
		try {
			g = new Graph();
			s = new Scanner(f);
			while (s.hasNextLine()) {
				
				// parse ratio relationship
				String[] array = tokenize(s.nextLine());
				
				// create new vertex
				Vertex src = new Vertex(array[0]);
				// check if vertex exists
				// don't want to add to graph if it exists already
				// want to add it to existing relationships
				if (g.containsKey(src)) {
					src = g.getVertex(src);
				}
				
				// same as above
				Vertex dest = new Vertex(array[1]);
				if (g.containsKey(dest)) {
					dest = g.getVertex(dest);
				}
				
				Edge edge = new Edge(Double.parseDouble(array[2]), src, dest);
				src.addEdge(edge); // add the new relationship
				g.addEdge(edge); // add to adjacency list
				
				// only add if its a new vertex
				if (!g.containsKey(src)) {
					g.addVertex(src);
				}
				if (!g.containsKey(dest)) {
					g.addVertex(dest);
				}
				 
			}
			s.close();
			return g;
		} catch (FileNotFoundException e){
			System.out.println("file wasn't found");
		}
		// return null if error
		return null;
	}
	
	public static void questionFile(String str2, Graph g) {
		Scanner s;
		File f = new File(str2);
		try {
			f = new File(str2);
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String[] array = tokenize(s.nextLine());
				System.out.println(array[0] + " " + array[1] + " " + computeRatio(array[0], array[1], g));
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}
	
	public static String[] tokenize(String s) {
		String[] array = s.split(", ");
		return array;
	}
	
	public static double computeRatio(String src, String dest, Graph g) {
		ArrayList<Vertex> visited = new ArrayList<>();
		
		Stack<Double> s = new Stack<>();
		Stack<Double> weights = new Stack<>();
		Stack<Vertex> sv = new Stack<>();
		sv.push(g.getVertex(src));

		s.push(1.0); // 1 because if I put 0 it multiplies by 0
		boolean found = false;
		while (!sv.isEmpty() && !found) {
			// pop vertex off stack
			// if vertex not in visted
			// add vertex to visited
			// for each unvisited neighbor w of u
			// push w into s
			// else end process when all nodes have been visited
			Vertex visit = sv.peek();
			sv.pop();
			weights.push(s.pop());
			if (!isInVisit(visited, visit)) {
				visited.add(visit);
				Set<Edge> edges = g.get(visit);
				for (Edge next : edges) {
					if (next.dest.label.equals(dest)) {
						found = true;
						weights.push(next.weight);
					}
					sv.push(next.dest);
					s.push(next.weight);
				}
			}
		}
		System.out.print(weights.peek() + " ");
		double ratio = weights.pop();
		while (!weights.isEmpty()) {
			System.out.print(weights.peek() + " ");
			ratio = ratio * weights.pop();
		}
		return ratio;
 	}
	
	public static boolean isInVisit(ArrayList<Vertex> visited, Vertex v) {
		for (Vertex visit : visited) {
			if (visit.label.equals(v.label)) {
				return true;
			}
		}
		return false;
	}
}

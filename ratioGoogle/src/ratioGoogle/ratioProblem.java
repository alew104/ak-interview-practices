package ratioGoogle;

import java.io.*;
import java.util.*;


public class ratioProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = readFile("source");
		
		System.out.println(g.toString());
		
		System.out.println("Ratios");
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
				System.out.print(array[0] + " " + array[1] + " " + computeRatio(array[0], array[1], g));
			}
		} catch (Exception e) {
			System.out.println("file not found");
		}
	}
	
	public static String[] tokenize(String s) {
		String[] array = s.split(", ");
		return array;
	}
	
	public static String computeRatio(String src, String dest, Graph g) {
		// not actually ratio cause I'm lazy to math
		Map<Vertex, Boolean> visited = new HashMap<>();
		Set<Vertex> set = g.keySet();
		for (Vertex v : set) {
			visited.put(v, false);
		}
		Stack<Double> s = new Stack<>();
		Stack<Vertex> sv = new Stack<>();
		
		return null;
 	}
}

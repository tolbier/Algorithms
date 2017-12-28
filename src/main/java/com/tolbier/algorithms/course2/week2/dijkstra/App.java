package com.tolbier.algorithms.course2.week2.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * The file contains an adjacency list representation of an undirected weighted graph with 200 vertices labeled 1 to 200.
 * Each row consists of the node tuples that are adjacent to that particular vertex along with the length of that edge.
 * For example, the 6th row has 6 as the first entry indicating that this row corresponds to the vertex labeled 6. The 
 * next entry of this row "141,8200" indicates that there is an edge between vertex 6 and vertex 141 that has length 8200. 
 * The rest of the pairs of this row indicate the other vertices adjacent to vertex 6 and the lengths of the corresponding edges.
 * 
 * Your task is to run Dijkstra's shortest-path algorithm on this graph, using 1 (the first vertex) as the source vertex, 
 * and to compute the shortest-path distances between 1 and every other vertex of the graph. If there is no path between a 
 * vertex v and vertex 1, we'll define the shortest-path distance between 1 and v to be 1000000.
 * 
 * You should report the shortest-path distances to the following ten vertices, in order: 7,37,59,82,99,115,133,165,188,197. 
 * You should encode the distances as a comma-separated string of integers. So if you find that all ten of these vertices except 
 * 115 are at distance 1000 away from vertex 1 and 115 is 2000 distance away, then your answer should be 1000,1000,1000,1000,1000,2000,1000,1000,1000,1000. 
 * Remember the order of reporting DOES MATTER, and the string should be in the same order in which the above ten vertices are given. 
 * The string should not contain any spaces. Please type your answer in the space provided.
 * 
 * IMPLEMENTATION NOTES: This graph is small enough that the straightforward O(mn) time implementation of Dijkstra's algorithm 
 * should work fine. OPTIONAL: For those of you seeking an additional challenge, try implementing the heap-based version. Note this 
 * requires a heap that supports deletions, and you'll probably need to maintain some kind of mapping between vertices and their positions 
 * in the heap.
 */
public class App {

	public static void main(String[] args) {
		WeightedGraph wg = getWeightedGraph("resources/course2/week2/dijkstraData.txt");
	}

	static WeightedGraph getWeightedGraph(String filePath) {
		WeightedGraph wg= new WeightedGraph();
		Scanner lineScanner = null;
		try {
			lineScanner = new Scanner(new File(filePath));
			while (lineScanner.hasNextLine()) {

				String line = lineScanner.nextLine();
				Scanner vertexScanner = new Scanner(line);
				int tail = vertexScanner.nextInt()-1;
				vertexScanner.useDelimiter("\\s+");

				while (vertexScanner.hasNext()) {
					String pair = vertexScanner.next();
					Pattern pattern = Pattern.compile("^(\\d+),(\\d+)");
					Matcher matcher = pattern.matcher(pair);
					if (matcher.find()) {
						int head = Integer.parseInt(matcher.group(1))-1;
						int weight = Integer.parseInt(matcher.group(2));
						wg.addWeightedArc(tail, head, weight);
					}

				}
				/*
				 * //adjacencyList.addVertex(tailVertex - 1); while (intScanner.hasNextInt()) {
				 * int headVertex = intScanner.nextInt(); int i =1; //adjacencyList.addEdge(new
				 * Edge(tailVertex - 1, headVertex - 1)); } intScanner.close();
				 */
				vertexScanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			lineScanner.close();
		}
		return wg;
	}

}

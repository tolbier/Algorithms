package com.tolbier.algorithms.course2.week2.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dijkstra {
	private static Map<Vertex<Integer>, Integer> shortestDistances;

	public static Map<Vertex<Integer>, Integer> DijkstraStraightShortestDistances(Graph<Integer> graph, int start) {
		shortestDistances = new HashMap<Vertex<Integer>, Integer>();
		Set<Vertex<Integer>> explored = new HashSet<Vertex<Integer>>();
		Vertex<Integer> startVertex = graph.getVertex(start);
		explored.add(startVertex);
		shortestDistances.put(startVertex, 0);
		while (explored.size() < graph.getNumberOfVertices()) {
			Vertex<Integer> nearestVertex = null;
			int nearestDistance = Integer.MAX_VALUE;
			for (Edge<Integer> edge : graph.getAllEdges()) {
				if (explored.contains(edge.getVertex1()) && !explored.contains(edge.getVertex2())) {
					int dijkstraDistance = getDijkstraDistance(edge);
					if (dijkstraDistance < nearestDistance) {
						nearestDistance = dijkstraDistance;
						nearestVertex = edge.getVertex2();
					}
				}
			}
			explored.add(nearestVertex);
			shortestDistances.put(nearestVertex, nearestDistance);
		}

		return shortestDistances;
	}

	private static int getDijkstraDistance(Edge<Integer> edge) {
		return shortestDistances.get(edge.getVertex1()) + edge.getWeight();
	}

	static Graph<Integer> getWeightedGraph(String filePath) {
		Graph<Integer> wg = new Graph<Integer>(true);
		Scanner lineScanner = null;
		try {
			lineScanner = new Scanner(new File(filePath));
			while (lineScanner.hasNextLine()) {

				String line = lineScanner.nextLine();
				Scanner vertexScanner = new Scanner(line);
				int tail = vertexScanner.nextInt();
				Vertex<Integer> vertex1 = wg.addSingleVertex(tail);
				vertex1.setData(tail);

				vertexScanner.useDelimiter("\\s+");

				while (vertexScanner.hasNext()) {
					String pair = vertexScanner.next();
					Pattern pattern = Pattern.compile("^(\\d+),(\\d+)");
					Matcher matcher = pattern.matcher(pair);
					if (matcher.find()) {
						int head = Integer.parseInt(matcher.group(1));
						int weight = Integer.parseInt(matcher.group(2));
						wg.addEdge(tail, head, weight);
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

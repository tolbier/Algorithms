package com.tolbier.algorithms.course2.week2.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.commons.VertexDistanceComparator;

public class Dijkstra {
	private static Map<Vertex<Integer>, Integer> shortestDistances;

	public static Map<Vertex<Integer>, Integer> dijkstraStraightShortestDistances(Graph<Integer> graph, int start) {
		shortestDistances = new ShortestDistances();
		Set<Vertex<Integer>> explored = new HashSet<Vertex<Integer>>();
		Vertex<Integer> startVertex = graph.getVertex(start);
		explored.add(startVertex);
		shortestDistances.put(startVertex, 0);
		while (explored.size() < graph.getNumberOfVertices()) {
			Vertex<Integer> nearestVertex = null;
			int nearestDistance = Integer.MAX_VALUE;
			for ( Vertex<Integer> v :explored) {
				for (Edge<Integer>e: v.getEdges()) {
					if ( !explored.contains(e.getVertex2())) {
						int dijkstraDistance = getDijkstraDistance(e);
						if (dijkstraDistance < nearestDistance) {
							nearestDistance = dijkstraDistance;
							nearestVertex = e.getVertex2();
						}
					}
				}
			}
			explored.add(nearestVertex);
			shortestDistances.put(nearestVertex, nearestDistance);
		}

		return shortestDistances;
	}
	public static Map<Vertex<Integer>, Integer> dijkstraHeapShortestDistances(Graph<Integer> graph, int start) {
		PriorityQueue<Vertex<Integer>> heap = initDijkstraHeap(graph, start);
		
		while (!heap.isEmpty()) {
			Vertex<Integer> w = heap.poll();
			for (Edge<Integer>e: w.getEdges()) {
				Vertex<Integer> v= e.getVertex2();
				if (heap.contains(v)){
					heap.remove(v);
					int dijkstraDistance = getDijkstraDistance(e);
					Integer vDijkstra = shortestDistances.get(v);
					if (dijkstraDistance<vDijkstra) {
						shortestDistances.put(v, dijkstraDistance);
					}
					heap.add(v);
				}
						
			}
		}

		return shortestDistances;
	}
	static PriorityQueue<Vertex<Integer>> initDijkstraHeap(Graph<Integer> graph, int start) {
		Vertex<Integer> startVertex = graph.getVertex(start);
		createInitialShortestDistances(startVertex);	
		PriorityQueue<Vertex<Integer>> heap = createInitialHeap(graph);
		return heap;
	}
	static void createInitialShortestDistances(Vertex<Integer> startVertex) {
		shortestDistances = new ShortestDistances();
		shortestDistances.put(startVertex, 0);
	}
	static PriorityQueue<Vertex<Integer>> createInitialHeap(Graph<Integer> graph) {
		Comparator<Vertex<Integer>> comparator = new VertexDistanceComparator<Integer>(shortestDistances);
		PriorityQueue<Vertex<Integer>> heap = 
	            new PriorityQueue<Vertex<Integer>>(comparator);
		addAllGraphVectorsToHeap(graph, heap);
		return heap;
	}
	static void addAllGraphVectorsToHeap(Graph<Integer> graph, PriorityQueue<Vertex<Integer>> heap) {
			heap.addAll(graph.getAllVertex());
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

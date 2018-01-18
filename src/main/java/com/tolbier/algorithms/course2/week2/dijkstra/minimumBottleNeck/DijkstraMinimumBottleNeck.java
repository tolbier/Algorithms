package com.tolbier.algorithms.course2.week2.dijkstra.minimumBottleNeck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
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

public class DijkstraMinimumBottleNeck {
	private static Map<Vertex<Integer>, Integer> minimumBottleNecks;


	public static Map<Vertex<Integer>, Integer> dijkstraMininumBottleNecks(Graph<Integer> graph, int start) {
		PriorityQueue<Vertex<Integer>> heap = initDijkstraHeap(graph, start);
		
		while (!heap.isEmpty()) {
			Vertex<Integer> w = heap.poll();
			for (Edge<Integer>e: w.getEdges()) {
				Vertex<Integer> v= e.getVertex2();
				if (heap.contains(v)){
					heap.remove(v);
					int edgeBottleNeck = getEdgeBottleNeck(e);
					Integer minimumBottleNeck = minimumBottleNecks.get(v);
					if (edgeBottleNeck<minimumBottleNeck) {
						minimumBottleNecks.put(v, edgeBottleNeck);
					}
					heap.add(v);
				}
						
			}
		}

		return minimumBottleNecks;
	}
	static PriorityQueue<Vertex<Integer>> initDijkstraHeap(Graph<Integer> graph, int start) {
		Vertex<Integer> startVertex = graph.getVertex(start);
		createInitialShortestDistances(startVertex);	
		PriorityQueue<Vertex<Integer>> heap = createInitialHeap(graph);
		return heap;
	}
	static void createInitialShortestDistances(Vertex<Integer> startVertex) {
		minimumBottleNecks = new MinimumBottleNecks();
		minimumBottleNecks.put(startVertex, 0);
	}
	static PriorityQueue<Vertex<Integer>> createInitialHeap(Graph<Integer> graph) {
		Comparator<Vertex<Integer>> comparator = new VertexMinimumBottleNeckComparator<Integer>(minimumBottleNecks);
		PriorityQueue<Vertex<Integer>> heap = 
	            new PriorityQueue<Vertex<Integer>>(comparator);
		addAllGraphVectorsToHeap(graph, heap);
		return heap;
	}
	static void addAllGraphVectorsToHeap(Graph<Integer> graph, PriorityQueue<Vertex<Integer>> heap) {
		heap.addAll(graph.getAllVertex() );
	}

	
	private static int getEdgeBottleNeck(Edge<Integer> edge) {
		return Math.max(minimumBottleNecks.get(edge.getVertex1()), edge.getWeight());
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

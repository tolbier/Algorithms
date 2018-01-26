package com.tolbier.algorithms.course2.week2.dijkstra;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.commons.VertexDistanceComparator;

public class Dijkstra {
	private Map<Vertex<Integer>, Integer> shortestDistances = new ShortestDistances();

	public Map<Vertex<Integer>, Integer> dijkstraStraightShortestDistances(Graph<Integer> graph, int start) {

		Set<Vertex<Integer>> explored = new HashSet<Vertex<Integer>>();
		Vertex<Integer> startVertex = graph.getVertex(start);
		explored.add(startVertex);
		shortestDistances.put(startVertex, 0);
		while (explored.size() < graph.getNumberOfVertices()) {
			Vertex<Integer> nearestVertex = null;
			int nearestDistance = Integer.MAX_VALUE;
			for (Vertex<Integer> v : explored) {
				for (Edge<Integer> e : v.getEdges()) {
					if (!explored.contains(e.getVertex2())) {
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

	public Map<Vertex<Integer>, Integer> dijkstraHeapShortestDistances(Graph<Integer> graph, int start) {
		PriorityQueue<Vertex<Integer>> heap = initDijkstraHeap(graph, start);

		while (!heap.isEmpty()) {
			Vertex<Integer> w = heap.poll();
			for (Edge<Integer> e : w.getEdges()) {
				Vertex<Integer> v = e.getVertex2();
				if (heap.contains(v)) {
					heap.remove(v);
					int dijkstraDistance = getDijkstraDistance(e);
					Integer vDijkstra = shortestDistances.get(v);
					if (dijkstraDistance < vDijkstra) {
						shortestDistances.put(v, dijkstraDistance);
					}
					heap.add(v);
				}

			}
		}

		return shortestDistances;
	}

	PriorityQueue<Vertex<Integer>> initDijkstraHeap(Graph<Integer> graph, int start) {
		Vertex<Integer> startVertex = graph.getVertex(start);
		createInitialShortestDistances(startVertex);
		PriorityQueue<Vertex<Integer>> heap = createInitialHeap(graph);
		return heap;
	}

	void createInitialShortestDistances(Vertex<Integer> startVertex) {

		shortestDistances.put(startVertex, 0);
	}

	PriorityQueue<Vertex<Integer>> createInitialHeap(Graph<Integer> graph) {
		Comparator<Vertex<Integer>> comparator = new VertexDistanceComparator<Integer>(shortestDistances);
		PriorityQueue<Vertex<Integer>> heap = new PriorityQueue<Vertex<Integer>>(comparator);
		addAllGraphVectorsToHeap(graph, heap);
		return heap;
	}

	void addAllGraphVectorsToHeap(Graph<Integer> graph, PriorityQueue<Vertex<Integer>> heap) {
		heap.addAll(graph.getAllVertex());
	}

	int getDijkstraDistance(Edge<Integer> edge) {
		return shortestDistances.get(edge.getVertex1()) + edge.getWeight();
	}

}

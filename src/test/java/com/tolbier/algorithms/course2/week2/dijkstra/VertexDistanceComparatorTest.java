package com.tolbier.algorithms.course2.week2.dijkstra;


import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;



public class VertexDistanceComparatorTest {

	Comparator<Vertex<Integer>> comparator;

	@Test
	public void testVertexDistanceComparator1() {
		Graph<Integer> graph =Dijkstra.getWeightedGraph("resources/course2/week2/dijkstraTest1.txt"); 
		Map<Vertex<Integer>,Integer> shortestPaths= Dijkstra.dijkstraStraightShortestDistances(graph,1);
		comparator = new VertexDistanceComparator(shortestPaths);

		PriorityQueue<Vertex<Integer>> heap = 
	            new PriorityQueue<Vertex<Integer>>(comparator);
		for (Vertex<Integer> vertex :graph.getAllVertex()) {
			heap.add(vertex);
		}
		assertEquals("[1, 2, 3, 8, 5, 6, 7, 4]",heap.toString());
	}

}

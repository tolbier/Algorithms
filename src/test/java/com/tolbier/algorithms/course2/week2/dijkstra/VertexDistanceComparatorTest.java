package com.tolbier.algorithms.course2.week2.dijkstra;


import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.commons.VertexDistanceComparator;



public class VertexDistanceComparatorTest {

	Comparator<Vertex<Integer>> comparator;
	Dijkstra dijkstra;
    @Before
	public void init() {
    	 dijkstra = new Dijkstra();
    }    
	@Test
	public void testVertexDistanceComparator1() {
		Graph<Integer> graph =GraphUtil.getWeightedGraph("resources/course2/week2/dijkstraTest1.txt"); 
		Map<Vertex<Integer>,Integer> shortestPaths= dijkstra.dijkstraStraightShortestDistances(graph,1);
		comparator = new VertexDistanceComparator(shortestPaths);

		PriorityQueue<Vertex<Integer>> heap = 
	            new PriorityQueue<Vertex<Integer>>(comparator);
		for (Vertex<Integer> vertex :graph.getAllVertex()) {
			heap.add(vertex);
		}
		assertEquals("[1, 2, 3, 8, 5, 6, 7, 4]",heap.toString());
	}

}

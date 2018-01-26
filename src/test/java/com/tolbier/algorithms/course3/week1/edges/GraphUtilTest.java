package com.tolbier.algorithms.course3.week1.edges;


import static org.junit.Assert.*;




import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;

public class GraphUtilTest {

	@Test
	public void testGetWeightedGraph() {
		Graph<Integer> graph = GraphUtil.getWeightedGraph("resources/course3/week1/edges/edges.txt");
		assertEquals("[2, 132, 171, 244, 310, 316, 324, 397, 414]" , graph.getVertex(1).getAdjacentVertexes().toString());
		assertEquals("[36, 38, 303, 476]" , graph.getVertex(37).getAdjacentVertexes().toString());
		assertEquals("[495, 497, 15, 28, 45, 65, 112, 194, 260, 265, 272, 308, 314, 500]" , graph.getVertex(496).getAdjacentVertexes().toString());
		
		assertEquals("[Edge [isDirected=false, vertex1=36, vertex2=37, weight=-7609], "
				    + "Edge [isDirected=false, vertex1=37, vertex2=38, weight=3054], "
				    + "Edge [isDirected=false, vertex1=37, vertex2=303, weight=-562], "
				    + "Edge [isDirected=false, vertex1=37, vertex2=476, weight=4790]]"
				    	, graph.getVertex(37).getEdges().toString());

	}
	
	//@Test
	public void testgetMST_1_10() {
		int totalCost=  GraphUtil.getMSTTotalCost("resources/course3/week1/edges/input_random_1_10.txt");
		assertEquals(-7430,totalCost);
	}
	@Test
	public void testgetMST_2_10() {
		int totalCost=  GraphUtil.getMSTTotalCost("resources/course3/week1/edges/input_random_2_10.txt");
		assertEquals(-12829,totalCost);
	}
	//@Test
	public void testgetMST() {
		int totalCost=  GraphUtil.getMSTTotalCost("resources/course3/week1/edges/edges.txt");
		assertEquals(-3612829,totalCost);
	}
}

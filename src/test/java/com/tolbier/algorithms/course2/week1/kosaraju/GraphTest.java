package com.tolbier.algorithms.course2.week1.kosaraju;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GraphTest {

	Graph graph,graph2;
	@Before
	public void init() {
		
		graph = new Graph(2);
		graph.addArc(0, 1);
		graph.addArc(1, 2);
		
		graph2=new Graph(9);
		graph2.addArc(0,4);
		graph2.addArc(1,2);
		graph2.addArc(2,3);
		graph2.addArc(3,1);
		graph2.addArc(3,4);
		graph2.addArc(4,5);
		graph2.addArc(5,8);
		graph2.addArc(5,0);
		graph2.addArc(6,7);
		graph2.addArc(7,8);
		graph2.addArc(8,6);
	}

	@Test
	public void testCreateGraph() {
		assertNotNull(graph);
	}
	@Test
	public void testGraph() {

		assertEquals("[[[1], [2]]]",graph.toString());
	}
	@Test
	public void testGraph2() {
		assertEquals("[[[4], [2], [3], [1, 4], [5], [0, 8], [7], [8], [6]]]",graph2.toString());
	}
	@Test
	public void testReverse() {
		assertEquals("[[[5], [3], [1], [2], [0, 3], [4], [8], [6], [5, 7]]]",graph2.reverse().toString());
	}
	
}

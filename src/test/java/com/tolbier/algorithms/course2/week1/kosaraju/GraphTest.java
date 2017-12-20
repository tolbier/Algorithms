package com.tolbier.algorithms.course2.week1.kosaraju;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GraphTest {

	Graph graph;
	@Before
	public void init() {
		
		graph = new Graph(2);

	}

	@Test
	public void testCreateGraph() {
		assertNotNull(graph);
	}
	@Test
	public void testAddArc() {
		graph.addArc(0, 1);
		graph.addArc(1, 2);
		assertEquals("[[[1], [2]]]",graph.toString());
	}
	
}

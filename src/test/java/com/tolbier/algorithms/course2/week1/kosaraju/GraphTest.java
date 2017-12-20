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
		
		graph = new Graph(875714);
	}

	@Test
	public void testCreateGraph() {
		assertNotNull(graph);
	}

	
}

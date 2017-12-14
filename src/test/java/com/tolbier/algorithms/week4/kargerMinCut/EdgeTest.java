package com.tolbier.algorithms.week4.kargerMinCut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class EdgeTest {
	Edge edge;

	@Before
	public void init() {
		 edge = null;
	}	
	@Test
	public void testCreateEdge() {
		 edge = new Edge(1,5);
		 assertNotNull(edge);
		 assertEquals(1, edge.getTailVertex());
		 assertEquals(5, edge.getHeadVertex());

		 
	}
	
	@Test
	public void testCreateEdge2() {
		 edge = new Edge(1,1);
		 assertNotNull(edge);
		 edge.setTailVertex(3); 
		 edge.setHeadVertex(2);

		 assertEquals(3, edge.getTailVertex());
		 assertEquals(2, edge.getHeadVertex());
	}
	@Test
	public void testSetVertices() {
		 edge = new Edge(1,1);
		 edge.setVertices(4, 5);
		 assertNotNull(edge);
		 assertEquals(4, edge.getTailVertex());
		 assertEquals(5, edge.getHeadVertex());

	}
	
	
}
	
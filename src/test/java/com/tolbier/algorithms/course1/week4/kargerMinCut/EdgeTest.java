package com.tolbier.algorithms.course1.week4.kargerMinCut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.course1.week4.kargerMinCut.Edge;


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
		 assertEquals(1, edge.getTail());
		 assertEquals(5, edge.getHead());

		 
	}
	
	@Test
	public void testCreateEdge2() {
		 edge = new Edge(1,1);
		 assertNotNull(edge);
		 edge.setTail(3); 
		 edge.setHead(2);

		 assertEquals(3, edge.getTail());
		 assertEquals(2, edge.getHead());
	}
	@Test
	public void testSetVertices() {
		 edge = new Edge(1,1);
		 edge.setVertices(4, 5);
		 assertNotNull(edge);
		 assertEquals(4, edge.getTail());
		 assertEquals(5, edge.getHead());

	}
	
	
}
	
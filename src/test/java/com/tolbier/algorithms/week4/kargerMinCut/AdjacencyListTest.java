package com.tolbier.algorithms.week4.kargerMinCut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class AdjacencyListTest {
	AdjacencyList adjacencyList, adjacencyList1 ;
	

	@Before
	public void init() {
		adjacencyList = new AdjacencyList();
		
		adjacencyList1 = new AdjacencyList();
		adjacencyList1.createVertex(0);
		adjacencyList1.addEdge(new Edge(0,1));
		adjacencyList1.addEdge(new Edge(0,1));
		adjacencyList1.createVertex(1);
		adjacencyList1.addEdge(new Edge(1,1));
		adjacencyList1.addEdge(new Edge(1,1));
		adjacencyList1.addEdge(new Edge(1,1));
		adjacencyList1.addEdge(new Edge(1,0));
	}	
	@Test
	public void testCreateAdjacencyList() {
		 assertNotNull(adjacencyList);
	}
	
	@Test
	public void testAddVertices() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(0);
		assertEquals(1,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(1);
		adjacencyList.createVertex(2);
		adjacencyList.createVertex(3);
		assertEquals(4,adjacencyList.getNumberOfVertices());

	}
	@Test
	public void testAddEdges() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(0);
		adjacencyList.addEdge(new Edge(0,1));
		List<Integer> edgesFromVertex = adjacencyList.getEdgesFromVertex(0);
		assertEquals(1,edgesFromVertex.size());

	}	
	@Test
	public void testAddDuplicatedEdges() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(0);
		adjacencyList.addEdge(new Edge(0,2));
		adjacencyList.addEdge(new Edge(0,2));
		List<Integer> edgesFromVertex = adjacencyList.getEdgesFromVertex(0);
		assertEquals(2,edgesFromVertex.size());

	}
	@Test
	public void testGetSuperNodes() {
		assertNotNull(adjacencyList.getSuperNodes());
		assertEquals(0,adjacencyList.getSuperNodes().size());
	}

	@Test
	public void testGetNumberOfEdges() {

		assertEquals(6,adjacencyList1.getNumberOfEdges());
		assertEquals(2,adjacencyList1.getNumberOfEdges(0));
		assertEquals(4,adjacencyList1.getNumberOfEdges(1));
	}
	@Test
	public void testEdgeExists() {
		assertEquals (true,adjacencyList1.edgeExists(new Edge(0,1,0)));
		assertEquals (true,adjacencyList1.edgeExists(new Edge(0,1,1)));
		assertEquals (true,adjacencyList1.edgeExists(new Edge(1,1,0)));
		assertEquals (true,adjacencyList1.edgeExists(new Edge(1,1,1)));
		assertEquals (true,adjacencyList1.edgeExists(new Edge(1,1,2)));
		assertEquals (true,adjacencyList1.edgeExists(new Edge(1,0,3)));
		
		assertEquals (false,adjacencyList1.edgeExists(new Edge(1,0,4)));
	}
	@Test
	public void testGetRandomEdge() {
		Edge randomEdge; 
		for (int i=0;i<10000;i++) {
			randomEdge= adjacencyList1.getRandomEdge();
			assertEquals(true,adjacencyList1.edgeExists(randomEdge));
			
		}
	}
	@Test
	public void testGetEdgeFromOrder() {
		Edge edge; 
		
		edge= adjacencyList1.getEdgeFromOrder(2);
		
		assertEquals(true,adjacencyList1.edgeExists(edge));
			
	
	}

}
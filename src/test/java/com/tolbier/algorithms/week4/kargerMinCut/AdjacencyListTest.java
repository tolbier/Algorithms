package com.tolbier.algorithms.week4.kargerMinCut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class AdjacencyListTest {
	AdjacencyList adjacencyList, adjacencyList1 , adjacencyList2,adjacencyList3;
	

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
		
		adjacencyList2 = new AdjacencyList();
		adjacencyList2.createVertex(0);
		adjacencyList2.addEdge(new Edge(0,2));
		adjacencyList2.addEdge(new Edge(0,1));
		adjacencyList2.createVertex(1);
		adjacencyList2.addEdge(new Edge(1,0));
		adjacencyList2.addEdge(new Edge(1,1));
		adjacencyList2.addEdge(new Edge(1,2));
		adjacencyList2.createVertex(2);
		adjacencyList2.addEdge(new Edge(2,0));
		adjacencyList2.addEdge(new Edge(2,1));

		adjacencyList3 = new AdjacencyList();
		adjacencyList3.createVertex(0);
		adjacencyList3.addEdge(new Edge(0,2));
		adjacencyList3.addEdge(new Edge(0,2));
		adjacencyList3.addEdge(new Edge(0,1));
		adjacencyList3.createVertex(1);
		adjacencyList3.addEdge(new Edge(1,0));
		adjacencyList3.addEdge(new Edge(1,2));
		adjacencyList3.createVertex(2);
		adjacencyList3.addEdge(new Edge(2,0));
		adjacencyList3.addEdge(new Edge(2,0));
		adjacencyList3.addEdge(new Edge(2,1));
		
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
		List<Integer> edgesFromVertex = adjacencyList.getEdgesListFromVertex(0);
		assertEquals(1,edgesFromVertex.size());

	}	
	@Test
	public void testAddDuplicatedEdges() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(0);
		adjacencyList.addEdge(new Edge(0,2));
		adjacencyList.addEdge(new Edge(0,2));
		List<Integer> edgesFromVertex = adjacencyList.getEdgesListFromVertex(0);
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
	public void testEdgeExists1() {
		assertEquals (true,adjacencyList1.edgeExists(new OrderedEdge(0,1,0)));
		assertEquals (true,adjacencyList1.edgeExists(new OrderedEdge(0,1,1)));
		assertEquals (true,adjacencyList1.edgeExists(new OrderedEdge(1,1,0)));
		assertEquals (true,adjacencyList1.edgeExists(new OrderedEdge(1,1,1)));
		assertEquals (true,adjacencyList1.edgeExists(new OrderedEdge(1,1,2)));
		assertEquals (true,adjacencyList1.edgeExists(new OrderedEdge(1,0,3)));
		assertEquals (false,adjacencyList1.edgeExists(new OrderedEdge(1,0,4)));
	}
	@Test
	public void testEdgeExists2() {
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(0,2,0)));
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(0,1,1)));
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(1,0,0)));
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(1,1,1)));
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(1,2,2)));
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(2,0,0)));
		assertEquals (true,adjacencyList2.edgeExists(new OrderedEdge(2,1,1)));
		
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(0,1,0)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(0,1,2)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(0,3,2)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(0,3,3)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(1,1,0)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(1,0,2)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(2,1,0)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(2,0,1)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(2,0,2)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(2,2,2)));
		assertEquals (false,adjacencyList2.edgeExists(new OrderedEdge(3,2,2)));
		
	}

	@Test
	public void testGetRandomEdge() {
		OrderedEdge randomEdge; 
		for (int i=0;i<10000;i++) {
			randomEdge= adjacencyList1.getRandomEdge();
			assertEquals(true,adjacencyList1.edgeExists(randomEdge));
			
		}
	}
	
	@Test
	public void testGetEdgeFromOrder() {
		Edge edge; 
		
		edge= adjacencyList1.getEdgeFromTotalOrder(2);
		assertEquals(true,adjacencyList1.edgeExists(edge));
	}
	@Test
	public void testRemoveEdge1() {

		adjacencyList2.removeEdge(new Edge(0,2));
		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(0,1)));
		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(1,0)));
		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(1,1)));
		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(1,2)));
		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(2,1)));
		assertEquals (0,adjacencyList2.countParallelEdges(new Edge(3,2)));

	}
	@Test
	public void testCountParallelEdges() {
		assertEquals (2,adjacencyList3.countParallelEdges(new Edge(0,2)));
		assertEquals (1,adjacencyList3.countParallelEdges(new Edge(0,1)));
		assertEquals (1,adjacencyList3.countParallelEdges(new Edge(1,2)));
		
	}
	
//	@Test
//	public void testContractEdge2() {
//		adjacencyList2.contract(new Edge(0,2));
//		assertEquals (2,adjacencyList2.countParallelEdges(new Edge(0,1)));
//		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(1,1)));
//		assertEquals (0,adjacencyList2.countParallelEdges(new Edge(0,0)));
//	}
//	@Test
//	public void testContractEdge3() {
//		adjacencyList3.contract(new Edge(0,2));
//		assertEquals (2,adjacencyList3.countParallelEdges(new Edge(0,1)));
//		assertEquals (0,adjacencyList3.countParallelEdges(new Edge(1,1)));
//		assertEquals (0,adjacencyList3.countParallelEdges(new Edge(0,0)));
//	}

}
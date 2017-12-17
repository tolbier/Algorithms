package com.tolbier.algorithms.course2.week1.bfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;



public class BFSTest {
	BFS bfs;
	AdjacencyList adjacencyList;

	@Before
	public void init() {
		bfs = new BFS();
		adjacencyList = new AdjacencyList();
		adjacencyList.addVertex(0);
		adjacencyList.addEdge(0, 1);
		adjacencyList.addEdge(0, 2);
		adjacencyList.addVertex(1);
		adjacencyList.addEdge(1, 0);
		adjacencyList.addEdge(1, 3);
		adjacencyList.addVertex(2);
		adjacencyList.addEdge(2, 0);
		adjacencyList.addEdge(2, 3);
		adjacencyList.addEdge(2, 4);
		adjacencyList.addVertex(3);
		adjacencyList.addEdge(3, 1);
		adjacencyList.addEdge(3, 2);
		adjacencyList.addEdge(3, 4);
		adjacencyList.addEdge(3, 5);
		adjacencyList.addVertex(4);
		adjacencyList.addEdge(4, 2);
		adjacencyList.addEdge(4, 3);
		adjacencyList.addEdge(4, 5);
		adjacencyList.addVertex(5);
		adjacencyList.addEdge(5, 3);
		adjacencyList.addEdge(5, 4);
		adjacencyList.addVertex(6);
	}

	@Test
	public void testCreateBFS() {
		assertNotNull(bfs);
	}

	@Test
	public void testBFSsearchSShortestPath() {
		;
		assertEquals("[0, 1, 2, 3, 4, 5]", bfs.connectedNodes(adjacencyList,0,5).toString());
	}
	// @Test
	// public void testCreateEdge2() {
	// edge = new Edge(1,1);
	// assertNotNull(edge);
	// edge.setTail(3);
	// edge.setHead(2);
	//
	// assertEquals(3, edge.getTail());
	// assertEquals(2, edge.getHead());
	// }
	// @Test
	// public void testSetVertices() {
	// edge = new Edge(1,1);
	// edge.setVertices(4, 5);
	// assertNotNull(edge);
	// assertEquals(4, edge.getTail());
	// assertEquals(5, edge.getHead());
	//
	// }

}

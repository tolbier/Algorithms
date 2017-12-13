package com.tolbier.algorithms.week4.kargerMinCut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class AdjacencyListTest {
	AdjacencyList adjacencyList;

	@Before
	public void init() {
		 adjacencyList = new AdjacencyList();
	}	
	@Test
	public void testCreateAdjacencyList() {
		 assertNotNull(adjacencyList);
	}
	
	@Test
	public void testAddVertices() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(1);
		assertEquals(1,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(2);
		adjacencyList.createVertex(3);
		adjacencyList.createVertex(4);
		assertEquals(4,adjacencyList.getNumberOfVertices());

	}
	@Test
	public void testAddEdges() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.createVertex(1);
		adjacencyList.addEdge(1,2);
		List<Integer> edgesFromVertex = adjacencyList.getEdgesFromVertex(1);
		assertEquals(1,edgesFromVertex.size());
//		adjacencyList.createVertex(2);
//		adjacencyList.createVertex(3);
//		adjacencyList.createVertex(4);
//		assertEquals(4,adjacencyList.getNumberOfVertices());

	}	
	//public void addEdge(int startVertex, int endVertex, int weight) {

}
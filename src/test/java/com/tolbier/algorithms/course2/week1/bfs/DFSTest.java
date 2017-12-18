package com.tolbier.algorithms.course2.week1.bfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class DFSTest {
	DFS dfs;
	AdjacencyList adjacencyList,adjacencyList2;

	@Before
	public void init() {
		
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
		
		adjacencyList2 = new AdjacencyList();
		adjacencyList2.addVertex(0);
		adjacencyList2.addEdge(0, 1);
		adjacencyList2.addEdge(0, 2);
		adjacencyList2.addVertex(1);

		adjacencyList2.addEdge(1, 3);
		adjacencyList2.addVertex(2);
		adjacencyList2.addEdge(2, 3);
		adjacencyList2.addEdge(2, 4);
		adjacencyList2.addVertex(3);
		adjacencyList2.addEdge(3, 4);
		adjacencyList2.addEdge(3, 5);
		adjacencyList2.addVertex(4);
		adjacencyList2.addEdge(4, 5);
		adjacencyList2.addVertex(5);

		dfs = new DFS();
	}

	@Test
	public void testCreateDFS() {
		assertNotNull(dfs);
	}

	@Test
	public void testDFSsearch() {
		assertEquals("[0, 1, 3, 2, 4, 5]", dfs.dfs(adjacencyList, 0).toString());
	}
	@Test
	public void testTopologicalSort() {
		assertEquals("{0=1, 1=3, 2=2, 3=4, 4=5, 5=6}", dfs.topologicalSort(adjacencyList2).toString());
	}

}

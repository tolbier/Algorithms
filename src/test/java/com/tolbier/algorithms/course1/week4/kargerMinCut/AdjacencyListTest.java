package com.tolbier.algorithms.course1.week4.kargerMinCut;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.course1.week4.kargerMinCut.AdjacencyList;
import com.tolbier.algorithms.course1.week4.kargerMinCut.Cut;
import com.tolbier.algorithms.course1.week4.kargerMinCut.Edge;
import com.tolbier.algorithms.course1.week4.kargerMinCut.OrderedEdge;

import junit.framework.Assert;


public class AdjacencyListTest {
	AdjacencyList adjacencyList, adjacencyList1 , adjacencyList2,adjacencyList3;


	@Before
	public void init() {
		adjacencyList = new AdjacencyList();
		
		adjacencyList1 = new AdjacencyList();
		adjacencyList1.addVertex(0);
		adjacencyList1.addEdge(new Edge(0,1));
		adjacencyList1.addEdge(new Edge(0,1));
		adjacencyList1.addVertex(1);
		adjacencyList1.addEdge(new Edge(1,1));
		adjacencyList1.addEdge(new Edge(1,1));
		adjacencyList1.addEdge(new Edge(1,1));
		adjacencyList1.addEdge(new Edge(1,0));
		
		adjacencyList2 = new AdjacencyList();
		adjacencyList2.addVertex(0);
		adjacencyList2.addEdge(new Edge(0,2));
		adjacencyList2.addEdge(new Edge(0,1));
		adjacencyList2.addVertex(1);
		adjacencyList2.addEdge(new Edge(1,0));
		adjacencyList2.addEdge(new Edge(1,1));
		adjacencyList2.addEdge(new Edge(1,2));
		adjacencyList2.addVertex(2);
		adjacencyList2.addEdge(new Edge(2,0));
		adjacencyList2.addEdge(new Edge(2,1));

		adjacencyList3 = new AdjacencyList();
		adjacencyList3.addVertex(0);
		adjacencyList3.addEdge(new Edge(0,2));
		adjacencyList3.addEdge(new Edge(0,2));
		adjacencyList3.addEdge(new Edge(0,1));
		adjacencyList3.addVertex(1);
		adjacencyList3.addEdge(new Edge(1,0));
		adjacencyList3.addEdge(new Edge(1,2));
		adjacencyList3.addVertex(2);
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
		adjacencyList.addVertex(0);
		assertEquals(1,adjacencyList.getNumberOfVertices());
		adjacencyList.addVertex(1);
		adjacencyList.addVertex(2);
		adjacencyList.addVertex(3);
		assertEquals(4,adjacencyList.getNumberOfVertices());

	}
	@Test
	public void testAddEdges() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.addVertex(0);
		adjacencyList.addEdge(new Edge(0,1));
		List<Integer> edgesFromVertex = adjacencyList.getEdgesListFromVertex(0);
		assertEquals(1,edgesFromVertex.size());

	}	
	@Test
	public void testAddDuplicatedEdges() {
		assertEquals(0,adjacencyList.getNumberOfVertices());
		adjacencyList.addVertex(0);
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
	public void testRemoveParallelEdges1() {

		adjacencyList2.removeParallelEdges(new Edge(0,2));
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
	
	
	@Test
	public void testContractEdge2() {
		adjacencyList2.contract(new Edge(0,2));
		assertEquals (2,adjacencyList2.countParallelEdges(new Edge(0,1)));
		assertEquals (1,adjacencyList2.countParallelEdges(new Edge(1,1)));
		assertEquals (0,adjacencyList2.countParallelEdges(new Edge(0,0)));
		assertEquals ("{0=[2], 1=[]}",adjacencyList2.getSuperNodes().toString());
	}
	@Test
	public void testContractEdge3() {
		adjacencyList3.contract(new Edge(0,2));
		assertEquals (2,adjacencyList3.countParallelEdges(new Edge(0,1)));
		assertEquals (0,adjacencyList3.countParallelEdges(new Edge(1,1)));
		assertEquals (0,adjacencyList3.countParallelEdges(new Edge(0,0)));
		assertEquals ("{0=[2], 1=[]}",adjacencyList3.getSuperNodes().toString());
	}

	@Test
	public void testMinimumCut4() {
		AdjacencyList adjacencyList =createAdjacencyListForMinimumCut();
		Cut minimumCut=new Cut();
		for(int i = 0 ;i<adjacencyList.getNumberOfEdges();i++) {
			Cut cut = Cut.minimumCut(adjacencyList);
			if (cut.getNumberOfEdges()<minimumCut.getNumberOfEdges()) {
				minimumCut=cut;
			}
			adjacencyList =createAdjacencyListForMinimumCut();
		}
		
		assertEquals (2,minimumCut.getNumberOfEdges());
	}
	
	private AdjacencyList createAdjacencyListForMinimumCut() {
		AdjacencyList adjacencyList = new AdjacencyList();
		adjacencyList.addVertex(0);
		adjacencyList.addEdge(new Edge(0,1));
		adjacencyList.addEdge(new Edge(0,2));
		adjacencyList.addEdge(new Edge(0,3));
		adjacencyList.addEdge(new Edge(0,4));
		adjacencyList.addVertex(1);
		adjacencyList.addEdge(new Edge(1,0));
		adjacencyList.addEdge(new Edge(1,2));
		adjacencyList.addEdge(new Edge(1,3));
		adjacencyList.addEdge(new Edge(1,4));
		adjacencyList.addVertex(2);
		adjacencyList.addEdge(new Edge(2,0));
		adjacencyList.addEdge(new Edge(2,1));
		adjacencyList.addEdge(new Edge(2,3));
		adjacencyList.addVertex(3);
		adjacencyList.addEdge(new Edge(3,0));
		adjacencyList.addEdge(new Edge(3,1));
		adjacencyList.addEdge(new Edge(3,2));
		adjacencyList.addVertex(4);
		adjacencyList.addEdge(new Edge(4,0));
		adjacencyList.addEdge(new Edge(4,1));
		return adjacencyList;
		
	}

}
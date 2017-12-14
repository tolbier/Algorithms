package com.tolbier.algorithms.week4.kargerMinCut;

import java.util.Set;

public class Cut {
	private int numberOfEdges;
	private Set<Integer> supernodeA,supernodeB;
	
	public Cut() {
		super();
		this.numberOfEdges = Integer.MAX_VALUE;
		
	}
	public Cut(int numberOfEdges, Set<Integer> supernodeA, Set<Integer> supernodeB) {
		super();
		this.numberOfEdges = numberOfEdges;
		this.supernodeA = supernodeA;
		this.supernodeB = supernodeB;
	}
	public int getNumberOfEdges() {
		return numberOfEdges;
	}
	public Set<Integer> getSupernodeA() {
		return supernodeA;
	}
	public Set<Integer> getSupernodeB() {
		return supernodeB;
	}
	

	public static Cut minimumCut(AdjacencyList adjacencyList) {
		while (adjacencyList.getNumberOfVertices()!=2) {
			Edge edge = adjacencyList.getRandomEdge();
			adjacencyList.contract(edge);
		}
		return minimumCutFromTwoNodeAdjacencyList(adjacencyList);
	}
	private static Cut minimumCutFromTwoNodeAdjacencyList(AdjacencyList adjacencyList) {
		int nodeA = adjacencyList.getNode(0);
		int nodeB= adjacencyList.getNode(1);
		int numberOfEdges = Math.min(
				adjacencyList.getNumberOfEdges(nodeA),
				adjacencyList.getNumberOfEdges(nodeB));
		//adjacencyList.
		Cut cut = new Cut(
				numberOfEdges,
				adjacencyList.getSuperNodes().get(nodeA),
				adjacencyList.getSuperNodes().get(nodeB));
		return cut;
	}
	
}

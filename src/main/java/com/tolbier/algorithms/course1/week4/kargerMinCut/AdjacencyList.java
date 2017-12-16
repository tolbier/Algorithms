package com.tolbier.algorithms.course1.week4.kargerMinCut;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/* The file contains the adjacency list representation of a simple undirected graph. 
 * There are 200 vertices labeled 1 to 200. The first column in the file represents 
 * the vertex label, and the particular row (other entries except the first column)
 * tells all the vertices that the vertex is adjacent to. So for example, the 6th 
 * row looks like : "6	155	56	52	120	......". This just means that the vertex 
 * with label 6 is adjacent to (i.e., shares an edge with) the vertices with labels 
 * 155,56,52,120,......,etc
 * 
 * Your task is to code up and run the randomized contraction algorithm for the 
 * min cut problem and use it on the above graph to compute the min cut. 
 * (HINT: Note that you'll have to figure out an implementation of edge contractions. 
 * Initially, you might want to do this naively, creating a new graph from the old 
 * every time there's an edge contraction. But you should also think about more 
 * efficient implementations.) (WARNING: As per the video lectures, please make sure 
 * to run the algorithm many times with different random seeds, and remember the 
 * smallest cut that you ever find.) Write your numeric answer in the space provided. 
 * So e.g., if your answer is 5, just type 5 in the space provided.
*/
import java.util.concurrent.ThreadLocalRandom;

import com.tolbier.algorithms.course1.week4.kargerMinCut.exceptions.AdjacencyException;
import com.tolbier.algorithms.course1.week4.kargerMinCut.exceptions.AdjacencyIndexOutOfBoundsException;
import com.tolbier.algorithms.course1.week4.kargerMinCut.exceptions.AdjacencyVertexNotFoundException;

public class AdjacencyList {
	private final Map<Integer,List<Integer>> verticesMap;
	private final Map<Integer,Set<Integer>> superNodes;
	
	
	public AdjacencyList() {
		verticesMap = new HashMap<Integer,List<Integer>>();
		superNodes = new HashMap<Integer,Set<Integer>>();
	}
	
	public AdjacencyList(Map<Integer, List<Integer>> verticesMap, Map<Integer, Set<Integer>> superNodes) {
		super();
		this.verticesMap = verticesMap;
		this.superNodes = superNodes;
	}

	private AdjacencyList(AdjacencyList adjacencyList) {
		
		verticesMap =  (Map<Integer, List<Integer>>) ((HashMap<Integer,List<Integer>>) adjacencyList.verticesMap).clone();
		superNodes = (Map<Integer, Set<Integer>>) ((HashMap<Integer,Set<Integer>>) adjacencyList.superNodes).clone();
	}
	public AdjacencyList clone() {
	return new AdjacencyList(this);
		
	}
	public void createVertex(int vertex) {
		verticesMap.put(vertex, new LinkedList<Integer>());
		superNodes.put(vertex, new HashSet<Integer>());
	}
	public void addEdge(Edge edge) {
		verticesMap.get(edge.getTail()).add(edge.getHead());
	}

	int getNumberOfVertices() {
		return verticesMap.size();
	}


	List<Integer> getEdgesListFromVertex(int vertex) {
		return verticesMap.get(vertex);
	}

	Map<Integer,Set<Integer>> getSuperNodes() {
		return superNodes;
	}

	int getNumberOfEdges() {
		int numberOfEdges = 0;
		for (List<Integer> vertexList : verticesMap.values()) {
			numberOfEdges += vertexList.size();
		}
		return numberOfEdges;
	}

	int getNumberOfEdges(int vertex) {
		return verticesMap.get(vertex).size();
	}
	
	boolean edgeExists(Edge edge) {
		if (!(vertexExists(edge.getTail()) && vertexExists(edge.getHead())))
			return false;
		try {
			return verticesMap.get(edge.getTail()).contains(edge.getHead());
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	boolean edgeExists(OrderedEdge orderedEdge) {
		try {
			return getOrderedEdge(
					orderedEdge.getTail(),
					orderedEdge.getOrder()).equals(orderedEdge);
		}catch (AdjacencyException e){
			return false;
		}
	}

	boolean vertexExists(int vertex) {
		return vertex >= 0 && vertex < verticesMap.size();
	}

	OrderedEdge getRandomEdge() {
		int numberOfEdges = getNumberOfEdges();
		int orderToSearch = ThreadLocalRandom.current().nextInt(0,numberOfEdges);
		return getEdgeFromTotalOrder(orderToSearch);
	}

	OrderedEdge getEdgeFromTotalOrder(int order) {
		int numberOfEdgesInVertex;
		int vertex=0;
		for (Integer vertexInteger: verticesMap.keySet()) {
			vertex= vertexInteger.intValue();
			numberOfEdgesInVertex =  getNumberOfEdges(vertex);
			if (numberOfEdgesInVertex > order) break;
			order-=numberOfEdgesInVertex;
			
		}
		
		return new OrderedEdge(vertex,
				getEdgesListFromVertex(vertex).get(order),
				order);
	}
	private OrderedEdge getOrderedEdge(int tail,int order)throws AdjacencyException{
		int head ;
		try {

			List<Integer> vertexList=	verticesMap.get(tail);
			if (vertexList==null) throw new  AdjacencyVertexNotFoundException();
			head = verticesMap.get(tail).get(order).intValue();
		}catch (IndexOutOfBoundsException e) {
			throw new AdjacencyIndexOutOfBoundsException();
		}
		return new OrderedEdge(tail, head, order);
	}

	@Override
	public String toString() {
		return "AdjacencyList [\nverticesMap=" + verticesMap + ",\nsuperNodes=" + superNodes + "\n]";
	}

	void removeParallelEdges(Edge edge) {
		removeEdgesFomList(edge.getTail(),edge.getHead());
		removeEdgesFomList(edge.getHead(),edge.getTail());
		
	}
	void removeEdgesFomList(int tail, int head) {
		List<Integer> edgesList = verticesMap.get(tail);
		edgesList.removeAll(Arrays.asList(new Integer[] {head}));
	}

	int countParallelEdges(Edge edge) {
		int count = 0;
		List<Integer> edgesList = verticesMap.get(edge.getTail());
		if (edgesList==null) return 0;

		for (Integer head : edgesList) {
			if (head==edge.getHead()) count ++;
		}
		return count;
	}

	void contract(Edge edge) {
		removeParallelEdges(edge);
		moveEdgesByTails(edge);
		moveEdgesByHeads(edge);
		addHeadToSuperNodesOfTail(edge);
		
	}

	private void addHeadToSuperNodesOfTail(Edge edge) {
		Set<Integer> superNodeHead = superNodes.get(edge.getHead());
		superNodes.get(edge.getTail()).add(edge.getHead());
		superNodes.get(edge.getTail()).
			addAll(superNodeHead);
		superNodes.remove(edge.getHead(),superNodeHead);
		
	}

	void moveEdgesByTails(Edge edge) {
		verticesMap.get(edge.getTail()).addAll(
				verticesMap.get(edge.getHead()));
		verticesMap.remove(edge.getHead());
	}
	void moveEdgesByHeads(Edge edge) {
		for (List<Integer> vertexList: verticesMap.values()) {
			if (vertexList!=null){
				Collections.replaceAll(vertexList,edge.getHead(),edge.getTail());
			}
		}
	}

	public int getNode(int i) {
		Integer[] arr=  new Integer[2] ;
		verticesMap.keySet().toArray(arr);
		return arr[i];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((superNodes == null) ? 0 : superNodes.hashCode());
		result = prime * result + ((verticesMap == null) ? 0 : verticesMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdjacencyList other = (AdjacencyList) obj;
		if (superNodes == null) {
			if (other.superNodes != null)
				return false;
		} else if (!superNodes.equals(other.superNodes))
			return false;
		if (verticesMap == null) {
			if (other.verticesMap != null)
				return false;
		} else if (!verticesMap.equals(other.verticesMap))
			return false;
		return true;
	}
	
	

}
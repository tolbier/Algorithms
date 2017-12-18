package com.tolbier.algorithms.course2.week1.bfs;

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
	public void addVertex(int vertex) {
		verticesMap.put(vertex, new LinkedList<Integer>());
		superNodes.put(vertex, new HashSet<Integer>());
	}
	
	public void addEdge(int tail, int head) {
		verticesMap.get(tail).add(head);
	}

	int getNumberOfVertices() {
		return verticesMap.size();
	}


	public List<Integer> getEdgesListFromVertex(int vertex) {
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
	
	

	boolean vertexExists(int vertex) {
		return vertex >= 0 && vertex < verticesMap.size();
	}



	@Override
	public String toString() {
		return "AdjacencyList [\nverticesMap=" + verticesMap + ",\nsuperNodes=" + superNodes + "\n]";
	}


	void removeEdgesFomList(int tail, int head) {
		List<Integer> edgesList = verticesMap.get(tail);
		edgesList.removeAll(Arrays.asList(new Integer[] {head}));
	}




	public int getNode(int i) {

		Set<Integer> keySet =verticesMap.keySet();
		Integer[] arr=  new Integer[keySet.size()] ;
		keySet.toArray(arr);
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
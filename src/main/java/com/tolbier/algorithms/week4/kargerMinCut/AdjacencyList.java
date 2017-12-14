package com.tolbier.algorithms.week4.kargerMinCut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class AdjacencyList {
	private final List<List<Integer>> verticesList;
	private final List<Set<Integer>> superNodes;
	private Random rn = new Random();
	
	public AdjacencyList() {
		verticesList = new ArrayList<List<Integer>>();
		superNodes = new ArrayList<Set<Integer>>();
	}

	public void createVertex(int vertex) {
		verticesList.add(vertex, new LinkedList<Integer>());
	}

	public int getNumberOfVertices() {
		return verticesList.size();
	}

	public void addEdge(Edge edge) {
		verticesList.get(edge.getTailVertex()).add(edge.getHeadVertex());
	}

	public List<Integer> getEdgesFromVertex(int vertex) {
		return verticesList.get(vertex);
	}

	protected List<Set<Integer>> getSuperNodes() {
		return superNodes;
	}

	public int getNumberOfEdges() {
		int numberOfEdges = 0;
		for (List<Integer> vertexList : verticesList) {
			numberOfEdges += vertexList.size();
		}
		return numberOfEdges;
	}

	public int getNumberOfEdges(int vertex) {
		return verticesList.get(vertex).size();
	}

	public boolean edgeExists(Edge edge) {
		if (!(vertexExists(edge.getTailVertex()) && vertexExists(edge.getHeadVertex())))
			return false;
		try {
			return verticesList.get(edge.getTailVertex()).get(edge.getOrder()).intValue() == edge.getHeadVertex();
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private boolean vertexExists(int vertex) {
		return vertex >= 0 && vertex < verticesList.size();
	}

	public Edge getRandomEdge() {
		int numberOfEdges = getNumberOfEdges();
		int orderToSearch = rn.nextInt(numberOfEdges);
		return getEdgeFromOrder(orderToSearch);

	}

	Edge getEdgeFromOrder(int order) {
		int vertex=0;
		int numberOfEdgesInVertex;
		while ( (numberOfEdgesInVertex =  getNumberOfEdges(vertex))<= order ) {
			order-=numberOfEdgesInVertex;
			vertex++;
		}
		
		
		return new Edge(vertex,
				getEdgesFromVertex(vertex).get(order),
				order);
	}
}
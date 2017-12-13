package com.tolbier.algorithms.week4.kargerMinCut;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	private final List<List<Integer>> adjacencyList;

	public AdjacencyList() {
		adjacencyList =  new ArrayList<List<Integer>>();
	}

	public void createVertex(int vertex) {
		adjacencyList.add(vertex-1,new LinkedList<Integer>());
	}

	public int getNumberOfVertices() {
		return adjacencyList.size();
	}

	public void addEdge(int tailVertex, int headVertex) {
		adjacencyList.get(tailVertex-1).add(headVertex);
		
	}

	public List<Integer> getEdgesFromVertex(int vertex) {
		return adjacencyList.get(vertex-1);
	}
	
}
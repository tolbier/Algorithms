package com.tolbier.algorithms.course2.week1.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class DFS {
	AdjacencyList adjacencyList;
	List<Integer> explored;


	public DFS() {
		super();
		explored= new ArrayList<Integer> ();
	}
	public Stack<Integer> dfs(AdjacencyList adjacencyList,int start) {
		Stack<Integer> stck = new Stack<Integer>();
		stck.add(start);
		
		explored.add(start);
		List<Integer> endsList= adjacencyList.getEdgesListFromVertex(start);
		for (Integer end:endsList) {
			if (!isExplored(end)) {
				stck.addAll(dfs(adjacencyList,end));
			}
		}
		return stck;
	}
	void addNode(int node) {
		explored.add(node);
	}
	private boolean isExplored(int v) {
		return explored.contains(v);
	}

}

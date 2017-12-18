package com.tolbier.algorithms.course2.week1.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class DFS {
	AdjacencyList adjacencyList;
	List<Integer> explored;
	
	int currentTopologicalLabel;

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
	public Map<Integer,Integer> topologicalSort(AdjacencyList adjacencyList) {
		int n = adjacencyList.getNumberOfVertices();
		Map<Integer,Integer> topologicalMap=new HashMap<Integer,Integer>();
		currentTopologicalLabel=n;
		for (int i =0;i<n;i++) {
			int v = adjacencyList.getNode(i);
				if (!isExplored(v)) {
					topologicalSortDFS(adjacencyList, v,topologicalMap);
				}
		}
		return topologicalMap;
	}
	private void topologicalSortDFS(
			AdjacencyList adjacencyList,
			int s,
			Map<Integer,Integer> topologicalMap) {
		for (int v: adjacencyList.getEdgesListFromVertex(s)) {
			if (!isExplored(v)) {
				addNode(v);
				topologicalSortDFS(adjacencyList,v,topologicalMap);
			}
		}
		topologicalMap.put(s, currentTopologicalLabel--);
	}

}

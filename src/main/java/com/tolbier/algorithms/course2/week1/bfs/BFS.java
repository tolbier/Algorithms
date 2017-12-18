package com.tolbier.algorithms.course2.week1.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class BFS {
	AdjacencyList adjacencyList;
	List<Integer> explored;
	Map<Integer,Integer> distances;
	Deque<Integer> q ;
	public BFS() {
		super();

	}


	public List<Integer> shortestPath(AdjacencyList adjacencyList, int start) {
		explored = new ArrayList<Integer>();
		q = new LinkedList<Integer> ();	
		distances= new HashMap<Integer,Integer>();
		distances.put(start, 0);
		addNode(start);
		while (! q.isEmpty()) {
			int v = q.removeLast().intValue();
			List<Integer> connectedNodeList = adjacencyList.getEdgesListFromVertex(v);
			for (Integer w : connectedNodeList) {
				if (!isExplored(w)) {
					distances.put(w, distances.get(v).intValue()+1);
					addNode(w);
				}
			}
		}
		return (List<Integer>)((ArrayList<Integer>)explored).clone();
		
	}
	public List<List<Integer>> getConnectedComponents(AdjacencyList adjacencyList) {
		List<List<Integer>> nodeGroups= new ArrayList<List<Integer>> ();
		explored = new ArrayList<Integer>();
		for (int i = 0; i<adjacencyList.getNumberOfVertices() ; i++) {
			
			if (!explored.contains(i)) {
				nodeGroups.add(bfs(adjacencyList,i));
			}
		}
		return nodeGroups;
		
	}
	public List<Integer> bfs(AdjacencyList adjacencyList,int start) {
		List<Integer> nodeGroup = new ArrayList<Integer>();
		q = new LinkedList<Integer> ();	
		addNode(start,nodeGroup);
		while (! q.isEmpty()) {
			int v = q.removeLast().intValue();
			List<Integer> connectedNodeList = adjacencyList.getEdgesListFromVertex(v);
			for (Integer w : connectedNodeList) {
				if (!isExplored(w)) {
					addNode(w,nodeGroup);
				}
			}
		}
		return nodeGroup;
		
	}
	void addNode(int node,List<Integer> nodeGroup) {
		nodeGroup.add(node);
		addNode(node);
	}
	void addNode(int node) {
		explored.add(node);
		q.add(node);
	}
	private boolean isExplored(int v) {
		return explored.contains(v);
	}


	protected Map<Integer, Integer> getDistances() {
		return distances;
	}

}

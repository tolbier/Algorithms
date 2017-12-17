package com.tolbier.algorithms.course2.week1.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.tolbier.algorithms.course1.week4.kargerMinCut.AdjacencyList;

public class BFS {
	List<Integer> explored;
	
	Deque<Integer> q ;
	public BFS() {
		super();

	}


	public List<Integer> connectedNodes(AdjacencyList adjacencyList, int start, int end) {
		explored = new ArrayList<Integer>();
		q = new LinkedList<Integer> ();	
		addNode(start);
		while (! q.isEmpty()) {
			int v = q.removeLast().intValue();
			List<Integer> connectedNodeList = adjacencyList.getEdgesListFromVertex(v);
			for (Integer connectedNode : connectedNodeList) {
				if (!isExplored(connectedNode)) {
					addNode(connectedNode);
				}
			}
		}
		return (List<Integer>)((ArrayList<Integer>)explored).clone();
		
	}


	void addNode(int node) {
		explored.add(node);
		q.add(node);
	}
	private boolean isExplored(int v) {
		return explored.contains(v);
	}

}

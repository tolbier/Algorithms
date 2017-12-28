package com.tolbier.algorithms.course2.week2.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WeightedGraph {
	private final List<Set<WeightedEdge>> vertices;

	
	
	
	public WeightedGraph() {
		vertices = new LinkedList<Set<WeightedEdge>>();

	}
	
	public int getVerticesSize() {
		return vertices.size();
	}
	public void addWeightedArc(int tail, int head,int weight) {
		if (tail>=vertices.size()) vertices.add(tail, new HashSet<WeightedEdge>());
		vertices.get(tail).add(new WeightedEdge(head, weight));
	}

	@Override
	public String toString() {
		return "[" + vertices.toString() + "]";
	}

	public Set<WeightedEdge> getWeightedArcsSet(int i){
		return vertices.get(i);
	}

}
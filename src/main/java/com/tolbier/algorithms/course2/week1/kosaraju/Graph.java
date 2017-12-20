package com.tolbier.algorithms.course2.week1.kosaraju;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Graph {
	private final Set<Integer>[] vertices;

	
	
	public Graph(int n) {
		vertices = new Set[n];

	}
	
	public void addArc(int tail, int head) {
		if (vertices[tail]==null) vertices[tail]= new HashSet<Integer>();
		vertices[tail].add(head);
	}

	@Override
	public String toString() {
		return "[" + Arrays.toString(vertices) + "]";
	}

	

}
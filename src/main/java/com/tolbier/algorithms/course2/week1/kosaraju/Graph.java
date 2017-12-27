package com.tolbier.algorithms.course2.week1.kosaraju;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Graph {
	private final Set<Integer>[] vertices;

	
	
	
	public Graph(int n) {
		vertices = new Set[n];

	}
	
	public int getVerticesSize() {
		return vertices.length;
	}
	public void addArc(int tail, int head) {
		if (vertices[tail]==null) vertices[tail]= new HashSet<Integer>();
		vertices[tail].add(head);
	}

	@Override
	public String toString() {
		return "[" + Arrays.toString(vertices) + "]";
	}

	public Set<Integer> getArcsSet(int i){
		return vertices[i];
	}
	public Graph reverse() {
		Graph reverse = new Graph(vertices.length);
		for (int i = 0;i < vertices.length;i++ ) {
			for (int j : vertices[i]) {
				reverse.addArc(j, i);
			}
		}
		return reverse;
	}

}
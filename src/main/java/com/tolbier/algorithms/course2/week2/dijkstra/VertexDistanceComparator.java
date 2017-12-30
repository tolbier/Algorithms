package com.tolbier.algorithms.course2.week2.dijkstra;

import java.util.Comparator;
import java.util.Map;

public class VertexDistanceComparator<T> implements Comparator<Vertex<T>> {
	Map<Vertex<T>, Integer> shortestDistances;

	public VertexDistanceComparator(Map<Vertex<T>, Integer> shortestDistances) {
		super();
		this.shortestDistances = shortestDistances;
	}

	@Override
	public int compare(Vertex<T> o1, Vertex<T> o2) {
		Integer d1 = getShortestDistance(o1);
		Integer d2 = getShortestDistance(o2);
		return d2.compareTo(d1) * -1;
	}

	private Integer getShortestDistance(Vertex<T> o) {
		Integer distance = shortestDistances.get(o);
		return distance;
	}
}

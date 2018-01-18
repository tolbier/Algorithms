package com.tolbier.algorithms.course2.week2.dijkstra.minimumBottleNeck;

import java.util.Comparator;
import java.util.Map;

import com.tolbier.algorithms.commons.Vertex;

public class VertexMinimumBottleNeckComparator<T> implements Comparator<Vertex<T>> {
	Map<Vertex<T>, Integer> minimumBottleNeck;

	public VertexMinimumBottleNeckComparator(Map<Vertex<T>, Integer> minimumBottleNeck) {
		super();
		this.minimumBottleNeck = minimumBottleNeck;
	}

	@Override
	public int compare(Vertex<T> o1, Vertex<T> o2) {
		Integer bn1 = getMinimumBottleNeck(o1);
		Integer bn2 = getMinimumBottleNeck(o2);
		return bn2.compareTo(bn1) * -1;
	}

	private Integer getMinimumBottleNeck(Vertex<T> o) {
		Integer bn = minimumBottleNeck.get(o);
		return bn;
	}
}

package com.tolbier.algorithms.course3.week1.edges;

import java.util.Comparator;
import java.util.Map;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Vertex;

public class EdgeCostComparator<T> implements Comparator<Edge<T>> {

	public EdgeCostComparator() {
		super();
	}

	@Override
	public int compare(Edge<T> o1, Edge<T> o2) {
		return  ((Integer)o1.getWeight()).compareTo(o2.getWeight()) ;
	}

}

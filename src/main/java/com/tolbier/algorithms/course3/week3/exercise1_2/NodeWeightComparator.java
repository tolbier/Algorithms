package com.tolbier.algorithms.course3.week3.exercise1_2;

import java.util.Comparator;
import java.util.Map;

import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.commons.Vertex;

public class NodeWeightComparator<T extends Comparable<T>> implements Comparator<Node<T>> {
	Map<Vertex<T>, Integer> minimumBottleNeck;

	public NodeWeightComparator() {
		super();
	}

	@Override
	public int compare(Node<T> o1, Node<T> o2) {
		return o1.getData().compareTo(o2.getData());
	}



	
}

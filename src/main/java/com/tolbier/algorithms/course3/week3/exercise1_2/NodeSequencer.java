package com.tolbier.algorithms.course3.week3.exercise1_2;

import java.util.Iterator;

public class NodeSequencer implements Iterator<Integer> {

	private int idx;

	@Override
	public boolean hasNext() {
		return idx<Integer.MAX_VALUE;
	}

	@Override
	public Integer next() {
		return idx++;
	}

}
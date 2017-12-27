package com.tolbier.algorithms.course2.week1.kosaraju.utils;

import java.util.Iterator;

public class ReverseSequenceIntegerIterator implements Iterator<Integer>{
	int n;
	int i;
	public ReverseSequenceIntegerIterator(int n) {
		super();
		this.n = n;
		i=n-1;
	}

	@Override
	public boolean hasNext() {
		return i>=0;
	}

	@Override
	public Integer next() {
		return i--;
	}

}

package com.tolbier.algorithms.course3.week2.kCluster2;

import java.util.Iterator;

public abstract class VariationFactory {
	int nBits;

	public  VariationFactory(int nBits) {
		super();
		this.nBits = nBits;
	}
	public abstract Iterator<Integer> getIterator(int number);
	
}

package com.tolbier.algorithms.course3.week2.kCluster2;

import java.util.Iterator;

public class OneBitVariationFactory extends VariationFactory {

	public OneBitVariationFactory(int nBits) {
		super(nBits);
	}

	public Iterator<Integer> getIterator(int number){
		return new OneBitVariationIterator(number, nBits);
	}
}

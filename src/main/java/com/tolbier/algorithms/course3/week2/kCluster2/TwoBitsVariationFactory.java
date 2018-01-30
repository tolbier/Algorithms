package com.tolbier.algorithms.course3.week2.kCluster2;

import java.util.Iterator;

public class TwoBitsVariationFactory extends VariationFactory{

	public TwoBitsVariationFactory(int nBits) {
		super(nBits);
	}

	public Iterator<Integer> getIterator(int number){
		return new TwoBitsVariationIterator(number, nBits);
	}
}

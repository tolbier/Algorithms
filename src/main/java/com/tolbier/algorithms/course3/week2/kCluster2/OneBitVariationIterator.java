package com.tolbier.algorithms.course3.week2.kCluster2;

import java.util.Iterator;

public class OneBitVariationIterator extends AbstractVariationIterator implements Iterator<Integer>{
	int i;
	public OneBitVariationIterator(int number,int nBits) {
		super(number,nBits);
		i=0;
	}
	@Override
	public boolean hasNext() {
		return i<nBits;
	}

	@Override
	public Integer next() {
		mask=1<<i;
		i++;
		return getMaskedNumber();
	}

}

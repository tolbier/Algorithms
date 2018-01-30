package com.tolbier.algorithms.course3.week2.kCluster2;

import java.util.Iterator;

public class TwoBitsVariationIterator extends AbstractVariationIterator implements Iterator<Integer>{
	int i,j;
	public TwoBitsVariationIterator(int number,int nBits) {
		super(number,nBits);
		i=0; j=1;
	}

	@Override
	public boolean hasNext() {
		return i<nBits-1;
	}

	@Override
	public Integer next() {
		mask=(1 << i) | (1 << j);
		j++;
		if (j==nBits) {
			i++;
			j=i+1;
		}
		return getMaskedNumber();
	}

}

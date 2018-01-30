package com.tolbier.algorithms.course3.week2.kCluster2;

public abstract class AbstractVariationIterator {

	protected int number;
	 
	protected int nBits;
    protected int mask;
	public AbstractVariationIterator(int number,int nBits) {
		super();
		this.number = number;
		this.nBits=nBits;
	}

	int getMaskedNumber() {
		return number ^ mask;
	}


}
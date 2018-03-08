package com.tolbier.algorithms.course4.week2;

import java.util.Iterator;

import com.tolbier.algorithms.course4.week2.exceptions.BinaryIteratorException;
import com.tolbier.algorithms.course4.week2.exceptions.MgreaterThanNException;
import com.tolbier.algorithms.course4.week2.exceptions.SIteratorException;

public class SIterator implements Iterator<Integer> {
	int n;
	int m;
	Iterator<Integer> binaryIterator;

	public SIterator(int n, int m) throws SIteratorException {
		super();
		this.n = n;
		this.m = m;
		if (m > n)
			throw new MgreaterThanNException();

		try {
			binaryIterator = new BinaryIterator(n - 1, m - 1);
		} catch (BinaryIteratorException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean hasNext() {
		return this.binaryIterator.hasNext();
	}

	@Override
	public Integer next() {
		return (binaryIterator.next() << 1) | 1;
	}

}

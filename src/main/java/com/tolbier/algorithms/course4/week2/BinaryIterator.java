package com.tolbier.algorithms.course4.week2;

import java.util.Iterator;

import com.tolbier.algorithms.course4.week2.exceptions.BinaryIteratorException;
import com.tolbier.algorithms.course4.week2.exceptions.KgreaterThanNException;

public class BinaryIterator implements Iterator<Integer>{

	int n ;
	int k ; 
	int nextItem;
	
	public BinaryIterator(int n,int k) throws BinaryIteratorException {
		super();
		if (k>n) throw new KgreaterThanNException();
		this.n = n;
		this.k = k;
		
		nextItem=0;
		for (int i =1;i<=k;i++) {
			nextItem=(nextItem <<1)| 1;
		}
	}
	@Override
	public boolean hasNext() {
		return log2(nextItem)<=n;
	}

	@Override
	public Integer next() {
		int result = nextItem;
		
		nextItem = nextPermutation(nextItem);
		return result;
	}
	  /**
	   * from https://github.com/Waxolunist/bittwiddling/blob/master/src/main/java/com/vcollaborate/bitwise/BinaryUtils.java
	   * 
	   * Compute the lexicographically next bit permutation.
	   * 
	   * Suppose we have a pattern of N bits set to 1 in an integer and we want the next permutation of
	   * N 1 bits in a lexicographical sense. For example, if N is 3 and the bit pattern is 00010011,
	   * the next patterns would be 00010101, 00010110, 00011001,00011010, 00011100, 00100011, and so
	   * forth.
	   */
	  public static final int nextPermutation(int val) {
	    int tmp = val | (val - 1);
	    return (tmp + 1) | (((-tmp & -~tmp) - 1) >> (Integer.numberOfTrailingZeros(val) + 1));
	  }
	  public static final int log2(int value) {
		    return Integer.SIZE-Integer.numberOfLeadingZeros(value);
	  }
}

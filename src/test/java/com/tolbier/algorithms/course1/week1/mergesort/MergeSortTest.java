package com.tolbier.algorithms.course1.week1.mergesort;


import org.junit.Test;
import org.junit.Assert;

public class MergeSortTest {
	@Test
	public void testMergeSort() {
		
		Assert.assertArrayEquals(new int[] {1,2,3,4,5,6,7,8},MergeSort.sort(new int[] {4,6,3,8,2,1,5,7}));
	}
	

}

package com.tolbier.algorithms.course1.week3.quicksort.utils;


import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.tolbier.algorithms.course1.week3.quicksort.utils.Util;

public class UtilTest{
	@Test
	public void testSwap() {
		int a[] =new int [] {1,2};
		Util.swap(a,0,1);
		assertArrayEquals(new int[] {2,1},a);
	}

}
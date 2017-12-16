package com.tolbier.algorithms.course1.week3.quicksort.choosepivot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotMedianStrategy;

public class ChoosePivotMedianStrategyTest{
	ChoosePivotMedianStrategy choosePivotStrategy;
	@Before
	public void init() {
		choosePivotStrategy = new ChoosePivotMedianStrategy();
		
	}
	@Test
	public void testChoosePivotMedian() {
		assertEquals(3, choosePivotStrategy.choosePivot(new int[] {1,3,4,7,9,10,2,5,6,8},3,6));
		assertEquals(1, choosePivotStrategy.choosePivot(new int[] {1,2,3,4},0,3));
		assertEquals(3, choosePivotStrategy.choosePivot(new int[] {1,3,4,2},0,3));
		assertEquals(0, choosePivotStrategy.choosePivot(new int[] {2,1,3,4},0,3));
		assertEquals(5, choosePivotStrategy.choosePivot(new int[] {6, 3, 4, 1, 2, 5, 7, 8},0,5));

	} 
	

	@Test
	public void testGetMiddle() {
		int middle= choosePivotStrategy.getMiddle(0, 9999);
		assertEquals(4999,middle);
	}	
	@Test
	public void testGetMiddle2() {
		int middle= choosePivotStrategy.getMiddle(0, 4);
		assertEquals(2,middle);
	}	
	@Test
	public void testGetMiddle3() {
		int middle= choosePivotStrategy.getMiddle(0, 3);
		assertEquals(1,middle);
	}	
	@Test
	public void testGetMiddle4() {
		int middle= choosePivotStrategy.getMiddle(3, 6);
		assertEquals(4,middle);
	}	
	


}

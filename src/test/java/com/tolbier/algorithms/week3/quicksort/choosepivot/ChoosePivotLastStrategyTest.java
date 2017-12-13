package com.tolbier.algorithms.week3.quicksort.choosepivot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChoosePivotLastStrategyTest{
	@Test
	public void testChoosePivotLast() {
		ChoosePivotStrategy choosePivotStrategy = new ChoosePivotLastStrategy();
		assertEquals(6, choosePivotStrategy.choosePivot(new int[] {1,3,4,7,9,10,2,5,6,8},3,6));
	} 

}
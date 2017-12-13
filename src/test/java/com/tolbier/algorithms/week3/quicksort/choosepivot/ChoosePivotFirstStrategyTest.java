package com.tolbier.algorithms.week3.quicksort.choosepivot;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChoosePivotFirstStrategyTest{
	@Test
	public void testChoosePivotFirst() {
		ChoosePivotStrategy choosePivotStrategy = new ChoosePivotFirstStrategy();
		assertEquals(3, choosePivotStrategy.choosePivot(new int[] {1,3,4,7,9,10,2,5,6,8},3,6));
	} 

}
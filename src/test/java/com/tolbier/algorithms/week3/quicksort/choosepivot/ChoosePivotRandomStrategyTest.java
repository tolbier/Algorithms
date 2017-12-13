package com.tolbier.algorithms.week3.quicksort.choosepivot;

import java.util.Random;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChoosePivotRandomStrategyTest{
	@Test
	public void testChoosePivotRandom1() {
		ChoosePivotStrategy choosePivotStrategy = new ChoosePivotRandomStrategy();
		for (int i = 0; i <10000;i++) {
			int a =  choosePivotStrategy.choosePivot(new int[] {1,2,3,4},0,3);
			assertTrue(a>=0 && a <=3);
		}


	} 
	@Test
	public void testChoosePivotRandom2() {
		ChoosePivotStrategy choosePivotStrategy = new ChoosePivotRandomStrategy();
		for (int i = 0; i <10000;i++) {
			int a =  choosePivotStrategy.choosePivot(new int[] {1,2,3,4,5,6},2,5);
			assertTrue(a>=2 && a <=5);
		}


	} 	 
}

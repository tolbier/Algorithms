package com.tolbier.algorithms.course1.week4.rselect;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotFirstStrategy;
import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotLastStrategy;
import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotMedianStrategy;
import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotRandomStrategy;
import com.tolbier.algorithms.course1.week4.rselect.RSelect;


public class RSelectTest {
	RSelect rSelect;

	@Test
	public void testFirstPivot() {
		rSelect = new RSelect(new ChoosePivotFirstStrategy());
		doTheTests();
	}	
	@Test
	public void testLastPivot() {
		rSelect = new RSelect(new ChoosePivotLastStrategy());
		doTheTests();
	}	
	@Test
	public void testMedianPivot() {
		rSelect = new RSelect(new ChoosePivotMedianStrategy());
		doTheTests();
	}	
	@Test
	public void testRandomPivot() {
		rSelect = new RSelect(new ChoosePivotRandomStrategy());
		doTheTests();
	}	
	private void doTheTests() {
		testQuickSort8();
		testQuickSort8repeated();
		testQuickSort8allRepeatedButOne();

		testQuickSort8allRepeatedButOne2();
		testQuickSort3twoRepeated();
		testQuickSort10();

	}
	
	
	private void testQuickSort8() {
		assertEquals(4, rSelect.rSelect(new int[] {1,3,4,7,2,5,6,8},3));

	}
	private void testQuickSort8repeated() {
		assertEquals(3, rSelect.rSelect(new int[] {1,3,6,7,3,5,6,8},2));

	}
	private void testQuickSort8allRepeatedButOne() {
		assertEquals(3, rSelect.rSelect(new int[] {3,3,3,6,3,3,3,3},2));
		assertEquals(6, rSelect.rSelect(new int[] {3,3,3,6,3,3,3,3},7));

	}
	private void testQuickSort8allRepeatedButOne2() {
		assertEquals(3, rSelect.rSelect(new int[] {6,3,3,3,3,3,3,3},2));
		assertEquals(6, rSelect.rSelect(new int[] {6,3,3,3,3,3,3,3},7));


	}
	private void testQuickSort3twoRepeated() {
		assertEquals(1, rSelect.rSelect(new int[] {2,1,2},0));
		assertEquals(2, rSelect.rSelect(new int[] {2,1,2},1));
		assertEquals(1, rSelect.rSelect(new int[] {2,1,2},0));


	}
	private void testQuickSort10() {
		assertEquals(8, rSelect.rSelect(new int[] {1,3,4,7,9,10,2,5,6,8},7));
	} 
	
	
	
	

}
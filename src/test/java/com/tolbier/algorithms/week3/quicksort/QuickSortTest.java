package com.tolbier.algorithms.week3.quicksort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotFirstStrategy;
import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotLastStrategy;
import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotLastStrategyTest;
import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotMedianStrategy;
import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotRandomStrategy;
import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotStrategy;


public class QuickSortTest {
	QuickSort quickSort;

	@Test
	public void testFirstPivot() {
		quickSort = new QuickSort(new ChoosePivotFirstStrategy());
		doTheTests();
	}	
	@Test
	public void testLastPivot() {
		quickSort = new QuickSort(new ChoosePivotLastStrategy());
		doTheTests();
	}	
	@Test
	public void testMedianPivot() {
		quickSort = new QuickSort(new ChoosePivotMedianStrategy());
		doTheTests();
	}	
	@Test
	public void testRandomPivot() {
		quickSort = new QuickSort(new ChoosePivotRandomStrategy());
		doTheTests();
	}	
	private void doTheTests() {
		testQuickSort8();
		testQuickSort8repeated();
		testQuickSort8allRepeatedButOne();

		testQuickSort8allRepeatedButOne2();
		testQuickSort3twoRepeated();
		testQuickSort10();
		testPartition1();
		testPartition2();
		testPartition3();
	}
	
	
	private void testQuickSort8() {
		assertArrayEquals(new int[] {1,2,3,4,5,6,7,8}, quickSort.sort(new int[] {1,3,4,7,2,5,6,8}));

	}
	private void testQuickSort8repeated() {
		assertArrayEquals(new int[] {1,3,3,5,6,6,7,8}, quickSort.sort(new int[] {1,3,6,7,3,5,6,8}));

	}
	private void testQuickSort8allRepeatedButOne() {
		assertArrayEquals(new int[] {3,3,3,3,3,3,3,6}, quickSort.sort(new int[] {3,3,3,6,3,3,3,3}));

	}
	private void testQuickSort8allRepeatedButOne2() {
		assertArrayEquals(new int[] {3,3,3,3,3,3,3,6}, quickSort.sort(new int[] {6,3,3,3,3,3,3,3}));

	}
	private void testQuickSort3twoRepeated() {
		assertArrayEquals(new int[] {1,2,2}, quickSort.sort(new int[] {2,1,2}));
		assertArrayEquals(new int[] {1,2,2}, quickSort.sort(new int[] {1,2,2}));
		assertArrayEquals(new int[] {1,2,2}, quickSort.sort(new int[] {2,2,1}));
		assertArrayEquals(new int[] {1,1,2}, quickSort.sort(new int[] {1,2,1}));
		assertArrayEquals(new int[] {1,1,2}, quickSort.sort(new int[] {1,1,2}));
		assertArrayEquals(new int[] {1,1,2}, quickSort.sort(new int[] {2,1,1}));

	}
	private void testQuickSort10() {
		assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, quickSort.sort(new int[] {1,3,4,7,9,10,2,5,6,8}));
	} 
	
	private void testPartition1() {
		assertEquals(6, quickSort.partition(new int[] {7,3,4,1,9,10,2,5,6,8},0,9));
	} 
	private void testPartition2() {
		assertEquals(1, quickSort.partition(new int[] {2,3,4,1,9,10,7,5,6,8},0,5));
	} 
	private void testPartition3() {
		assertEquals(9, quickSort.partition(new int[] {2,3,4,1,5,6,7,10,8,9},7,9));
	} 
	
	
	

}
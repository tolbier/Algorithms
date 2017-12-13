package com.tolbier.algorithms.week1.secondlargest;

import static org.junit.Assert.*;

import org.junit.Test;



public class SecondLargestTest {
	@Test
	public void testSecondLargest() {
		assertEquals(7, SecondLargest.findSecondLargest( new int[]{2,3,8,4,1,7,5,6}));
		assertEquals(17, SecondLargest.findSecondLargest( new int[]{12,13,18,14,17,11,15,16}));
	}
	@Test
	public void testTwoLargestIn4() {
		assertArrayEquals(new int[] {4,8}, SecondLargest.twoLargestIn4( new int[]{2,3,8,4}));
		assertArrayEquals(new int[] {4,8}, SecondLargest.twoLargestIn4( new int[]{8,3,2,4}));
		assertArrayEquals(new int[] {4,8}, SecondLargest.twoLargestIn4( new int[]{4,3,2,8}));
	}
	@Test
	public void testTwoLargest() {
		assertArrayEquals(new int[] {4,8}, SecondLargest.twoLargest( new int[]{2,3,8,4}));
		assertArrayEquals(new int[] {7,8}, SecondLargest.twoLargest( new int[]{2,3,8,4,1,7,5,6}));
		assertArrayEquals(new int[] {7,8}, SecondLargest.twoLargest( new int[]{2,3,8,7,1,4,5,6}));
		assertArrayEquals(new int[] {7,8}, SecondLargest.twoLargest( new int[]{2,7,8,3,1,4,5,6}));
		assertArrayEquals(new int[] {7,8}, SecondLargest.twoLargest( new int[]{2,3,6,7,1,4,5,8}));
		assertArrayEquals(new int[] {17,18}, SecondLargest.twoLargest( new int[]{12,13,18,14,17,11,15,16}));
		assertArrayEquals(new int[] {17,18}, SecondLargest.twoLargest( new int[]{12,13,18,2,3,6,7,1,4,5,8,14,17,11,15,16}));
	}	
	
	@Test
	public void testConcatArrays() {
		assertArrayEquals(new int[] {2,3,8,4,1,5,6,7}, SecondLargest.concatArrays(
				new int[]{2,3,8,4},
				new int[]{1,5,6,7}
				));
	}	
	
}

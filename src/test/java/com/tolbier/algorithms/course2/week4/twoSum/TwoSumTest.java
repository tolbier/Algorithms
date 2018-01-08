package com.tolbier.algorithms.course2.week4.twoSum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {
	TwoSum twoSum;
	@Before
	public void init() {
		twoSum = new TwoSum();
	}
	@Test
	public void testNotNull() {
		assertNotNull(twoSum);
	}
	//@Test
	public void testCalculate1() {
		int result= twoSum.calculate("resources/course2/week4/algo1-programming_prob-sum2.txt",
				new int[]{-10000,10000});
		assertEquals(427, result);
	}

	@Test
	public void testCalculate_1_10() {
		int result= twoSum.calculate("resources/course2/week4/input_random_1_10.txt",
				new int[]{-10000,10000});
		assertEquals(2, result);
	}

	@Test
	public void testCalculate_test1() {
		int result= twoSum.calculate("resources/course2/week4/input_test1.txt",
				new int[]{0,4});
		assertEquals(2, result);
	}
	

}

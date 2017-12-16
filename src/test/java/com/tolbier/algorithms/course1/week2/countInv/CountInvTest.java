package com.tolbier.algorithms.course1.week2.countInv;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tolbier.algorithms.course1.week2.countInv.ArrayAndCountInv;
import com.tolbier.algorithms.course1.week2.countInv.CountInv;

public class CountInvTest {
	@Test
	public void testCountInv() {
		assertEquals(0, CountInv.countInv(new int[] { 1, 2, 3, 4, 5, 6 }));
		assertEquals(15, CountInv.countInv(new int[] { 6, 5, 4, 3, 2, 1 }));
		assertEquals(1, CountInv.countInv(new int[] { 1, 2, 3, 4, 6, 5 }));
		assertEquals(2, CountInv.countInv(new int[] { 1, 2, 3, 5, 6, 4 }));
		assertEquals(0, CountInv.countInv(new int[] { 1, 2 }));
		assertEquals(1, CountInv.countInv(new int[] { 2, 1 }));
		assertEquals(0, CountInv.countInv(new int[] { 2, 2 }));
		assertEquals(0, CountInv.countInv(new int[] { 2 }));
	}

	@Test
	public void testSortAndCountInv0() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] {});
		assertArrayEquals(new int[] {}, arrayAndCountInv.array);
		assertEquals(0, arrayAndCountInv.countInv);
	}

	@Test
	public void testSortAndCountInv1() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 1 });
		assertArrayEquals(new int[] { 1 }, arrayAndCountInv.array);
		assertEquals(0, arrayAndCountInv.countInv);
	}

	@Test
	public void testSortAndCountInv2() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 1, 2, 3, 4, 5, 6 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAndCountInv.array);
		assertEquals(0, arrayAndCountInv.countInv);
	}

	@Test
	public void testSortAndCountInv3() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 6, 5, 4, 3, 2, 1 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAndCountInv.array);
		assertEquals(15, arrayAndCountInv.countInv);
	}

	@Test
	public void testSortAndCountInv4() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 4, 5, 6, 1, 2, 3 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAndCountInv.array);
		assertEquals(9, arrayAndCountInv.countInv);
	}
	@Test
	public void testSortAndCountInv5() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 1, 2, 3, 4, 5 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arrayAndCountInv.array);
		assertEquals(0, arrayAndCountInv.countInv);
	}

	@Test
	public void testSortAndCountInv6() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 5, 4, 3, 2, 1 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arrayAndCountInv.array);
		assertEquals(10, arrayAndCountInv.countInv);
	}

	@Test
	public void testSortAndCountInv7() {
		ArrayAndCountInv arrayAndCountInv = CountInv.sortAndCountInv(new int[] { 4, 5, 1, 2, 3 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arrayAndCountInv.array);
		assertEquals(6, arrayAndCountInv.countInv);
	}

	@Test
	public void testMergeAndCountSplitInv1() {
		ArrayAndCountInv arrayAndCountInv = 
				CountInv.mergeAndCountSplitInv(
						new int[] { 1, 2, 3 },
						new int[] { 4, 5, 6 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAndCountInv.array);
		assertEquals(0, arrayAndCountInv.countInv);
	}

	@Test
	public void testMergeAndCountSplitInv2() {
		ArrayAndCountInv arrayAndCountInv = CountInv.mergeAndCountSplitInv(
				new int[] { 4, 5, 6 },
				new int[] { 1, 2, 3 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAndCountInv.array);
		assertEquals(9, arrayAndCountInv.countInv);
	}

	@Test
	public void testMergeAndCountSplitInv3() {
		ArrayAndCountInv arrayAndCountInv = CountInv.mergeAndCountSplitInv(new int[] { 1, 2, 3 }, new int[] { 4, 5 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arrayAndCountInv.array);
		assertEquals(0, arrayAndCountInv.countInv);
	}

	@Test
	public void testMergeAndCountSplitInv4() {
		ArrayAndCountInv arrayAndCountInv = CountInv.mergeAndCountSplitInv(new int[] { 4, 5 }, new int[] { 1, 2, 3 });
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, arrayAndCountInv.array);
		assertEquals(6, arrayAndCountInv.countInv);
	}

	@Test
	public void testArrayAndCountInv() {
		ArrayAndCountInv arrayAndCountInv = new ArrayAndCountInv(new int[] { 1, 2, 3, 4, 5, 6 }, 5);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayAndCountInv.array);
		assertEquals(5, arrayAndCountInv.countInv);
	}

}

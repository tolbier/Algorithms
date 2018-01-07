package com.tolbier.algorithms.course2.week3.medianMaintenance;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;



public class MedianMaintenanceHeapTest {
	MedianMaintenanceHeap medianMaintenance;

	@Before
	public void init() {
		medianMaintenance = new MedianMaintenanceHeap();
	}
	@Test
	public void testCreateMedianMaintenance1() {
		assertNotNull(medianMaintenance);
	}
	@Test
	public void testMedianMaintenance1() {
		int result=medianMaintenance.calculate("resources/course2/week3/Median.txt"); 
		assertEquals(1213, result);
	}
	@Test
	public void testMedianMaintenanceTest1() {
		int result=medianMaintenance.calculate("resources/course2/week3/test1.txt"); 
		assertEquals(142, result);
	}
	@Test
	public void testMedianMaintenanceTest2() {
		int result=medianMaintenance.calculate("resources/course2/week3/test2.txt"); 
		assertEquals(9335, result);
	}
}

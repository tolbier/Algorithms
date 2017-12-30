package com.tolbier.algorithms.course2.week2.dijkstra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;



public class PriorityQueueIntegerTest {
	Queue<Integer> heap;
	

	@Before
	public void init() {
		heap = new PriorityQueue<Integer>();
	}

	@Test
	public void testCreateHeap() {
		assertNotNull(heap);
	}
	@Test
	public void testAdd2Heap() {
		heap.add(12);
		heap.add(10);
		heap.add(11);
		Integer v= heap.poll();
		assertEquals(10,v.intValue());
		v= heap.poll();
		assertEquals(11,v.intValue());
		v= heap.poll();
		assertEquals(12,v.intValue());
		v= heap.poll();
		assertEquals(null, v);
		
	}
}

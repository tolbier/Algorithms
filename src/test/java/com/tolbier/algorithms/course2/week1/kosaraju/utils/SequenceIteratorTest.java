package com.tolbier.algorithms.course2.week1.kosaraju.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class SequenceIteratorTest {

	Iterator<Integer> sequence;
	@Before
	public void init() {
		sequence = new  ReverseSequenceIntegerIterator(2);
	}

	@Test
	public void testCreateSequence() {
		assertNotNull(sequence);
	}
	@Test
	public void testAddArc() {
		assertEquals(true,sequence.hasNext());
		assertEquals(1, sequence.next().intValue());
		assertEquals(true,sequence.hasNext());
		assertEquals(0, sequence.next().intValue());
		assertEquals(false,sequence.hasNext());
	}
	
}

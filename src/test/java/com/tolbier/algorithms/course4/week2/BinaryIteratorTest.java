package com.tolbier.algorithms.course4.week2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.tolbier.algorithms.course4.week2.exceptions.BinaryIteratorException;

public class BinaryIteratorTest {
	
	
	@Test(expected = BinaryIteratorException.class)
	public void testBinaryIterator2_3_EXCEPTION() throws BinaryIteratorException {
		assertEquals("",genericBinaryIteratorTest(2,3));
	}
	@Test
	public void testBinaryIterator2_1() throws BinaryIteratorException {
		assertEquals("[1, 10]",genericBinaryIteratorTest(2,1));
	}
	@Test
	public void testBinaryIterator2_0() throws BinaryIteratorException {
		assertEquals("[0]",genericBinaryIteratorTest(2,0));
	}

	@Test
	public void testBinaryIterator2_2() throws BinaryIteratorException {
		assertEquals("[11]",genericBinaryIteratorTest(2,2));
	}
	@Test
	public void testBinaryIterator3_3() throws BinaryIteratorException {
		assertEquals("[111]",genericBinaryIteratorTest(3,3));
	}

	@Test
	public void testBinaryIterator3_2() throws BinaryIteratorException {
		assertEquals("[11, 101, 110]",genericBinaryIteratorTest(3,2));
	}
	@Test
	public void testBinaryIterator3_1() throws BinaryIteratorException {
		assertEquals("[1, 10, 100]",genericBinaryIteratorTest(3,1));
	}

	private String genericBinaryIteratorTest(int n , int k) throws BinaryIteratorException {
		Iterator<Integer> binaryIterator = new BinaryIterator(n,k);
		List<String> list=new ArrayList<String>();
		while (binaryIterator.hasNext()) {
			list.add(Integer.toBinaryString(binaryIterator.next()));
		}
		return list.toString();
		
	}

}

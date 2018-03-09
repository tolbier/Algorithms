package com.tolbier.algorithms.course4.week2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.tolbier.algorithms.course4.week2.exceptions.BinaryIteratorException;

public class BitIteratorTest {
	
	

	@Test
	public void testBitIterator2_0()   {
		assertEquals("[1]",genericBitIteratorTest(2,0));
	}
	@Test
	public void testBitIterator3_0()   {
		assertEquals("[1]",genericBitIteratorTest(3,0));
	}
	@Test
	public void testBitIterator4_0()  {
		assertEquals("[2]",genericBitIteratorTest(4,0));
	}
	@Test
	public void testBitIterator7_0(){
		assertEquals("[1, 2]",genericBitIteratorTest(7,0));
	}
	@Test
	public void testBitIterator7_1() {
		assertEquals("[0, 2]",genericBitIteratorTest(7,1));
	}


	private String genericBitIteratorTest(int v , int except)  {
		Iterator<Integer> binaryIterator = new BitIterator(v,except);
		List<Integer> list=new ArrayList<Integer>();
		while (binaryIterator.hasNext()) {
			list.add(binaryIterator.next());
		}
		return list.toString();
		
	}

}

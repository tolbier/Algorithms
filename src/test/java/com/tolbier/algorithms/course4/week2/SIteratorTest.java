package com.tolbier.algorithms.course4.week2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.tolbier.algorithms.course4.week2.exceptions.SIteratorException;

public class SIteratorTest {
	
	@Test(expected = SIteratorException.class)
	public void testSIterator3_4()  throws SIteratorException {
		assertEquals("",genericSIteratorTest(3,4));
	}

	@Test
	public void testSIterator3_2()  throws SIteratorException {
		assertEquals("[11, 101]",genericSIteratorTest(3,2));
	}

	@Test
	public void testSIterator3_3()  throws SIteratorException {
		assertEquals("[111]",genericSIteratorTest(3,3));
	}
	@Test
	public void testSIterator4_4()  throws SIteratorException {
		assertEquals("[1111]",genericSIteratorTest(4,4));
	}

	@Test
	public void testSIterator4_3()  throws SIteratorException {
		assertEquals("[111, 1011, 1101]",genericSIteratorTest(4,3));
	}
	@Test
	public void testSIterator4_2()  throws SIteratorException {
		assertEquals("[11, 101, 1001]",genericSIteratorTest(4,2));
	}

	private String genericSIteratorTest(int n , int m) throws SIteratorException {
		Iterator<Integer> sIterator = new SIterator(n,m);
		List<String> list=new ArrayList<String>();
		while (sIterator .hasNext()) {
			list.add(Integer.toBinaryString(sIterator.next()));
		}
		return list.toString();
		
	}

}

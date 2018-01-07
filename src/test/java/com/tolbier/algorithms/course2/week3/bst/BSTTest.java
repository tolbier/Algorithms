package com.tolbier.algorithms.course2.week3.bst;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;



public class BSTTest {


	@Test
	public void test() {
		BST b = new BST();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		assertEquals(" 1 2 3 4 6 8 9 10",b.toString());

		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		assertEquals(" 1 2 3 4 6 8 9 10 15 16 20 25",b.toString());
		b.delete(2);
		assertEquals(" 1 3 4 6 8 9 10 15 16 20 25",b.toString());
		b.delete(4);
		assertEquals(" 1 3 6 8 9 10 15 16 20 25",b.toString());
		b.delete(10);
		assertEquals(" 1 3 6 8 9 15 16 20 25",b.toString());
	}
	
}

package com.tolbier.algorithms.course1.week2.strassen;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.tolbier.algorithms.course1.week2.strassen.Strassen;

public class StrassenTest {
	@Test
	public void testStrassen() {
		int [][] 
				a= new int[][] 
									{{1,2},
							 		 {5,6}},
				b= new int[][] 
									{{3,4},
							 		 {7,8}},
				product= new int[][] 
									{{17,20},
						 		 	 {57,68}}
									 ;
						 
		assertArrayEquals(product, Strassen.multiply(a,b));
	}

	@Test
	public void testStrassen2() {
		int [][] 
				x= new int[][] 
						{{1,2,  3,4},
						 {5,6,  7,8},
						 {9,10,11,12},
						 {13,14,15,16}},
				y= new int[][] 
						{{-1,-2,  -3,-4},
						 {-5,-6,  -7,-8},
						 {-9,-10,-11,-12},
						 {-13,-14,-15,-16}},
						
				product= new int[][] 
							{{-90,-100,-110,-120},
							 {-202,-228,-254,-280},
							 {-314,-356,-398,-440},
							 {-426,-484,-542,-600}}
	
									 ;
						 
		assertArrayEquals(product, Strassen.multiply(x,y));
	}
	

	@Test
	public void testSubMatrix() {
		int [][] 
				x= new int[][] 
									{{1,2,  3,4},
									 {5,6,  7,8},
									 {9,10,11,12},
									 {13,14,15,16}},
				a= new int[][] 
									{{1,2},
							 		 {5,6}},
				b= new int[][] 
									{{3,4},
							 		 {7,8}},
				c= new int[][] 
									{{9,10},
							 		 {13,14}},
				d= new int[][] 
									{{11,12},
						 		 	 {15,16}}
									
									 ;
						 
		assertArrayEquals(a, Strassen.subMatrix(x,0,0));
		assertArrayEquals(b, Strassen.subMatrix(x,1,0));
		assertArrayEquals(c, Strassen.subMatrix(x,0,1));
		assertArrayEquals(d, Strassen.subMatrix(x,1,1));
		
	}

	@Test
	public void testMatrixSum() {
		int [][] 
		x= new int[][] 
							{{2,3},
				 			 {4,5}},
		y= new int[][] 
							{{6,7},
					 		 {8,9}},
		result= new int[][] 
							{{8,10},
					 		{12,14}};
				 
		assertArrayEquals(result, Strassen.sum(x,y));
	}
	@Test
	public void testMatrixSum2() {
		int [][] 
		x= new int[][] 
							{{2,-3},
				 			 {4,5}},
		y= new int[][] 
							{{-6,7},
					 		 {8,-9}},
		result= new int[][] 
							{{-4,4},
					 		{12,-4}};
				 
		assertArrayEquals(result, Strassen.sum(x,y));
	}

	@Test
	public void testMatrixSubstract() {
		int [][] 
		x= new int[][] 
							{{2,3},
				 			 {4,5}},
		y= new int[][] 
							{{6,7},
					 		 {8,9}},
		result= new int[][] 
							{{-4,-4},
					 		{-4,-4}};
				 
		assertArrayEquals(result, Strassen.subtract(x,y));

	}
	
	@Test
	public void testMatrixSubstract2() {
		int [][] 
		x= new int[][] 
							{{12,23},
				 			 {4,15}},
		y= new int[][] 
							{{26,17},
					 		 {18,9}},
		result= new int[][] 
							{{-14,6},
					 		{-14,6}};
				 
		assertArrayEquals(result, Strassen.subtract(x,y));

	}

}

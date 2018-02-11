package com.tolbier.algorithms.course3.week4;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;

public class KnapSackTest {
	String[] testNames= new String[] {
			"1_4_4",
			"2_4_4",
			"3_4_4",
			"4_4_4",
			"5_10_10",
			"6_10_10",
			"7_10_10",
			"8_10_10",
			"9_100_10",
			"10_100_10",
			"11_100_10",
			"12_100_10",
			"13_100_100",
			"14_100_100",
			"15_100_100",
			"16_100_100",
			"17_100_1000",
			"18_100_1000",
			"19_100_1000",
			"20_100_1000",
			"21_1000_100",
			"22_1000_100",
			"23_1000_100",
			"24_1000_100",
//			"25_1000_1000",
//			"26_1000_1000",
//			"27_1000_1000",
//			"28_1000_1000",
//			"29_10000_1000",
//			"30_10000_1000",
//			"31_10000_1000",
//			"32_10000_1000",
//			"33_100000_2000",
//			"34_100000_2000",
//			"35_100000_2000",
//			"36_100000_2000",
//			"37_1000000_2000",
//			"38_1000000_2000",
//			"39_1000000_2000",
//			"40_1000000_2000",
//			"41_2000000_2000",
//			"42_2000000_2000",
//			"43_2000000_2000",
//			"44_2000000_2000",
	};
	

	@Test
	public void testMwis_multiple() {
		for (int i =0;i<testNames.length;i++) {
			KnapSack  knapSack = new KnapSack("resources/course3/week4/testcases/input_random_"+testNames[i]+".txt");
			
			assertEquals("Id:"+testNames[i]+" FAILED",getResultForTest(testNames[i]),knapSack.getValue());
		}
	}

	//@Test
	public void testKnapSack1() {
		KnapSack  knapSack = new KnapSack("resources/course3/week4/knapsack1.txt");
		assertEquals(2493893,knapSack.getValue());
	}
	
	//@Test
	public void testKnapSackBig() {
		KnapSack  knapSack = new KnapSack("resources/course3/week4/knapsack_big.txt");
		assertEquals(4243395,knapSack.getValue());
	}

	private long getResultForTest(String testId) {
		long result=0;;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("resources/course3/week4/testcases/output_random_"+testId+".txt"));
			result = scanner.nextLong();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			scanner.close();
		}
		return result;
	}

}

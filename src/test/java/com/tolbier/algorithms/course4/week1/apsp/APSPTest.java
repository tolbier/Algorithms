package com.tolbier.algorithms.course4.week1.apsp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.course3.week4.KnapSack;
import com.tolbier.algorithms.course4.week1.GraphReader;
import com.tolbier.algorithms.course4.week1.apsp.algorithms.JohnsonAlgorithm;
import com.tolbier.algorithms.course4.week1.exceptions.HasNegativeCyclesException;
import com.tolbier.algorithms.course4.week1.sp.BellmanFord;

public class APSPTest {
	String[] testNames = new String[] { 
			"",
			"1_2", 
			"2_2",
			"3_2",
			"4_2",
			 "5_4",
			 "6_4",
			 "7_4",
			 "8_4",
			 "9_8",
			 "10_8",
			 "11_8",
			 "12_8",
			 "13_16",
			 "14_16",
			 "15_16",
			 "16_16",
			 "17_32",
			 "18_32",
			 "19_32",
			 "20_32",
			 "21_64",
			 "22_64",
			 "23_64",
			 "24_64",
//			 "25_128",
//			 "26_128",
//			 "27_128",
//			 "28_128",
//			 "29_256",
//			 "30_256",
//			 "31_256",
//			 "32_256",
//			 "33_512",
//			 "34_512",
//			 "35_512",
//			 "36_512",
//			 "37_1024",
//			 "38_1024",
//			 "39_1024",
//			 "40_1024",
//			 "41_2048",
//			 "42_2048",
//			 "43_2048",
//			 "44_2048",

	};

	@Test
	public void testNullResponse() {
		int i = 1;

		assertEquals(null, getResultForTest(i));
	}

	//Test
	public void testNotNullResponse() {
		int i = 2;

		assertEquals(-66, getResultForTest(i).longValue());
	}

	@Test
	public void testAPSP_multiple() {
		for (int i = 1; i < testNames.length; i++) {
			APSP apsp = new APSP(new JohnsonAlgorithm(getInputFileName(i)));
			assertEquals("Id:" + testNames[i] + " FAILED", getResultForTest(i), apsp.getShortestPathLength());
		}
	}

	//@Test
	public void testAPSP_g1() {
			APSP apsp = new APSP(new JohnsonAlgorithm("resources/course4/week1/g1.txt"));
			assertNull( apsp.getShortestPathLength());
	}
	//@Test
	public void testAPSP_g2() {
			APSP apsp = new APSP(new JohnsonAlgorithm("resources/course4/week1/g2.txt"));
			assertNull(apsp.getShortestPathLength());
	}
	//@Test
	public void testAPSP_g3() {
			APSP apsp = new APSP(new JohnsonAlgorithm("resources/course4/week1/g3.txt"));
			assertEquals(-19, apsp.getShortestPathLength().intValue());
	}

	//@Test
	public void testAPSP_large() {
			APSP apsp = new APSP(new JohnsonAlgorithm("resources/course4/week1/large.txt"));
			assertEquals(0, apsp.getShortestPathLength().intValue());
	}

	private String getInputFileName(int i) {
		return "resources/course4/week1/testcases/input_random_" + testNames[i] + ".txt";
	}

	private Integer getResultForTest(int testId) {
		Integer result = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(
					new File("resources/course4/week1/testcases/output_random_" + testNames[testId] + ".txt"));
			result = scanner.nextInt();

		} catch (InputMismatchException e) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			scanner.close();
		}
		return result;
	}

}

package com.tolbier.algorithms.course2.week1.kosaraju;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.course2.week1.kosaraju.utils.MapUtil;
import com.tolbier.algorithms.course4.week1.apsp.APSP;
import com.tolbier.algorithms.course4.week1.apsp.algorithms.JohnsonAlgorithm;
import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class KosarajuTest {
	
	
	String[] testNames = new String[] {
			"1_8",
			"2_8",
			"3_8",
			"4_8",
			"5_16",
			"6_16",
			"7_16",
			"8_16",
			"9_32",
			"10_32",
			"11_32",
			"12_32",
			"13_64",
			"14_64",
			"15_64",
			"16_64",
			"17_128",
			"18_128",
			"19_128",
			"20_128",
			"21_200",
			"22_200",
			"23_200",
			"24_200",
			"25_400",
			"26_400",
			"27_400",
			"28_400",
			"29_800",
			"30_800",
			"31_800",
			"32_800",
//			"33_1600",
//			"34_1600",
//			"35_1600",
//			"36_1600",
//			"37_3200",
//			"38_3200",
//			"39_3200",
//			"40_3200",
//			"41_6400",
//			"42_6400",
//			"43_6400",
//			"44_6400",
//			"45_12800",
//			"46_12800",
//			"47_12800",
//			"48_12800",
//			"49_20000",
//			"50_20000",
//			"51_20000",
//			"52_20000",
//			"53_40000",
//			"54_40000",
//			"55_40000",
//			"56_40000",
//			"57_80000",
//			"58_80000",
//			"59_80000",
//			"60_80000",
//			"61_160000",
//			"62_160000",
//			"63_160000",
//			"64_160000",
//			"65_320000",
//			"66_320000",
//			"67_320000",
//			"68_320000",

	};


	@Test
	public void testKosaraju_multiple() throws TSPException {
		for (int i = 0; i < testNames.length; i++) {
			String fileName = getInputFileName(i);
			Kosaraju kosaraju=new Kosaraju(fileName );
			assertEquals("FAILED: test#"+i+","+fileName , Arrays.deepToString(getResultForTest(i)), Arrays.toString(kosaraju.getSizes()));
		}
	}
	//@Test
	public void testKosaraju_final() throws TSPException {

			String fileName = "resources/course2/week1/SCC.txt";
			Kosaraju kosaraju=new Kosaraju(fileName );
			assertEquals("FAILED: test#FINAL,"+fileName , "[434821, 968, 459, 313, 211]", Arrays.toString(kosaraju.getSizes()));
	}
	@Test
	public void testResults()  {
		assertEquals("[4, 2, 2, 0, 0]", Arrays.deepToString(getResultForTest(0)));
		assertEquals("[8, 0, 0, 0, 0]", Arrays.deepToString(getResultForTest(1)));
		assertEquals("[7, 0, 0, 0, 0]", Arrays.deepToString(getResultForTest(2)));
		assertEquals("[5, 2, 0, 0, 0]", Arrays.deepToString(getResultForTest(3)));
	}
	@Test
	public void testgetGraphsFromFile()  {
		assertEquals("0 1 0,1 7 0,2 0 0,3 6 0,4 5 0,5 4 0,6 3 0,7 2 0",new Kosaraju(getInputFileName(0)).getGraphs().graph.toString());
	}
	
	private String getInputFileName(int i) {
		return "resources/course2/week1/testcases/input_mostlyCycles_" + testNames[i] + ".txt";
	}

	private Integer[] getResultForTest(int testId) {
		Integer[] result = new Integer[5];
		Scanner scanner = null;
		try {
			scanner = new Scanner(
					new File("resources/course2/week1/testcases/output_mostlyCycles_" + testNames[testId] + ".txt"));
			scanner.useDelimiter(",|$");
			for (int i  = 0; i<5;i++) {
				result[i] = scanner.nextInt();
			}

		} catch (InputMismatchException e) {
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			scanner.close();
		}
		return result;
	}

}

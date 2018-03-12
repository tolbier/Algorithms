package com.tolbier.algorithms.course4.week3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.course4.week1.apsp.APSP;
import com.tolbier.algorithms.course4.week1.apsp.algorithms.JohnsonAlgorithm;
import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class TSPHeuristicTest {
	String[] testNames = new String[] {
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
			"13_10",
			"14_10",
			"15_10",
			"16_10",
			"17_20",
			"18_20",
			"19_20",
			"20_20",
			"21_40",
			"22_40",
			"23_40",
			"24_40",
			"25_80",
			"26_80",
			"27_80",
			"28_80",
			"29_100",
			"30_100",
			"31_100",
			"32_100",
			"33_200",
			"34_200",
			"35_200",
			"36_200",
//			"37_400",
//			"38_400",
//			"39_400",
//			"40_400",
//			"41_800",
//			"42_800",
//			"43_800",
//			"44_800",
//			"45_1000",
//			"46_1000",
//			"47_1000",
//			"48_1000",
//			"49_2000",
//			"50_2000",
//			"51_2000",
//			"52_2000",
//			"53_4000",
//			"54_4000",
//			"55_4000",
//			"56_4000",
//			"57_8000",
//			"58_8000",
//			"59_8000",
//			"60_8000",
//			"61_10000",
//			"62_10000",
//			"63_10000",
//			"64_10000",
//			"65_20000",
//			"66_20000",
//			"67_20000",
//			"68_20000",
//			"69_40000",
//			"70_40000",
//			"71_40000",
//			"72_40000",
	};


	@Test
	public void testTSP_multiple() throws TSPException {
		for (int i = 0; i < testNames.length; i++) {
			TSPHeuristic tsp= new TSPHeuristic(getInputFileName(i));
			assertEquals("Id:" + testNames[i] + " FAILED", getResultForTest(i).intValue(), tsp.getTourLength());

		}
	}
	//@Test
	public void testTSP_FINAL() throws TSPException {
		   TSPHeuristic tsp= new TSPHeuristic("resources/course4/week3/nn.txt");
			assertEquals(1203406, tsp.getTourLength());
	}

	private String getInputFileName(int i) {
		return "resources/course4/week3/testcases/input_simple_" + testNames[i] + ".txt";
	}

	private Integer getResultForTest(int testId) {
		Integer result = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(
					new File("resources/course4/week3/testcases/output_simple_" + testNames[testId] + ".txt"));
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

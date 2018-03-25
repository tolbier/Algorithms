package com.tolbier.algorithms.course4.week4;

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

public class TwoSATTest {
	String[] testNames = new String[] {
			"1_2",
			"2_2",
			"3_4",
			"4_4",
			"5_8",
			"6_8",
			"7_10",
			"8_10",
			"9_20",
			"10_20",
			"11_40",
			"12_40",
			"13_80",
			"14_80",
			"15_100",
			"16_100",
			"17_200",
			"18_200",
			"19_400",
			"20_400",
			"21_800",
			"22_800",
//			"23_1000",
//			"24_1000",
//			"25_2000",
//			"26_2000",
//			"27_4000",
//			"28_4000",
//			"29_8000",
//			"30_8000",
//			"31_10000",
//			"32_10000",
//			"33_20000",
//			"34_20000",
//			"35_40000",
//			"36_40000",
//			"37_80000",
//			"38_80000",
//			"39_100000",
//			"40_100000",
	};


	@Test
	public void testTwoSAT_multiple() throws TSPException {
		for (int i = 0; i < testNames.length; i++) {
			TwoSAT twoSAT= new TwoSAT(getInputFileName(i));
			assertEquals("Id:" + testNames[i] + " FAILED", getResultForTest(i), twoSAT.getSatisfiable());
		}
	}
	//@Test
	public void testTSP1_FINAL() throws TSPException {
		TwoSAT twoSAT1= new TwoSAT("resources/course4/week4/2sat1.txt");
		assertEquals("FAILED:2sat1.txt",1 , twoSAT1.getSatisfiable());
	}
	//@Test
	public void testTSP2_FINAL() throws TSPException {
		TwoSAT twoSAT2= new TwoSAT("resources/course4/week4/2sat2.txt");
		assertEquals("FAILED:2sat2.txt",0 , twoSAT2.getSatisfiable());
	}
	//@Test
	public void testTSP3_FINAL() throws TSPException {
		TwoSAT twoSAT3= new TwoSAT("resources/course4/week4/2sat3.txt");
		assertEquals("FAILED:2sat3.txt",1 , twoSAT3.getSatisfiable());
	}
	//@Test
	public void testTSP4_FINAL() throws TSPException {
		TwoSAT twoSAT4= new TwoSAT("resources/course4/week4/2sat4.txt");
		assertEquals("FAILED:2sat4.txt",1 , twoSAT4.getSatisfiable());
	}
	//@Test
	public void testTSP5_FINAL() throws TSPException {
		TwoSAT twoSAT5= new TwoSAT("resources/course4/week4/2sat5.txt");
		assertEquals("FAILED:2sat5.txt",0 , twoSAT5.getSatisfiable());
	}
	//@Test
	public void testTSP6_FINAL() throws TSPException {
		TwoSAT twoSAT6= new TwoSAT("resources/course4/week4/2sat6.txt");
		assertEquals("FAILED:2sat6.txt",0 , twoSAT6.getSatisfiable());
	}

	private String getInputFileName(int i) {
		return "resources/course4/week4/testcases/input_beaunus_" + testNames[i] + ".txt";
	}

	private int getResultForTest(int testId) {
		Integer result = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(
					new File("resources/course4/week4/testcases/output_beaunus_" + testNames[testId] + ".txt"));
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

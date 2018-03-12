package com.tolbier.algorithms.course4.week2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.commons.tsp.DoublePoint;

public class PointsReaderTest {
	String[] testNames = new String[] {
			"1_2",
			"2_2",
//			"3_2",
//			"4_2",
//			"5_3",
//			"6_3",
//			"7_3",
//			"8_3",
//			"9_4",
//			"10_4",
//			"11_4",
//			"12_4",
//			"13_5",
//			"14_5",
//			"15_5",
//			"16_5",
//			"17_6",
//			"18_6",
//			"19_6",
//			"20_6",
//			"21_7",
//			"22_7",
//			"23_7",
//			"24_7",
//			"25_8",
//			"26_8",
//			"27_8",
//			"28_8",
//			"29_9",
//			"30_9",
//			"31_9",
//			"32_9",
//			"33_10",
//			"34_10",
//			"35_10",
//			"36_10",
//			"37_11",
//			"38_11",
//			"39_11",
//			"40_11",
//			"41_12",
//			"42_12",
//			"43_12",
//			"44_12",
//			"45_13",
//			"46_13",
//			"47_13",
//			"48_13",
//			"49_14",
//			"50_14",
//			"51_14",
//			"52_14",
//			"53_15",
//			"54_15",
//			"55_15",
//			"56_15",
//			"57_16",
//			"58_16",
//			"59_16",
//			"60_16",
//			"61_17",
//			"62_17",
//			"63_17",
//			"64_17",
//			"65_18",
//			"66_18",
//			"67_18",
//			"68_18",
//			"69_19",
//			"70_19",
//			"71_19",
//			"72_19",
//			"73_20",
//			"74_20",
//			"75_20",
//			"76_20",
//			"77_21",
//			"78_21",
//			"79_21",
//			"80_21",
//			"81_22",
//			"82_22",
//			"83_22",
//			"84_22",
//			"85_23",
//			"86_23",
//			"87_23",
//			"88_23",
//			"89_24",
//			"90_24",
//			"91_24",
//			"92_24",
	};


	@Test
	public void testPointsRead0() {
		DoublePoint[] points = PointsReader.readFloatPointsListFromFilePath(getFloatInputFileName(0));
		assertEquals("[[1.185111439847509, 1.1487624635211768],"
				+ " [1.4444704252469853, 1.9471010355780376]]", Arrays.toString(points));
	}
	@Test
	public void testPointsRead1() {
		DoublePoint[] points = PointsReader.readFloatPointsListFromFilePath(getFloatInputFileName(1));
		assertEquals("[[0.16798790782408335, 0.6011960820343805],"
				+ " [1.0980452892354502, 0.001825930206370563]]", Arrays.toString(points));
	}
	private String getFloatInputFileName(int i) {
		return "resources/course4/week2/testcases/input_float_" + testNames[i] + ".txt";
	}


}

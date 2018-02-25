package com.tolbier.algorithms.course4.week1;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;

public class GraphReaderTest {
	String[] testNames = new String[] {
			"1_2", 
			"2_2",
			// "3_2",
			// "4_2",
			// "5_4",
			// "6_4",
			// "7_4",
			// "8_4",
			// "9_8",
			// "10_8",
			// "11_8",
			// "12_8",
			// "13_16",
			// "14_16",
			// "15_16",
			// "16_16",
			// "17_32",
			// "18_32",
			// "19_32",
			// "20_32",
			// "21_64",
			// "22_64",
			// "23_64",
			// "24_64",
			// "25_128",
			// "26_128",
			// "27_128",
			// "28_128",
			// "29_256",
			// "30_256",
			// "31_256",
			// "32_256",
			// "33_512",
			// "34_512",
			// "35_512",
			// "36_512",
			// "37_1024",
			// "38_1024",
			// "39_1024",
			// "40_1024",
			// "41_2048",
			// "42_2048",
			// "43_2048",
			// "44_2048",

	};


	@Test
	public void testGraphRead() {
		Graph<Integer> graph = GraphReader.createDirectedGraphFromFilePath(getInputFileName(0));
		assertEquals("1 1 -73\n1 2 51\n2 2 44\n2 2 31\n", graph.toString());
	}
	
	private String getInputFileName(int i) {
		return "resources/course4/week1/testcases/input_random_" + testNames[i] + ".txt";
	}


}

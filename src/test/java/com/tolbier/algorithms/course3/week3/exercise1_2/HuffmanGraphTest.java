package com.tolbier.algorithms.course3.week3.exercise1_2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;

public class HuffmanGraphTest {
	
	String[] testNames= new String[] {

			"1_10",
			"2_10",
			"3_10",
			"4_10",
			"5_20",
			"6_20",
			"7_20",
			"8_20",
			"9_40",
			"10_40",
			"11_40",
			"12_40",
			"13_80",
			"14_80",
			"15_80",
			"16_80",
			"17_160",
			"18_160",
			"19_160",
			"20_160",
			"21_320",
			"22_320",
			"23_320",
			"24_320",
			"25_640",
			"26_640",
			"27_640",
			"28_640",
			"29_1000",
			"30_1000",
			"31_1000",
			"32_1000",
			"33_2000",
			"34_2000",
			"35_2000",
			"36_2000",
		    "37_4000",
			"38_4000",
			"39_4000",
			"40_4000",
			"41_8000",
			"42_8000",
			"43_8000",
			"44_8000",
			"45_10000",
			"46_10000",
			"47_10000",
			"48_10000",
	};
	

	@Test
	public void testHuffmanGraph_multiple() {
		for (int i =0;i<testNames.length;i++) {
			HuffmanGraph  huffmanGraph = new HuffmanGraph("resources/course3/week3/exercise1_2/testcases/input_random_"+testNames[i]+".txt");
			
		 	int[] minMax= getMinMaxForTest(testNames[i]);
			assertEquals("Id:"+testNames[i]+" MAX FAILED",minMax[1],huffmanGraph.getMax());
			assertEquals("Id:"+testNames[i]+" MIN FAILED",minMax[0],huffmanGraph.getMin());
		}
	}

	@Test
	public void testHuffmanGraph() {
			HuffmanGraph  huffmanGraph = new HuffmanGraph("resources/course3/week3/exercise1_2/huffman.txt");
			
			assertEquals(" MAX FAILED",19,huffmanGraph.getMax());
			assertEquals(" MIN FAILED",9,huffmanGraph.getMin());
	}
	
	private int[] getMinMaxForTest(String testId) {
		int[] minMax=new int[2];
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File("resources/course3/week3/exercise1_2/testcases/output_random_"+testId+".txt"));
			minMax[1] = intScanner.nextInt();
			minMax[0] = intScanner.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return minMax;
	}

}

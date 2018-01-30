package com.tolbier.algorithms.course3.week2.kCluster2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.course3.week2.kCluster1.KCluster;

public class KClusterHammingTest {
	KClusterHamming kCluster;
	String[] testNames= new String[] {

			"1_4_14",
			"2_4_10",
			"3_4_8",
			"4_4_6",
			"5_4_4",
			"6_8_12",
			"7_8_10",
			"8_8_8",
			"9_8_6",
			"10_16_18",
			"11_16_16",
			"12_16_14",
			"13_16_12",
			"14_16_10",
			"15_16_8",
			"16_32_20",
			"17_32_18",
			"18_32_16",
			"19_32_14",
			"20_32_12",
			"21_32_10",
/*			"22_32_8",
			"23_64_22",
			"24_64_20",
			"25_64_18",
			"26_64_16",
			"27_64_14",
			"28_64_12",
			"29_64_10",
/*			"30_128_24",
			"31_128_22",
			"32_128_20",
			"33_128_18",
			"34_128_16",
			"35_128_14",
			"36_128_12",
			"37_128_10",
			"38_256_24",
			"39_256_22",
			"40_256_20",
			"41_256_18",
			"42_256_16",
			"43_256_14",
			"44_256_12",
/*			"45_512_24",
			"46_512_22",
			"47_512_20",
			"48_512_18",
			"49_512_16",
			"50_512_14",
			"51_512_12",
/*			"52_1024_24",
			"53_1024_22",
			"54_1024_20",
			"55_1024_18",
			"56_1024_16",
			"57_1024_14",
			"58_2048_24",
			"59_2048_22",
			"60_2048_20",
			"61_2048_18",
			"62_2048_16",
			"63_4096_24",
			"64_4096_22",
			"65_4096_20",
			"66_4096_18",
			"67_4096_16",
			"68_8192_24",
			"69_8192_22",
			"70_8192_20",
			"71_8192_18",
			"72_16384_24",
			"73_16384_22",
			"74_16384_20",
			"75_16384_18",
			"76_32768_24",
			"77_32768_22",
			"78_32768_20",
			"79_65536_24",
			"80_65536_22",
			"81_131072_24",
			"82_131072_22",
			"83_262144_24"
*/
	};
 	
	@Test
	public void testConstructor1() {
		kCluster = new KClusterHamming("resources/course3/week2/exercise2/input_random_1_4_14.txt");
		assertEquals("{12987=0, 13708=1, 2572=2, 5532=3}",kCluster.getNodesMap().toString());
		assertEquals(4,kCluster.getNumberOfNodes());
		assertEquals(14,kCluster.getnBits());
	}

	
	@Test
	public void testKValueForSpacing3_multiple() {
		for (int i =0;i<testNames.length;i++) {
			kCluster = new KClusterHamming("resources/course3/week2/exercise2/input_random_"+testNames[i]+".txt");
			assertEquals("Id:"+testNames[i]+" FAILED",getResultForTest(testNames[i]),kCluster.getKForSpacing3UF());
		}
	}

	//@Test
	public void testGetNumberOfNodes(){
		kCluster = new KClusterHamming("resources/course3/week2/exercise2/clustering_big.txt");
		assertEquals(198788, kCluster.getNumberOfNodes());
		
	}
	//@Test
	public void testMaximumSpacing_clustering1() {
		kCluster = new KClusterHamming("resources/course3/week2/exercise2/clustering_big.txt");

		assertEquals(6118, kCluster.getKForSpacing3UF());

	}
	
	private int getResultForTest(String testId) {
		int result=0;
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File("resources/course3/week2/exercise2/output_random_"+testId+".txt"));
			result= intScanner.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return result;
	}
}

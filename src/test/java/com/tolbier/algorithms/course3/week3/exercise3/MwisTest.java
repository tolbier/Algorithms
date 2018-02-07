package com.tolbier.algorithms.course3.week3.exercise3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;

public class MwisTest {
	int testIds[]= {1, 2, 3, 4, 17, 117, 517, 997};
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
//			"29_1000",
//			"30_1000",
//			"31_1000",
//			"32_1000",
//			"33_2000",
//			"34_2000",
//			"35_2000",
//			"36_2000",
//			"37_4000",
//			"38_4000",
//			"39_4000",
//			"40_4000",
//			"41_8000",
//			"42_8000",
//			"43_8000",
//			"44_8000",
//			"45_10000",
//			"46_10000",
//			"47_10000",
//			"48_10000"
	};
	

	@Test
	public void testMwis_multiple() {
		for (int i =0;i<testNames.length;i++) {
			Mwis  mwis = new Mwis("resources/course3/week3/exercise3/testcases/input_random_"+testNames[i]+".txt");
			int result = mwis.test(testIds);
			assertEquals("Id:"+testNames[i]+" FAILED",getResultForTest(testNames[i]),result);
		}
	}

	@Test
	public void testMwis() {
		Mwis  mwis = new Mwis("resources/course3/week3/exercise3/mwis.txt");
		int result = mwis.test(testIds);
		assertEquals(0b010100110,result);
	}
	
	@Test
	public void testResultForTest() {
		assertEquals(175,getResultForTest("48_10000"));
	}

	private int getResultForTest(String testId) {
		int result=0;;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("resources/course3/week3/exercise3/testcases/output_random_"+testId+".txt"));
			result = scanner.nextInt(2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			scanner.close();
		}
		return result;
	}

}

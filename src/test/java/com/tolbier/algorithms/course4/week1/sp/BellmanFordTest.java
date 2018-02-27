package com.tolbier.algorithms.course4.week1.sp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.course4.week1.GraphReader;
import com.tolbier.algorithms.course4.week1.exceptions.HasNegativeCyclesException;

public class BellmanFordTest {
	String[] testNames = new String[] {
			"",
			"1_2", 
			"2_2",
			"3_2",
			"4_2",
			"5_4",
			"6_4",
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

	
	@Test(expected = HasNegativeCyclesException.class)
	public void testTestCase1() throws HasNegativeCyclesException {
			Graph<Integer> graph = GraphReader.createDirectedGraphFromFilePath(getInputFileName(1));
			BellmanFord bellmanFord = new BellmanFord(graph, 1);
	}
	@Test
	public void testTestCase2() throws HasNegativeCyclesException {
			Graph<Integer> graph = GraphReader.createDirectedGraphFromFilePath(getInputFileName(2));
			BellmanFord bellmanFord = new BellmanFord(graph, 1);
			assertEquals(0,	bellmanFord.getShortestPathLengthTo(1).intValue());
			assertEquals(-66,	bellmanFord.getShortestPathLengthTo(2).intValue());
			assertEquals("[0, 0, -66]",Arrays.toString(bellmanFord.getLengthsArr()));
	}
	@Test(expected = HasNegativeCyclesException.class)
	public void testTestCase5() throws HasNegativeCyclesException {
			Graph<Integer> graph = GraphReader.createDirectedGraphFromFilePath(getInputFileName(5));
			BellmanFord bellmanFord = new BellmanFord(graph, 1);
	}
	@Test
	public void testTestCase6() throws HasNegativeCyclesException {
			Graph<Integer> graph = GraphReader.createDirectedGraphFromFilePath(getInputFileName(6));
			BellmanFord bellmanFord = new BellmanFord(graph, 1);
			assertEquals(0,	bellmanFord.getShortestPathLengthTo(1).intValue());
			assertEquals(-6,	bellmanFord.getShortestPathLengthTo(2).intValue());
			assertEquals(-12,	bellmanFord.getShortestPathLengthTo(3).intValue());
			assertEquals(Integer.MAX_VALUE,	bellmanFord.getShortestPathLengthTo(4).intValue());
			assertEquals("[0, 0, -6, -12, "+Integer.MAX_VALUE+"]",Arrays.toString(bellmanFord.getLengthsArr()));
	}
	@Test
	public void testTestCase2withVertex0() throws HasNegativeCyclesException {
			Graph<Integer> graph = GraphReader.createDirectedGraphFromFilePath(getInputFileName(2));
			graph.addEdge(0, 1, 0);
			BellmanFord bellmanFord = new BellmanFord(graph, 1);
			assertEquals(0,	bellmanFord.getShortestPathLengthTo(1).intValue());
			assertEquals(-66,	bellmanFord.getShortestPathLengthTo(2).intValue());
			assertEquals("[0, 0, -66]",Arrays.toString(bellmanFord.getLengthsArr()));
	}
	private String getInputFileName(int i) {
		return "resources/course4/week1/testcases/input_random_" + testNames[i] + ".txt";
	}

	private Long getResultForTest(int testId) {
		Long result = null;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("resources/course4/week1/testcases/output_random_" + testNames[ testId ]+ ".txt"));
			result = scanner.nextLong();

		} catch (InputMismatchException e) {
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			scanner.close();
		}
		return result;
	}

}

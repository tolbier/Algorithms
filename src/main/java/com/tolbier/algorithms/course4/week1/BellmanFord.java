package com.tolbier.algorithms.course4.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.tolbier.algorithms.commons.Graph;

public class BellmanFord {
	Graph<Long> graph ; 
	public BellmanFord(String fileName) {
		graph= createGraphFromFilePath(fileName);
	}

	public Long getShortestPathLength() {
		return 0l;
	}
	public Graph<Long> createGraphFromFilePath(String filePath) {
		Graph<Long> graph = new Graph<Long>(true); ;
		Scanner intScanner = null;

		try {
			intScanner = new Scanner(new File(filePath));
			intScanner.nextInt(); intScanner.nextInt();
			while (intScanner.hasNextLong()) {
				int vertex1 = intScanner.nextInt();
				int vertex2  = intScanner.nextInt();
				int weight = intScanner.nextInt();
				graph.addEdge(vertex1,vertex2, weight);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return graph;
	}

	protected Graph<Long> getGraph() {
		return graph;
	}
}

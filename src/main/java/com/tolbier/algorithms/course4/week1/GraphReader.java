package com.tolbier.algorithms.course4.week1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.tolbier.algorithms.commons.Graph;

public class GraphReader {

	public static Graph<Integer> createDirectedGraphFromFilePath(String filePath) {
		Graph<Integer> graph = new Graph<Integer>(true); ;
		Scanner intScanner = null;

		try {
			intScanner = new Scanner(new File(filePath));
			int n = intScanner.nextInt(); intScanner.nextInt();
			createNVerticesInGraph(n,graph);
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

	private static void createNVerticesInGraph(int n, Graph<Integer> graph) {
		for (int i=1 ;i<=n;i++) {
			graph.addSingleVertex(i);
		}
	}


}


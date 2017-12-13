package com.tolbier.algorithms.week4.kargerMinCut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner lineScanner = null;
		AdjacencyList adjacencyList = new AdjacencyList();
		try {
			lineScanner = new Scanner(new File("resources/week4/kargerMinCut/kargerMinCut.txt"));
			while (lineScanner.hasNextLine()) {

				String line = lineScanner.nextLine();
				Scanner intScanner= new Scanner(line);
				int tailVertex = intScanner.nextInt();
				adjacencyList.createVertex(tailVertex);
				while (intScanner.hasNextInt()) {
					int headVertex = intScanner.nextInt();
					adjacencyList.addEdge(tailVertex, headVertex);
				}
				intScanner.close();
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lineScanner.close();
		}
	}
}

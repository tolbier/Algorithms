package com.tolbier.algorithms.course1.week4.kargerMinCut.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.tolbier.algorithms.course1.week4.kargerMinCut.AdjacencyList;
import com.tolbier.algorithms.course1.week4.kargerMinCut.Cut;
import com.tolbier.algorithms.course1.week4.kargerMinCut.Edge;
 
public class App {

	public static void main(String[] args) {
		int min = Integer.MAX_VALUE;
		for (int i=0;i<100;i++) {
			Scanner lineScanner = null;
			AdjacencyList adjacencyList = new AdjacencyList();
			try {
				lineScanner = new Scanner(new File("resources/course1/week4/kargerMinCut/kargerMinCut.txt"));
				while (lineScanner.hasNextLine()) {

					String line = lineScanner.nextLine();
					Scanner intScanner= new Scanner(line);
					int tailVertex = intScanner.nextInt();
					adjacencyList.addVertex(tailVertex-1);
					while (intScanner.hasNextInt()) {
						int headVertex = intScanner.nextInt();
						adjacencyList.addEdge(new Edge(tailVertex-1, headVertex-1));
					}
					intScanner.close();
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lineScanner.close();
			}
			
			Cut cut = Cut.minimumCut(adjacencyList);
			int numberOfEdges=  cut.getNumberOfEdges();
			System.out.print(numberOfEdges + " ");
			if (numberOfEdges<min) min = numberOfEdges;
			
		}
		System.out.print("\nMIN:"+ min);
	}
}

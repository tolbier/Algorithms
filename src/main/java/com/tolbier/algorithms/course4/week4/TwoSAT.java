package com.tolbier.algorithms.course4.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.course2.week1.kosaraju.Kosaraju;

public class TwoSAT {
	boolean satisfiable;
	public TwoSAT(String fileName) {
		Graph<Integer> graph = getGraphFromFile(fileName);
		Kosaraju kosaraju =new Kosaraju(graph);
		Map<Integer, Set<Integer>> sccMap =kosaraju.getSccMap();
		satisfiable = checkIfSatisfiableFromSccMap(sccMap);
	}

	private boolean checkIfSatisfiableFromSccMap(Map<Integer, Set<Integer>> sccMap) {
		boolean satisfiable = true; 
		for(Integer key:  sccMap.keySet()) {
			if (key==0) continue;
			satisfiable  =checkIfSatisfiableFromSccSet(sccMap.get(key));
			if (!satisfiable) return satisfiable;
		}
		return true;
			
		
	}

	private boolean checkIfSatisfiableFromSccSet(Set<Integer> sccSet) {
		for (Integer item :sccSet) {
			if (sccSet.contains(- item.intValue() )) return false;
		}
		return true;
	}

	public int getSatisfiable() {
		return satisfiable?1:0;
	}

	private Graph<Integer> getGraphFromFile(String filename) {
		Scanner scanner = null;
		Graph<Integer> graph = new Graph<Integer>(true);
		try {
			scanner = new Scanner(new File(filename));
			scanner.nextInt();
			while (scanner.hasNextInt()) {
				int tail = scanner.nextInt();

				if (scanner.hasNextInt()) {
					int head = scanner.nextInt() ;
					graph.addEdge(-tail, head);
					graph.addEdge(-head, tail);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return graph;
	}

}

package com.tolbier.algorithms.course3.week1.edges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;

public class GraphUtil {

	static Graph<Integer> getWeightedGraph(String filePath) {
		Graph<Integer> wg = new Graph<Integer>(false);
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File(filePath));
			intScanner.nextInt();
			intScanner.nextInt();
			while (intScanner.hasNextInt()) {
				Integer node1 = intScanner.nextInt();
				Integer node2 = intScanner.nextInt();
				Integer cost = intScanner.nextInt();
				wg.addEdge(node1, node2, cost);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return wg;
	}

	/*
	 * HEAP Algorithm O(m * log( n ))
	 * 
	 * G=(V,E) Initalize X={s} , s belongs to V, s chosen randomly
	 * 
	 * T= emptySet While X != V Let e:= (u,v) be the cheapest edge of G with u c X ,
	 * v !c X
	 * 
	 * Add e to T Add v to X EndWhile
	 */
	public static Integer getMSTTotalCost(String filePath) {
		Set<Edge<Integer>> set = getMSTSet(filePath);
		return set.stream().mapToInt(e -> e.getWeight()).sum();
	}

	public static Set<Edge<Integer>> getMSTSet(String filePath) {
		Graph<Integer> graph = GraphUtil.getWeightedGraph(filePath);
		int n = graph.getNumberOfVertices();
		//Vertex<Integer> s = graph.getVertex((int) (Math.random() * n) + 1) ;
		Vertex<Integer> s = graph.getVertex(1);
		Set<Vertex<Integer>> setX = new HashSet<Vertex<Integer>>();
		Set<Edge<Integer>> setT = new HashSet<Edge<Integer>>();
		setX.add(s);
		Vertex<Integer> u = s;
		PriorityQueue<Edge<Integer>> heap = new PriorityQueue<Edge<Integer>>(new EdgeCostComparator<Integer>());
		while (setX.size() < n) {
			// get Edges from v (new Vertex) and add to Heap those that go out of X

			u.getEdges().stream().filter(e -> validEdge(e, setX)).collect(Collectors.toList()).stream()
					.forEach(e -> heap.add(e));

			// get greedy edge
			Edge<Integer> e;
			do {
				e = heap.poll();
			} while (!validEdge(e, setX));

			Vertex<Integer> v = getVVertex(u, e);
			setT.add(e);
			setX.add(v);
			u = v;
		}
		return setT;
	}

	private static boolean validEdge(Edge<Integer> e, Set<Vertex<Integer>> setX) {
		return !setX.contains(e.getVertex1()) || !setX.contains(e.getVertex2());
	}

	private static Vertex<Integer> getVVertex(Vertex<Integer> u, Edge<Integer> e) {
		if (e.getVertex1().equals(u))
			return e.getVertex2();
		return e.getVertex1();
	}

}

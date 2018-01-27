package com.tolbier.algorithms.course3.week2.kCluster1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;

public class KCluster {

	Graph<Integer> wg ;
	
	int k;
	public KCluster(int k,String filePath) {
		super();
		wg = getWeightedGraph(filePath);
		this.k=k;
	}
	public int getMaximumSpacing() {
		IUnionFind vuf =new VertexUnionFind(wg.getNumberOfVertices());

		List<Edge<Integer>> edges= wg.getAllEdges();
		Collections.sort(edges, (a, b) -> Integer.compare(a.getWeight(),b.getWeight()));

		Iterator<Edge<Integer>> it = edges.iterator();
		Edge<Integer> e=null;
		while (it.hasNext() && vuf.numberOfSets()>=k) {
			e = it.next();
			une(vuf, e.getVertex1(),e.getVertex2());
		}

		return e.getWeight();
	}

	

	private int une(IUnionFind vuf, Vertex<Integer> u, Vertex<Integer> v) {
		return  vuf.union((int)u.getId(),(int)v.getId());
	}
	public static Graph<Integer> getWeightedGraph(String filePath) {
		Graph<Integer> wg = new Graph<Integer>(false);
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File(filePath));
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


}

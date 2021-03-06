package com.tolbier.algorithms.course2.week1.kosaraju;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.course2.week1.kosaraju.utils.MapUtil;
import com.tolbier.algorithms.course2.week1.kosaraju.utils.ReverseSequenceIntegerIterator;
import com.tolbier.algorithms.course2.week1.kosaraju.utils.StackPopIterator;

public class Kosaraju {

	Graph<Integer> graph;

	Set<Integer> explored;
	Iterator<Integer> sequencer;
	Stack<Integer> timeOrdered;
	Map<Integer, Set<Integer>> sccMap;
	int[] sizes;

	protected int[] getSizes() {
		return sizes;
	}

	public Kosaraju(Graph<Integer> graph) {
		this.graph = graph;
		execute();
	}

	public Kosaraju(String fileName) {
		graph = getGraphFromFile(fileName);
		execute();
	}

	private void execute() {
		kosaraju(graph);
		analyzeSizes();
	}

	private void analyzeSizes() {
		int[] sizes = new int[sccMap.keySet().size()];
		int i = 0;
		for (Integer key : sccMap.keySet()) {
			int size = sccMap.get(key).size();
			if (size == 1)
				size = 0;
			sizes[i++] = size;
		}
		Arrays.sort(sizes);
		this.sizes = new int[5];
		for (int j = 0; j < 5 && j < sizes.length; j++) {
			this.sizes[j] = sizes[sizes.length - 1 - j];
		}
	}

	private void kosaraju(Graph<Integer> graph) {
		Graph<Integer> graphRev = graph.reverseClone();
		sequencer = new ReverseSequenceIntegerIterator(graph.getNumberOfVertices()+1);
		DFSLoop(graphRev);
		sequencer = getStackPopIterator();
		DFSLoop(graph);

	}

	Iterator<Integer> getStackPopIterator() {
		return new StackPopIterator<Integer>(timeOrdered);
	}

	public void DFSLoop(Graph<Integer> graph) {
		sccMap = new HashMap<Integer, Set<Integer>>();
		timeOrdered = new Stack<Integer>();
		explored = new HashSet<Integer>();
		while (sequencer.hasNext()) {
			Integer i = sequencer.next();
			if (isNotExplored(i)) {
				DFS(graph, i, i);
			}
		}
	}

	public void DFS(Graph<Integer> graph, Integer i, Integer s) {
		explored.add(i);
		addToSCC(s, i);
		Vertex<Integer> vertexI = graph.getVertex(i);
		if (vertexI != null) {
			List<Vertex<Integer>> adjacentsFromI = vertexI.getAdjacentVertexes();
			if (adjacentsFromI != null) {
				Iterator<Vertex<Integer>> vertexIterator = adjacentsFromI.iterator();
				while (vertexIterator.hasNext()) {
					Vertex<Integer> v = vertexIterator.next();
					int j = (int) v.getId();
					if (!i.equals(j) && isNotExplored(j)) {
						DFS(graph, j, s);
					}

				}
			}
		}
		timeOrdered.push(i);
	}

	private void addToSCC(Integer s, Integer i) {
		Set<Integer> scc = sccMap.get(s);
		if (scc == null) {
			scc = new HashSet<Integer>();
			sccMap.put(s, scc);
		}
		scc.add(i);

	}

	private boolean isNotExplored(Integer i) {
		return !explored.contains(i);
	}

	private Graph<Integer> getGraphFromFile(String filename) {
		Scanner scanner = null;
		Graph<Integer> graph = new Graph<Integer>(true);
		try {
			scanner = new Scanner(new File(filename));

			while (scanner.hasNextInt()) {
				int tail = scanner.nextInt() - 1;

				if (scanner.hasNextInt()) {
					int head = scanner.nextInt() - 1;
					if (tail != head) {
						graph.addEdge(tail, head);
					}
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

	public Map<Integer, Set<Integer>> getSccMap() {
		return sccMap;
	}

	protected Graph<Integer> getGraph() {
		return graph;
	}

}

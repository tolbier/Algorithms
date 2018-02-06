package com.tolbier.algorithms.course3.week3.exercise1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.commons.Vertex;

public class HuffmanGraph {
	Alphabet<Long> sigma;
	Graph<Long> graph ; 
	Node<Long> nodeRoot = null;
	int min=0;
	int max=0;
	
	NodeSequencer seq = new NodeSequencer();
	public HuffmanGraph(String filePath) {
		graph= createGraphFromFilePath(filePath);
		sigma = Alphabet.createAlphabetFromGraph(graph);
		createTree();
		analyzeMinMax();
	}

	private void analyzeMinMax() {
		int minMax[] = getMinMax(nodeRoot);
		min = minMax[0];
		max = minMax[1];
	}
	private int[] getMinMax(Vertex<Long> node) {
		int[] minMax = new int[] {0,0};
		List <Vertex<Long >> list = node.getAdjacentVertexes();
		
		if (!list.isEmpty()) {
			int[] nodeMinMax0 = getMinMax(list.get(0));
			int[] nodeMinMax1 = getMinMax(list.get(1));
			
			minMax[0] = Math.min(nodeMinMax0[0],nodeMinMax1[0] )+1;
			minMax[1] = Math.max(nodeMinMax0[1],nodeMinMax1[1] )+1;
		}
		return minMax;
	}
	public  void createTree(){
		while (sigma.size()>1) {
			Node<Long>  nodeA =sigma.poll();
			Node<Long>  nodeB =sigma.poll();
			
			int idRoot= seq.next();
			nodeRoot= new Node<Long> (
											idRoot,
											nodeA.getData().longValue() + nodeB.getData().longValue());
			sigma.add(nodeRoot);
			graph.addVertex(nodeRoot);
			graph.addEdge(nodeRoot.getId(), nodeA.getId(), 0);
			graph.addEdge(nodeRoot.getId(), nodeB.getId(), 1);
			
		}

		
	}

	public int maxWordLength() {
		return 5;
	}
	public Graph<Long> createGraphFromFilePath(String filePath) {
		Graph<Long> graph = new Graph<Long>(true); ;
		Scanner intScanner = null;

		try {
			intScanner = new Scanner(new File(filePath));
			int n = intScanner.nextInt();
			for (int i = 0; i < n; i++) {
				long weight = intScanner.nextLong();
				graph.addVertex(new Node<Long>(seq.next(),weight));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return graph;
	}

	public int getMax() {
		return max;
	}

	public Object getMin() {
		return min;
	}
}

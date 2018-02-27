package com.tolbier.algorithms.course4.week1.sp;

import java.util.Arrays;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.course4.week1.exceptions.HasNegativeCyclesException;

public class BellmanFord {
	Graph<Integer> graph ;
	int source ;
	int prevLengthsArr[], currLengthsArr[];

	public BellmanFord(Graph<Integer> graph, int source) throws HasNegativeCyclesException {
		this.graph= graph;
		this.source = source;
		parseGraph();
	}

	private void parseGraph() throws HasNegativeCyclesException {
		/*
		 * Let A = 2d Array  (idx by i,v)
		 *
		 * Base Case  A[0,s]=0 , A[0,v] = INFINITE for all v<>s
		 * 
		 * For i = 1 TO n-1
		 * 		For each v in V
		 * 			a[i,v] = min ( a[i-1,v]
		 *                         min( A[i-1,w] + Ce) for edge e(w,v) ) 
		 */		
		int n = graph.getNumberOfVertices();
		int maxId=(int)graph.getMaxId();
		currLengthsArr= createInitCurrLengthArr(n);
		int i =1;
		boolean prevAndCurrAreEqual=false;
		while (i<=n && !prevAndCurrAreEqual) {
			prevLengthsArr=currLengthsArr;
			currLengthsArr=new int[maxId+1];
			for (Vertex<Integer> v :graph.getAllVertex()) {
				int vId=(int)v.getId();
				int case1Value= prevLengthsArr[vId]; // a[i-1,v]
				int case2Value = getMinimumCase2(v);
				currLengthsArr[vId] =Math.min(case1Value, case2Value);
			}
			prevAndCurrAreEqual = Arrays.equals(prevLengthsArr,currLengthsArr); 
			i++;
		}
		if (!prevAndCurrAreEqual) {
			throw new HasNegativeCyclesException();
		}
	}

	private int getMinimumCase2(Vertex<Integer> v) {
		// return min( A[i-1,w] + Ce) for edge e(w,v)
		int minValue=Integer.MAX_VALUE;
		for (Edge<Integer> inEdge :  v.getInEdges()) {
			int wId=(int)inEdge.getVertex1().getId();
			int prevVertexLength=  prevLengthsArr[wId];
			int newValue = sumWeights(prevVertexLength,inEdge.getWeight());
			if (newValue<minValue) minValue=newValue;
		}
		return minValue;
	}
	private int sumWeights(int a, int b) {
		if (a==Integer.MAX_VALUE || b==Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return a+b;
	}

	private int[] createInitCurrLengthArr(int n ) {
		int[] currLengthsArr;	
		currLengthsArr = new int [n+1];
		for (int i=1;i<=n;i++) {
			currLengthsArr[i] =Integer.MAX_VALUE;
		}
		currLengthsArr[source] =0;
		return currLengthsArr;
	}

	protected Graph<Integer> getGraph() {
		return graph;
	}

	public Integer getShortestPathLengthTo(int vertexId) {
		return currLengthsArr[vertexId];
	}

	public int[] getLengthsArr() {
		return currLengthsArr;
	}

	
}


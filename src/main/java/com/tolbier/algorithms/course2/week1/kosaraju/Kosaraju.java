package com.tolbier.algorithms.course2.week1.kosaraju;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.tolbier.algorithms.course2.week1.kosaraju.utils.ReverseSequenceIntegerIterator;
import com.tolbier.algorithms.course2.week1.kosaraju.utils.StackPopIterator;

public class Kosaraju {
	Set<Integer> explored;
	Stack<Integer> timeOrdered;
	Iterator<Integer> sequencer;
	Map<Integer,Set<Integer>> sccMap;

	public Map<Integer,Set<Integer>> kosaraju(Graph graph, Graph graphRev) {
		sequencer = getReverseSequenceIntegerIterator(graph);
		DFSLoop(graphRev);
		sequencer = getStackPopIterator();
		DFSLoop(graph);
		return sccMap;
	}

	public void DFSLoop(Graph graph) {
		sccMap=new HashMap<Integer,Set<Integer>>();
		timeOrdered = new Stack<Integer>();
		explored = new HashSet<Integer>();
		while (sequencer.hasNext()) {
			Integer i = sequencer.next();
			if (isNotExplored(i)) {
				DFS(graph, i,i);
			}
		}
	}

	public void DFS(Graph graph, Integer i,Integer s) {
		explored.add(i);
		addToSCC(s,i);
		Set<Integer> arcsSet =graph.getArcsSet(i);
		if (arcsSet!=null) {
			Iterator<Integer> arcsIterator= arcsSet.iterator();
			while (arcsIterator.hasNext()) {
				Integer j = arcsIterator.next();
				if (!i.equals(j) && isNotExplored(j)) {
					DFS(graph, j,s);
				}
	
			}
		}
		timeOrdered.push(i);
	}

	private void addToSCC(Integer s, Integer i) {
		Set<Integer> scc= sccMap.get(s);
		if (scc==null) {
			scc= new HashSet<Integer>();
			sccMap.put(s, scc);
		}
		scc.add(i);
		
		
	}

	private boolean isNotExplored(Integer i) {
		
		return !explored.contains(i);
	}

	Iterator<Integer> getReverseSequenceIntegerIterator(Graph graph) {

		return new ReverseSequenceIntegerIterator(graph.getVerticesSize());

	}

	Iterator<Integer> getStackPopIterator() {

		return new  StackPopIterator<Integer>(timeOrdered);

	}

	protected Map<Integer, Set<Integer>> getSccMap() {
		return sccMap;
	}

	@Override
	public String toString() {
		return  sccMap.toString();
	}
}

package com.tolbier.algorithms.course4.week1.apsp.algorithms;

import java.util.Map;
import java.util.Map.Entry;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.course2.week2.dijkstra.Dijkstra;
import com.tolbier.algorithms.course4.week1.GraphReader;
import com.tolbier.algorithms.course4.week1.exceptions.HasNegativeCyclesException;
import com.tolbier.algorithms.course4.week1.sp.BellmanFord;

public class JohnsonAlgorithm implements IAPSPAlgorithm{
	private Graph<Integer> graph;
	private Graph<Integer> graphB;
	Integer shortestPathLength;
	
	public JohnsonAlgorithm(String fileName) {
		super();
		graph = GraphReader.createDirectedGraphFromFilePath(fileName);
		graphB = GraphReader.createDirectedGraphFromFilePath(fileName);
	}

	public Graph<Integer> getGraph() {
		return graph;
	}

	public void setGraph(Graph<Integer> graph) {
		this.graph = graph;
	}

	@Override
	public Integer getShortestPathLength() {
		return shortestPathLength;
	}

	protected void setShortestPathLength(Integer shortestPathLength) {
		this.shortestPathLength = shortestPathLength;
	}

	@Override
	public void execute()  {
		setShortestPathLength(null);
		addShadowVector0ToGraphB();
		// Calculate BellmanFord in GraphB from S=0
		int p[] ;
		try {
			p=createLengthsArrayOfSPinGraphB();
		} catch (HasNegativeCyclesException e) {
			return;
		}
		
		for (Edge<Integer> edge:graph.getAllEdges()) {
			edge.setWeight(edge.getWeight()+p[(int)edge.getVertex1().getId()]-p[(int)edge.getVertex2().getId()]);
		}
		shortestPathLength=Integer.MAX_VALUE;
		for (Vertex<Integer> vertex:graph.getAllVertex()) {
			Dijkstra dijkstra = new Dijkstra();
			Map<Vertex<Integer>,Integer> shortestPaths= dijkstra.dijkstraHeapShortestDistances(graph,(int)vertex.getId());
			
			for (Entry<Vertex<Integer>, Integer> shortestPath: shortestPaths.entrySet()) {
				Vertex<Integer> vertex2= shortestPath.getKey();
				int length= shortestPath.getValue()-p[(int)vertex.getId()] +p[(int)vertex2.getId()];
				if (length<shortestPathLength) shortestPathLength = length;
			}
		}
		
		
		
		
 		
	}
	private int[] createLengthsArrayOfSPinGraphB() throws HasNegativeCyclesException {
		
		BellmanFord bellmanFord;
		bellmanFord = new BellmanFord(graphB,0);
   	    return bellmanFord.getLengthsArr();
		
	}



	private void addShadowVector0ToGraphB() {
		// Add Shadow S Vector with edges0 up to every Graph Vertex
		int n = graphB.getNumberOfVertices();
 		for (int i=1; i<=n; i++) {
 			graphB.addEdge(0, i, 0);
 		}
	}


	


}

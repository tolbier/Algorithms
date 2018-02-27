package com.tolbier.algorithms.course4.week1.apsp.algorithms;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.course4.week1.exceptions.HasNegativeCyclesException;

public interface IAPSPAlgorithm {

	public Graph<Integer> getGraph() ;
	public void setGraph(Graph<Integer> graph) ;
	public Integer getShortestPathLength();
	public void execute() ;
}

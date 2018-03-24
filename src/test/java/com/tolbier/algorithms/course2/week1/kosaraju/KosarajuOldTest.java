package com.tolbier.algorithms.course2.week1.kosaraju;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class KosarajuOldTest {

	KosarajuOld kosaraju;
	Graph graph;
	@Before
	public void init() {
		kosaraju = new KosarajuOld();
		graph=new Graph(9);
		graph.addArc(0,4);
		graph.addArc(1,2);
		graph.addArc(2,3);
		graph.addArc(3,1);
		graph.addArc(3,4);
		graph.addArc(3,3);
		graph.addArc(4,5);
		graph.addArc(5,8);
		graph.addArc(5,0);
		graph.addArc(6,7);
		graph.addArc(7,8);
		graph.addArc(8,6);
		graph.addArc(8,8);
		

	}

	//@Test
	public void testKosaraju() {
		assertNotNull(kosaraju);
		kosaraju.kosaraju(graph, graph.reverse());
		assertEquals("{3=[1, 2, 3], 5=[0, 4, 5], 8=[6, 7, 8]}",kosaraju.toString());
		kosaraju.kosaraju(graph, graph.reverse());
		assertEquals("{3=[1, 2, 3], 5=[0, 4, 5], 8=[6, 7, 8]}",kosaraju.toString());
		kosaraju.kosaraju(graph.reverse(), graph);
		assertEquals("{3=[1, 2, 3], 5=[0, 4, 5], 8=[6, 7, 8]}",kosaraju.toString());
		
	}

	
}

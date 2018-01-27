package com.tolbier.algorithms.course3.week2.kCluster1;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.course3.week2.kCluster1.IUnionFind;
import com.tolbier.algorithms.course3.week2.kCluster1.KCluster;
import com.tolbier.algorithms.course3.week2.kCluster1.VertexUnionFind;

public class VertexUnionFindTest {
	Graph<Integer> g;
	
	IUnionFind vuf;

	@Before
	public void init() {
		
		g = KCluster.getWeightedGraph("resources/course3/week2/exercise1/input_completeRandom_1_8.txt");
		vuf=new VertexUnionFind(g.getNumberOfVertices()); 

	}

	@Test
	public void testCreateUnionFind() {
		assertNotNull(vuf);
	}
	@Test
	public void testInitGetNumberOfVerticesCheck() {
		assertEquals(g.getNumberOfVertices(), vuf.numberOfSets());
	}

	@Test
	public void testInitValuesCheck() {
		for (int i  = 1 ; i<= vuf.numberOfSets();i++) {
			assertEquals(i,vuf.find(i));
		}
	}
	@Test
	public void testUnion() {
		int i = vuf.union(1, 2);
		assertEquals(2,i);
	    i = vuf.union(1, 3);
		assertEquals(2,i);
		i = vuf.union(4, 5);
		assertEquals(5,i);
		i = vuf.union(5,6);
		assertEquals(5,i);
		assertEquals(4,vuf.numberOfSets());
		assertEquals(2,vuf.find(1));
		assertEquals(2,vuf.find(2));
		assertEquals(2,vuf.find(3));
		assertEquals(5,vuf.find(4));
		assertEquals(5,vuf.find(5));
		assertEquals(5,vuf.find(6));
		assertEquals(7,vuf.find(7));
		assertEquals(8,vuf.find(8));
		assertEquals(3,vuf.rank(1));
		assertEquals(3,vuf.rank(2));
		assertEquals(3,vuf.rank(3));
		assertEquals(3,vuf.rank(4));
		assertEquals(3,vuf.rank(5));
		assertEquals(3,vuf.rank(6));
		assertEquals(1,vuf.rank(7));
		assertEquals(1,vuf.rank(8));
		i = vuf.union(6,1);
		assertEquals(2,i);
		assertEquals(3,vuf.numberOfSets());
		assertEquals(2,vuf.find(1));
		assertEquals(2,vuf.find(2));
		assertEquals(2,vuf.find(3));
		assertEquals(2,vuf.find(4));
		assertEquals(2,vuf.find(5));
		assertEquals(2,vuf.find(6));
		assertEquals(7,vuf.find(7));
		assertEquals(8,vuf.find(8));
		assertEquals(6,vuf.rank(1));
		assertEquals(6,vuf.rank(2));
		assertEquals(6,vuf.rank(3));
		assertEquals(6,vuf.rank(4));
		assertEquals(6,vuf.rank(5));
		assertEquals(6,vuf.rank(6));
		assertEquals(1,vuf.rank(7));
		assertEquals(1,vuf.rank(8));
		
		
		
		

	}

}

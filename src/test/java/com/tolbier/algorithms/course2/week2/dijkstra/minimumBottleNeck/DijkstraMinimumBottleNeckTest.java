package com.tolbier.algorithms.course2.week2.dijkstra.minimumBottleNeck;


import static org.junit.Assert.assertEquals;
import java.util.Map;


import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;



public class DijkstraMinimumBottleNeckTest {


	@Test
	public void testDijkstraHeapShortestPaths1() {
		Graph<Integer> graph =DijkstraMinimumBottleNeck.getWeightedGraph("resources/course2/week2/dijkstraTest1.txt"); 
		Map<Vertex<Integer>,Integer> mininumBottleNecks= DijkstraMinimumBottleNeck.dijkstraMininumBottleNecks(graph,1);
		assertEquals("{1=0, 2=1, 3=1, 4=1, 5=1, 6=1, 7=1, 8=1}",mininumBottleNecks.toString());
	}
	@Test
	public void testDijkstraHeapShortestPaths2() {
		Graph<Integer> graph =DijkstraMinimumBottleNeck.getWeightedGraph("resources/course2/week2/dijkstraData.txt"); 
		Map<Vertex<Integer>,Integer> mininumBottleNecks= DijkstraMinimumBottleNeck.dijkstraMininumBottleNecks(graph,1);
		assertEquals("662,648,761,647,761,983,836,897,647,751", 
				generateTestString(new int [] {7,37,59,82,99,115,133,165,188,197},mininumBottleNecks ));
	}

	private String generateTestString(int[] is, Map<Vertex<Integer>, Integer> shortestPaths) {
		StringBuilder sb = new StringBuilder();
		for (int i :is) {
			sb.append( shortestPaths.get(new Vertex<Integer>(i)).intValue());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}

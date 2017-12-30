package com.tolbier.algorithms.course2.week2.dijkstra;


import static org.junit.Assert.assertEquals;
import java.util.Map;


import org.junit.Test;



public class DijkstraTest {


	@Test
	public void testDijkstraStraightShortestPaths1() {
		Graph<Integer> graph =Dijkstra.getWeightedGraph("resources/course2/week2/dijkstraTest1.txt"); 
		Map<Vertex<Integer>,Integer> shortestPaths= Dijkstra.dijkstraStraightShortestDistances(graph,1);
		assertEquals("{1=0, 2=1, 3=2, 4=3, 5=4, 6=4, 7=3, 8=2}",shortestPaths.toString());
	}
	@Test
	public void testDijkstraStraightShortestPaths2() {
		Graph<Integer> graph =Dijkstra.getWeightedGraph("resources/course2/week2/dijkstraData.txt"); 
		Map<Vertex<Integer>,Integer> shortestPaths= Dijkstra.dijkstraStraightShortestDistances(graph,1);
		assertEquals("2599,2610,2947,2052,2367,2399,2029,2442,2505,3068", 
				generateTestString(new int [] {7,37,59,82,99,115,133,165,188,197},shortestPaths ));
	}
	@Test
	public void testDijkstraHeapShortestPaths1() {
		Graph<Integer> graph =Dijkstra.getWeightedGraph("resources/course2/week2/dijkstraTest1.txt"); 
		Map<Vertex<Integer>,Integer> shortestPaths= Dijkstra.dijkstraHeapShortestDistances(graph,1);
		assertEquals("{1=0, 2=1, 3=2, 4=3, 5=4, 6=4, 7=3, 8=2}",shortestPaths.toString());
	}
	@Test
	public void testDijkstraHeapShortestPaths2() {
		Graph<Integer> graph =Dijkstra.getWeightedGraph("resources/course2/week2/dijkstraData.txt"); 
		Map<Vertex<Integer>,Integer> shortestPaths= Dijkstra.dijkstraHeapShortestDistances(graph,1);
		assertEquals("2599,2610,2947,2052,2367,2399,2029,2442,2505,3068", 
				generateTestString(new int [] {7,37,59,82,99,115,133,165,188,197},shortestPaths ));
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

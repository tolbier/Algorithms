package com.tolbier.algorithms.course2.week2.dijkstra;

public class WeightedEdge {
	int head;
	int weight;
	public WeightedEdge(int head, int weight) {
		super();
		this.head = head;
		this.weight = weight;
	}
	protected int getHead() {
		return head;
	}
	protected int getWeight() {
		return weight;
	}
	@Override
	public String toString() {
		return "[" + head + "," + weight + "]";
	}
	
}

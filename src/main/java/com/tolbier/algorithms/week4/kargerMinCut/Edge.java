package com.tolbier.algorithms.week4.kargerMinCut;

public class Edge {
	private int tailVertex, headVertex,order;


	public Edge(int tailVertex, int headVertex) {
		super();
		this.tailVertex = tailVertex;
		this.headVertex = headVertex;
		this.order = 0;
	}
	public Edge(int tailVertex, int headVertex, int order) {
		super();
		this.tailVertex = tailVertex;
		this.headVertex = headVertex;
		this.order = order;
	}
	protected void setVertices(int tailVertex,int headVertex) {
		this.tailVertex = tailVertex;
		this.headVertex = headVertex;
	}

	protected int getTailVertex() {
		return tailVertex;
	}

	protected void setTailVertex(int tailVertex) {
		this.tailVertex = tailVertex;
	}

	protected int getHeadVertex() {
		return headVertex;
	}

	protected void setHeadVertex(int headVertex) {
		this.headVertex = headVertex;
	}

	protected int getOrder() {
		return order;
	}
	protected void setOrder(int order) {
		this.order = order;
	}
}

package com.tolbier.algorithms.week4.kargerMinCut;

public class Edge {
	private int tail, head;


	public Edge(int tail, int head) {
		super();
		this.tail = tail;
		this.head= head;
	}
	protected void setVertices(int tail,int head) {
		this.tail = tail;
		this.head = head;
	}

	protected int getTail() {
		return tail;
	}

	protected void setTail(int tail) {
		this.tail = tail;
	}

	protected int getHead() {
		return head;
	}

	protected void setHead(int head) {
		this.head = head;
	}

	
	@Override
	public String toString() {
		return "[" + tail + "," + head + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + head;
		result = prime * result + tail;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (head != other.head)
			return false;
		if (tail != other.tail)
			return false;
		return true;
	}
	
}

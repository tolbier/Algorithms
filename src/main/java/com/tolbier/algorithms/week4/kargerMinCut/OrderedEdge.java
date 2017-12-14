package com.tolbier.algorithms.week4.kargerMinCut;

public class OrderedEdge extends Edge {

	private int order;
	
	public OrderedEdge(int tail, int head, int order) {
		super(tail, head);
		this.order=order;
	}
	public OrderedEdge(Edge edge,int order) {
		super(edge.getTail(),edge.getHead());
		this.order=order;
	}
	protected int getOrder() {
		return order;
	}
	protected void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "[" + this.getTail() + "," + getHead() + "," + getOrder()+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + order;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedEdge other = (OrderedEdge) obj;
		if (order != other.order)
			return false;
		return true;
	}
}

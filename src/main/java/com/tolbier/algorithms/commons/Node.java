package com.tolbier.algorithms.commons;

public class Node<T> extends Vertex<T> {

	public Node(long id, T data) {
		super(id);
		this.setData(data);
	}

	@Override
	public String toString() {
		return "[" + this.getId() + "," + this.getData() + "]";
	}

}

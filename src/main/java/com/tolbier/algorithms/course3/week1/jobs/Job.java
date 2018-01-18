package com.tolbier.algorithms.course3.week1.jobs;

public class Job {
	private int length;
	private int weight;

	public Job(int weight, int length) {
		super();
		this.length = length;
		this.weight = weight;
	}

	protected Integer getLength() {
		return length;
	}

	protected Integer getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "[w:" + weight + ", l:" +  length + "]";
	}

	

}

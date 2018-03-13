package com.tolbier.algorithms.commons.tsp;

public class DoublePoint extends Point<Double> {

	public DoublePoint(Double x, Double y) {
		super(x, y);
	}

	public double distanceTo(DoublePoint point) {
		double result = Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
		return result;
	}
	public double euclideanSquared(DoublePoint point) {
		double result = Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2);
		return result;
	}
	
}

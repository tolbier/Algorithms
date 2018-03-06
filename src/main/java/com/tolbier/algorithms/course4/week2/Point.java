package com.tolbier.algorithms.course4.week2;

public abstract class Point<T> {
	T x;
	T y;
	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}
	protected T getX() {
		return x;
	}
	protected T getY() {
		return y;
	}
	protected void setX(T x) {
		this.x = x;
	}
	protected void setY(T y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	
}

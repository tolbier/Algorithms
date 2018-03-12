package com.tolbier.algorithms.commons.tsp;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		Point other = (Point) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
	
}

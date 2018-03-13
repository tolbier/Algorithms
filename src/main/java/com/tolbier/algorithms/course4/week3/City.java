package com.tolbier.algorithms.course4.week3;

import com.tolbier.algorithms.commons.tsp.DoublePoint;

public class City {
	DoublePoint coordinates;
	int idx;

	public City(int idx, DoublePoint coordinates) {
		super();
		this.coordinates = coordinates;
		this.idx = idx;
	}

	protected DoublePoint getCoordinates() {
		return coordinates;
	}

	protected int getIdx() {
		return idx;
	}

	protected void setCoordinates(DoublePoint coordinates) {
		this.coordinates = coordinates;
	}

	protected void setIdx(int idx) {
		this.idx = idx;
	}

	public double distanceTo(City city) {
		return this.coordinates.distanceTo(city.getCoordinates());
		
	}

	public double euclideanSquared(City city) {
		return this.coordinates.euclideanSquared(city.getCoordinates());
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
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
		City other = (City) obj;
		if (idx != other.idx)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idx+":"+ coordinates + " ";
	}
	

}

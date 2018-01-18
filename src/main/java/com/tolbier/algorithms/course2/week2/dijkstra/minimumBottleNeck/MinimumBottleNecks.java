package com.tolbier.algorithms.course2.week2.dijkstra.minimumBottleNeck;

import java.util.HashMap;

import com.tolbier.algorithms.commons.Vertex;

public class MinimumBottleNecks extends HashMap<Vertex<Integer>, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8597988894527411901L;

	@Override
	public Integer get(Object key) {
		Integer distance  = super.get(key);
		if (null == distance) {
			distance= Integer.MAX_VALUE;
		}
		return distance;
	}
	

}

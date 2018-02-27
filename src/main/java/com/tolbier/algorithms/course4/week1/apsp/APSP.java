package com.tolbier.algorithms.course4.week1.apsp;

import com.tolbier.algorithms.course4.week1.apsp.algorithms.IAPSPAlgorithm;

public class APSP {

	private IAPSPAlgorithm apspAlgorithm;

	
	public APSP(IAPSPAlgorithm apspAlgorithm) {
		
		this.apspAlgorithm = apspAlgorithm;
		this.apspAlgorithm.execute();
		
	}

	public Integer getShortestPathLength() {
		return apspAlgorithm.getShortestPathLength();
	}

}

package com.tolbier.algorithms.course3.week1.jobs;

public class JobSubstractComparator extends JobComparator  {

	@Override
	public float score(Job j1) {
		return j1.getWeight()-j1.getLength();
	}


	
}

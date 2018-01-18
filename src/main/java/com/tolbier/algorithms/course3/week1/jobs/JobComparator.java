package com.tolbier.algorithms.course3.week1.jobs;

import java.util.Comparator;

public abstract class JobComparator implements Comparator<Job> {
	@Override
	public int compare(Job j1, Job j2) {
		Float s1 = score(j1);
		Float s2 = score(j2);
		return s1.equals(s2) ? compareWeight(j1, j2) : s2.compareTo(s1);
	}

	int compareWeight(Job j1, Job j2) {
		return j2.getWeight().compareTo(j1.getWeight());
	}

	public abstract float score(Job j1);

}

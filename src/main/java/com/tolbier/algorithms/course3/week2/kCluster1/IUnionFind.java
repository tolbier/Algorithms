package com.tolbier.algorithms.course3.week2.kCluster1;

public interface IUnionFind {

	public int find(int i) ;

	public int union(int u, int v) ;

	public int numberOfSets();
    
	public int rank(int u);
}

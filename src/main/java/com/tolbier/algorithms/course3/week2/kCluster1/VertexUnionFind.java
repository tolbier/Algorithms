package com.tolbier.algorithms.course3.week2.kCluster1;

public class VertexUnionFind  implements IUnionFind{

	IUnionFind uf; 
	public VertexUnionFind(int n) {
		uf= new UnionFind(n);
	}

	@Override
	public int find(int i) {
		return uf.find(i - 1) + 1;
	}

	@Override
	public int union(int u, int v) {
		return uf.union(u - 1, v - 1) + 1;
	}

	@Override
	public int numberOfSets() {
		return uf.numberOfSets();
	}

	@Override
	public int rank(int u) {
		return uf.rank(u-1);
	}
}

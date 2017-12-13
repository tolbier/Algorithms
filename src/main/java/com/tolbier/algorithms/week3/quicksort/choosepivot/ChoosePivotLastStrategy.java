package com.tolbier.algorithms.week3.quicksort.choosepivot;

public class ChoosePivotLastStrategy implements ChoosePivotStrategy{
	public int choosePivot(int[] arr,int l, int r) {
		return r;
	}
}
package com.tolbier.algorithms.week3.quicksort.choosepivot;

public interface ChoosePivotStrategy{
	int choosePivot(int[] arr,int l, int r);
}
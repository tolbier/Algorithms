package com.tolbier.algorithms.week3.quicksort.choosepivot;

import java.util.Random;

public class ChoosePivotRandomStrategy implements ChoosePivotStrategy{
	Random rn = new Random();
	public int choosePivot(int[] arr,int l, int r) {
		return rn.nextInt(r-l+1) + l;
	}

}
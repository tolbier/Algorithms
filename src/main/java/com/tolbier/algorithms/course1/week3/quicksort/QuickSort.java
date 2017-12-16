package com.tolbier.algorithms.course1.week3.quicksort;

import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotStrategy;
import com.tolbier.algorithms.course1.week3.quicksort.utils.Util;

public class QuickSort {
	ChoosePivotStrategy strategy;
	long comparisonsNumber=0;
	
	public QuickSort(ChoosePivotStrategy strategy) {
		super();
		this.strategy = strategy;
	}
	public int[] sort(int[] arr) {
		sort(arr,0,arr.length-1);
		return arr;
	}
	protected int[] sort(int[] arr,int l , int r) {
		if (l>=r) return arr ;
		comparisonsNumber+=(r-l);
		int i = strategy.choosePivot(arr,l,r);
		Util.swap(arr,l,i);
		int j = partition(arr,l,r);
		sort(arr,l,j-1);
		sort(arr,j+1,r);
		
		return arr;
	}
	


	protected  int partition(int[] arr, int l, int r) {
		int p = arr[l];
		int i=l+1;
		for (int j=l+1;j<=r;j++) {
			if (arr[j]<p) {
				Util.swap(arr,j,i++);
			}
		}
		Util.swap(arr,l,i-1);
		return i-1;
	}
	
}
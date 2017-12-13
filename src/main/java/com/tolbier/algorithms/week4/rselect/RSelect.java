package com.tolbier.algorithms.week4.rselect;

import java.util.Arrays;

import com.tolbier.algorithms.week3.quicksort.choosepivot.ChoosePivotStrategy;
import com.tolbier.algorithms.week3.quicksort.utils.Util;

public class RSelect {
	ChoosePivotStrategy strategy;
	
	public RSelect(ChoosePivotStrategy strategy) {
		super();
		this.strategy = strategy;
	}
	public int rSelect(int[] a, int i) {
		return rSelect(a.clone(),0,a.length-1,i);
	}

//	public int rSelectCopying(int[] a, int i) {
//		int [] arr = a.clone();
//		int n = arr.length;
//		if (n==1) return arr[0] ;
//		int p = strategy.choosePivot(arr,0,n-1);
//		Util.swap(arr,0,p);
// 		int j = partition(arr,0,n-1);
// 		
//		if (j==i) return arr[j];
//		if (j>i) return rSelectCopying(Arrays.copyOfRange(arr, 0, j),i);
//		return rSelectCopying(Arrays.copyOfRange(arr, j+1, n),i-j-1);
//	}
	public int rSelect(int[] a, int l,int r, int i) {
		int n = r-l+1;
		if (n==1) return a[l] ;
		int p = strategy.choosePivot(a,l,r);
		Util.swap(a,l,p);
 		int j = partition(a,l,r);
 		int k = j-l;
		if (k==i) return a[j];
		if (k>i) return rSelect(a,l,j-1,i);
		return rSelect(a, j+1, r,i-k-1);
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
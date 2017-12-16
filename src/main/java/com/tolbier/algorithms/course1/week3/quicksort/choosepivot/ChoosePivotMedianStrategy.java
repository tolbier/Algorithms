package com.tolbier.algorithms.course1.week3.quicksort.choosepivot;

import com.tolbier.algorithms.course1.week3.quicksort.utils.Util;

public class ChoosePivotMedianStrategy implements ChoosePivotStrategy{
	public int choosePivot(int[] arr,int l, int r) {
		
		int m=getMiddle(l,r);
		int[] triad= {l,m,r};
		int n=3;
		for (int i=n-1;i>0;i--) {
			for (int j=0;j<i;j++) {
				if (arr[triad[j]]>arr[triad[j+1]]) {
					Util.swap(triad,j,j+1);
				}
			}
		}
		return triad[1];
	}
	
	
	protected int getMiddle(int l, int r) {
		return (int)Math.ceil((double)((r-l)+1)/2)-1 + l ;
	}

}
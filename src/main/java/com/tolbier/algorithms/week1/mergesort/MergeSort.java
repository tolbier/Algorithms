package com.tolbier.algorithms.week1.mergesort;

import java.util.Arrays;

public class MergeSort {

	public static int[] sort(int[] arr) {
		int l = arr.length;
		if (l<=1) return arr;
		int h1[]= sort(Arrays.copyOfRange(arr,0, l/2));
		int h2[]= sort(Arrays.copyOfRange(arr, l/2,l));
		int result[]= merge(h1,h2);
		
		return result;
	}
	
	public static int[] merge(int[] arr1,int[] arr2) {
		int l1 = arr1.length;
		int l2 = arr2.length;
		int i1=0,i2=0;
		int result[] = new int[l1+l2];
		for (int i = 0;i<result.length;i++) {
			result[i] = ((i1<l1) &&
							((i2>=l2) ||
							    arr1[i1]<=arr2[i2]))
							    		?arr1[i1++]
										:arr2[i2++];
		}
		return result;
	}

}

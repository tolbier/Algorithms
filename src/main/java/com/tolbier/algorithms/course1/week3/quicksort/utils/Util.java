package com.tolbier.algorithms.course1.week3.quicksort.utils;

public class Util{
	public static void swap (int[] arr, int a, int b ) {
		int aux =arr[a];
		arr[a] = arr[b];
		arr[b] = aux;		
	}
	
}
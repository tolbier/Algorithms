package com.tolbier.algorithms.week1.secondlargest;

import java.util.Arrays;

public class SecondLargest {
	public static int findSecondLargest(int[] arr) {
		return twoLargest(arr)[0];
	}

	public static int[] twoLargestIn4(int[] arr) {
		int n = arr.length;
		int max = 0, max2 = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max2 = max;
				max = arr[i];
			} else if (arr[i] > max2) {
				max2 = arr[i];
			}
		}

		return new int[] { max2, max };
	}

	public static int[] twoLargest(int[] arr) {
		int n = arr.length;
		
		if (n<=4)return twoLargestIn4(arr);
		int h1[]= twoLargest(Arrays.copyOfRange(arr,0, n/2));
		int h2[]= twoLargest(Arrays.copyOfRange(arr, n/2,n));
		int c[]=concatArrays(h1, h2); //n=4
		//Arrays.
		return twoLargestIn4(c);
	}

	public static int[] concatArrays(int[] arr1, int[] arr2) {
		int[] arr12 = new int[arr1.length + arr2.length];
		System.arraycopy(arr1, 0, arr12, 0, arr1.length);
		System.arraycopy(arr2, 0, arr12, arr1.length, arr2.length);
		return arr12;
	}
}

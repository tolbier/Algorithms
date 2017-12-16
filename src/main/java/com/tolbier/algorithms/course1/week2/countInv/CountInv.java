package com.tolbier.algorithms.course1.week2.countInv;

import java.util.Arrays;

public class CountInv {

	public static long countInv(int[] arr) {

		return sortAndCountInv(arr).countInv;
	}

	public static ArrayAndCountInv sortAndCountInv(int[] a) {
		int n = a.length;
		if (n<=1) return  new ArrayAndCountInv(a, 0);
		
		ArrayAndCountInv cArrCount = sortAndCountInv(Arrays.copyOfRange(a, 0, n/2)); 
		ArrayAndCountInv dArrCount = sortAndCountInv(Arrays.copyOfRange(a, n/2, n));
		ArrayAndCountInv bArrCount = mergeAndCountSplitInv(cArrCount.array,dArrCount.array);
		bArrCount.countInv+=cArrCount.countInv + dArrCount.countInv;
		return bArrCount;
	}

	public static ArrayAndCountInv mergeAndCountSplitInv(int[] c, int[] d) {
		int cl= c.length, dl= d.length;
		int n = cl + dl;
		int[] b = new int[n];
		int i = 0, j = 0;
		long splitInv = 0;
		for (int k = 0; k < n; k++) {
			if ((i<cl)&&
					((j>=dl) || c[i]<=d[j] )) {
				b[k] = c[i++];
			}else {
				b[k] = d[j++];
				if ((i<cl)) { 
					splitInv +=  (n / 2)- i ;
				}
			}
		}
		return new ArrayAndCountInv(b, splitInv);
	}

}

final class ArrayAndCountInv {
	int[] array;
	long countInv;

	public ArrayAndCountInv(int[] array, long countInv) {
		super();
		this.array = array;
		this.countInv = countInv;
	}
}
package com.tolbier.algorithms.course3.week3.exercise3;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Mwis {
	private	long[] path;
	private	long[] maxWeight;
	private Set<Integer> wisSet;
	public Mwis(String fileName) {
		loadPathFromFile(fileName);
		parsePath();
		parseWeights();
	}

	private void parseWeights() {
		wisSet = new LinkedHashSet<Integer>();
		int i = path.length-1;
		while (i>1) {
			if (maxWeight[i-1] >= maxWeight[i-2] + path[i] ) {
				i--;
			}else {
				wisSet.add(i);
				i-=2;
			}
		}
		if (i==1) wisSet.add(i);
	}

	private void parsePath() {
		maxWeight = new long[path.length];
		maxWeight[0] = 0;maxWeight[1] = path[1];
		for (int i = 2;i<=path.length-1 ; i++) {
			maxWeight[i] = Math.max(maxWeight[i-1], maxWeight[i-2] +path[i]);
		}
	}

	private void loadPathFromFile(String filePath) {
		Scanner intScanner = null;

		try {
			intScanner = new Scanner(new File(filePath));
			int n = intScanner.nextInt();
			path = new long[n+1];
			path[0]=0;
			for (int i = 1; i <= n; i++) {
				path[i]=  intScanner.nextLong();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
	}
	public int test(int[] testIds) {
		int result = 0;
		for (int j: testIds) {
			result<<=1;
			if (wisSet.contains(j)) {
				result = result | 1;
			}
			
		}
		return result;
	}
}

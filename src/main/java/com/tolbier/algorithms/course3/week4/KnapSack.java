package com.tolbier.algorithms.course3.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack {
	int size =0;
	int n =0;
	Scanner fileScanner = null;
	long prevSackArr[] ;
	long sackArr[] ;
	public KnapSack(String fileName) {
		initScanFile(fileName);
		scanFile();
	}

	private void scanFile() {
		for (int i = 1;i<=n;i++){
			long value = fileScanner.nextLong();
			int weight = fileScanner.nextInt();
			updateSack(value,weight);
			
		}			
		
	}

	private void updateSack(long value, int weight) {
 		sackArr = new long[size+1];

		for (int x=0; x<=size;x++){
			long prevValue = prevSackArr[x];
			sackArr[x]=Math.max(prevValue,x<weight?0:prevSackArr[x-weight]+value);		
		}

		prevSackArr = sackArr;
	}

	public long getValue() {
		return sackArr[size];
	}
	private void initScanFile(String fileName) {

		try {
			fileScanner = new Scanner(new File(fileName));
		    size = fileScanner.nextInt();
			n = fileScanner.nextInt();
			prevSackArr = new long[size+1];
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}

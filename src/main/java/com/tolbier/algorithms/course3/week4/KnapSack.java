package com.tolbier.algorithms.course3.week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapSack {
	int size =0;
	int n =0;
	Scanner fileScanner = null;
	long [][] sackArr ;
	public KnapSack(String fileName) {
		initScanFile(fileName);
		scanFile();
	}

	private void scanFile() {
		for (int i = 1;i<=n;i++){
			long value = fileScanner.nextLong();
			int weight = fileScanner.nextInt();
			updateSack(i,value,weight);
			
		}			
		
	}

	private void updateSack(int i, long value, int weight) {

		for (int x=0; x<=size;x++){
			long refValue1 = sackArr[i-1][x];
			sackArr[i][x]=Math.max(refValue1,x<weight?0:sackArr[i-1][x-weight]+value);		
		}
	}

	public long getValue() {
		return sackArr[n][size];
	}
	private void initScanFile(String fileName) {

		try {
			fileScanner = new Scanner(new File(fileName));
		    size = fileScanner.nextInt();
			n = fileScanner.nextInt();
			sackArr = new long[n+1][size+1];
			//initItemZeroFromSackArr();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void initItemZeroFromSackArr() {
		for (int x =0; x<=n;x++){
			sackArr[0][x]=0;
		}
		
	}
}

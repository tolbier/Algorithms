package com.tolbier.algorithms.course2.week3.medianMaintenance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class MedianMaintenance {

	public int calculate(String filePath) {
		int result = 0;
		PriorityQueue<Integer> heapLow=null, heapHigh=null;
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File(filePath));
			
			heapHigh = 
		            new PriorityQueue<Integer>(new Comparator<Integer>() {
			    public int compare(Integer i1, Integer i2) {
					return i1.compareTo(i2);
			        
			    }
			});
			heapLow = 
		            new PriorityQueue<Integer>(new Comparator<Integer>() {
			    public int compare(Integer i1, Integer i2) {
					return i2.compareTo(i1);
			        
			    }
			});

			Integer median= Integer.MAX_VALUE;
			while (intScanner.hasNextInt()) {
				Integer number = intScanner.nextInt();
				if (number.compareTo(median)>0) {
					heapHigh.add(number);
					if (heapHigh.size()>heapLow.size()) {
						heapLow.add(heapHigh.poll());
					}
				}else {
					heapLow.add(number);
					if (heapLow.size()>heapHigh.size()+1) {
						heapHigh.add(heapLow.poll());
					}
				}
				median= heapLow.peek();
				result= (result +median)%10000;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return result;
	}

}

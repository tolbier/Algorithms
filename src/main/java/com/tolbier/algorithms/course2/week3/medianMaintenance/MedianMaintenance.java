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
					addNumberToHeap(heapHigh, number);
					exchangeIfHeapOverloaded(heapHigh,heapLow,0);
				}else {
					addNumberToHeap(heapLow, number);
					exchangeIfHeapOverloaded(heapLow,heapHigh,+1);
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
	void exchangeIfHeapOverloaded(PriorityQueue<Integer>  heap1,PriorityQueue<Integer> heap2,int sizeDiff) {
		if (heap1.size()>heap2.size()+sizeDiff) {
			heap2.add(heap1.poll());
		}
	}

	void addNumberToHeap(PriorityQueue<Integer> heap, Integer number) {
		heap.add(number);
	}

}

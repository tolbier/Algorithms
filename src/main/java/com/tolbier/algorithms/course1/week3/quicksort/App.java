package com.tolbier.algorithms.course1.week3.quicksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.tolbier.algorithms.course1.week3.quicksort.choosepivot.ChoosePivotFirstStrategy;

public class App {

	public static void main(String[] args) {
		Scanner scanner=null;
		QuickSort quickSort = new QuickSort(new ChoosePivotFirstStrategy());
		try {
			scanner = new Scanner(new File("resources/course1/week3/quicksort/QuickSort.txt"));
			int[] arr = new int[10000];
			int i = 0;
			while (scanner.hasNextInt()) {
				arr[i++] = scanner.nextInt();
			}
			quickSort.sort(arr);
			System.out.println(quickSort.comparisonsNumber);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}

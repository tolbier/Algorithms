package com.tolbier.algorithms.course4.week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.tolbier.algorithms.commons.tsp.DoublePoint;

public class PointsReader {

	public static DoublePoint[] readFloatPointsListFromFilePath(String inputFileName) {
		DoublePoint[] points = null;
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(inputFileName));
			scanner.useLocale(Locale.ENGLISH);
			int n = Integer.parseInt(scanner.next());
			points = new DoublePoint[n];
			for (int i = 0; i<n; i++) {
				scanner.nextInt();
				Double x = scanner.nextDouble();
				Double y = scanner.nextDouble();
				points[i] = new DoublePoint(x, y);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
			
		} finally {

			scanner.close();
		}
		return points;
	}

}

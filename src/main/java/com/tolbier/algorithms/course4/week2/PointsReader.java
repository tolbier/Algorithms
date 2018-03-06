package com.tolbier.algorithms.course4.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PointsReader {

	public static List<DoublePoint> readFloatPointsListFromFilePath(String inputFileName) {
		List<DoublePoint> points = null;
		Scanner scanner = null;

		try {
			scanner = new Scanner(new File(inputFileName));
			scanner.useLocale(Locale.ENGLISH);
			int n = Integer.parseInt(scanner.next());
			points = new ArrayList<DoublePoint>(n);
			for (int i = 1; i<=n; i++) {
				Double x = scanner.nextDouble();
				Double y = scanner.nextDouble();
				points.add(new DoublePoint(x, y));
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

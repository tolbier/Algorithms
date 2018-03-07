package com.tolbier.algorithms.course4.week2;

public class TSP {
	DoublePoint[] points;
	double[][] distances;
	int n ;
	double array[][];
	public TSP(String floatInputFileName) {
		points = PointsReader.readFloatPointsListFromFilePath(floatInputFileName);
		n = points.length;
		generateDistances();
		initArray();
	}

	private void generateDistances() {
		distances= new double[n][n];
		for (int i =0; i<n ; i++) {
			for (int j =0; j<n ; j++) {
				distances[i][j]=points[i].distanceTo(points[j]);
			}
		}
	}

	private void initArray() {
		//array= new double[(int)Math.pow(2, n-1)][n];
		
	}

	public int getTourWeight() {
		return 0;
	}
}

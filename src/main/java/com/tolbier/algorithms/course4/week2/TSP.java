package com.tolbier.algorithms.course4.week2;

import java.util.HashMap;
import java.util.Map;

public class TSP {
	DoublePoint[] points;
	double[][] distances;
	int n ;
	Map<Integer,double[]> currMap;
	Map<Integer,double[]> lastMap;
	public TSP(String floatInputFileName) {
		points = PointsReader.readFloatPointsListFromFilePath(floatInputFileName);
		n = points.length;
		generateDistances();
		currMap= crearInitialMap();
		for (int m=2;m<=n;m++) { //m es el tamaño del Subconjunto
			//Crear el Array 
			
		}
		
	}

	private Map<Integer, double[]> crearInitialMap() {
		Map<Integer, double[]> map = crearMap( 2);
		initMap(map,2);
		return map;
	}

	private void initMap(Map<Integer, double[]> map, int m ) {
		//Crear Iterator que devuelva los valores posibles de S , para n y m
		//inicializar todos los map(s,0), si s=0 -> 0, sino INFINITE 
//		Iterator<Integer> sIterator = 
//		while (sIterator.hasNext()) {
//			
//		}
//		map.
	}

	private Map<Integer, double[]> crearMap(int m) {
		Map<Integer, double[]> map= new HashMap<Integer,double[]> (combinations(n-1,m-1)) ;
		return map;
	}
    
	private void generateDistances() {
		distances= new double[n][n];
		for (int i =0; i<n ; i++) {
			for (int j =0; j<n ; j++) {
				distances[i][j]=points[i].distanceTo(points[j]);
			}
		}
	}

	private void Array() {
		//curArray= new double[(int)Math.pow(2, n-1)][24];
		for (int i =0; i<=(int)Math.pow(2, n-1);i++) {
			int j = i;
		}
	}

	public int getTourWeight() {
		return 0;
	}
	public static int combinations(int n , int k) {
		int dividend=1;
		int divisor=1;
		for (int i = 1;i<=k;i++) {
			dividend*=(n-(k-i));
			divisor*=i;
		}
		
		return dividend/divisor;
	}
}

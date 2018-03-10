package com.tolbier.algorithms.course4.week2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.tolbier.algorithms.course4.week2.exceptions.SIteratorException;
import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class TSP {
	DoublePoint[] points;
	double[][] distances;
	int n;
	Map<Integer, Map<Integer, Double>> currMap;
	Map<Integer, Map<Integer, Double>> lastMap;

	public TSP(String floatInputFileName) throws TSPException {
		points = PointsReader.readFloatPointsListFromFilePath(floatInputFileName);
		n = points.length;
		generateDistances();
		currMap = new HashMap<Integer, Map<Integer, Double>>();
		// currMap = crearMap(1);
		Map<Integer, Double> mapDouble = new HashMap<Integer, Double>();
		currMap.put(1, mapDouble);
		mapDouble.put(0, 0.0);
		for (int m = 2; m <= n; m++) { // m es el tamaño del Subconjunto
			System.out.println("m:"+m);
			lastMap=null;
			Runtime r = Runtime.getRuntime();
			r.gc();

			lastMap = currMap;
			currMap = crearInitialMap(m);
			Set<Integer> set= currMap.keySet();
			int i=0; int setSize=set.size();
			for (Integer s : set) {
				if (i%10000==0) System.out.println("m.:"+m+"."+i+"/"+setSize);
				Iterator<Integer> jIterator = new BitIterator(s, 0);
				while (jIterator.hasNext()) {
					int j = jIterator.next();
					Map<Integer, Double> mapDouble2 = currMap.get(s);
					mapDouble2.put(j, minChoice(s,s ^ (1 << j), j));
				}
				i++;
			}
		}
		lastMap = currMap;
	}

	private double minChoice(int set, int set2, int j) {
		double result = Double.POSITIVE_INFINITY;
		Iterator<Integer> kIterator = new BitIterator(set, j);
		while (kIterator.hasNext()) {
			int k = kIterator.next();
			Map<Integer, Double> mapDouble = lastMap.get(set2);
			double v = mapDouble.get(k) + distances[k][j];
			if (v < result)
				result = v;
		}

		return result;

	}

	private Map<Integer, Map<Integer, Double>> crearInitialMap(int m) throws TSPException {
		Map<Integer, Map<Integer, Double>> map = crearMap(m);
		initMap(map, m);
		return map;
	}

	private Map<Integer, Map<Integer, Double>> crearMap(int m) {
//		int c = combinations(n - 1, m - 1);
//		if (c<0) {
//			int i=1;
//		}
//Map<Integer, Map<Integer, Double>> map = new HashMap<Integer, Map<Integer, Double>>(combinations(n - 1, m - 1));
		Map<Integer, Map<Integer, Double>> map = new HashMap<Integer, Map<Integer, Double>>();
		return map;
	}

	private void initMap(Map<Integer, Map<Integer, Double>> map, int m) throws TSPException {
		// Crear Iterator que devuelva los valores posibles de S , para n y m
		// inicializar todos los map(s,0), si s=0 -> 0, sino INFINITE
		Iterator<Integer> sIterator;
		try {
			sIterator = new SIterator(n, m);
		} catch (SIteratorException e) {
			throw new TSPException(e);
		}
		while (sIterator.hasNext()) {
			Integer s = sIterator.next();
			Map<Integer, Double> mapDouble = new HashMap<Integer, Double>();
			mapDouble.put(0, Double.POSITIVE_INFINITY);
			map.put(s, mapDouble);

		}
	}

	private void generateDistances() {
		distances = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distances[i][j] = points[i].distanceTo(points[j]);
			}
		}
	}

	public int getTourWeight() {
		int s= bitsNOnes();
		return (int) minChoice(s,s, 0);
	}

	private int bitsNOnes() {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result = (result << 1) | 1;
		}
		return result;
	}

	public static int combinations(int n, int k) {
		long dividend = 1;
		long divisor = 1;
		for (int i = 1; i <= k; i++) {
			dividend *= (n - (k - i));
			divisor *= i;
		}

		return (int)( dividend / divisor);
	}
}

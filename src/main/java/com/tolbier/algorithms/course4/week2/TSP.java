package com.tolbier.algorithms.course4.week2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.tolbier.algorithms.commons.tsp.DoublePoint;
import com.tolbier.algorithms.course4.week2.exceptions.SIteratorException;
import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class TSP {
	DoublePoint[] points;
	double[][] distances;
	int n;
	Map<Integer, double[]> currMap;
	Map<Integer, double[]> lastMap;

	public TSP(String floatInputFileName) throws TSPException {
		points = PointsReader.readFloatPointsListFromFilePath(floatInputFileName);
		n = points.length;
		generateDistances();
		currMap = new HashMap<Integer, double[]>();
		// currMap = crearMap(1);
		double[] arrDouble = new double[1];
		arrDouble[0] = 0.0;
		currMap.put(1, arrDouble);
		for (int m = 2; m <= n; m++) { // m es el tamaño del Subconjunto
			//System.out.println("m:" + m);
			lastMap = currMap;
			currMap = crearInitialMap(m);
			Set<Integer> set = currMap.keySet();
			int i = 0;
			int setSize = set.size();
			for (Integer s : set) {
				Iterator<Integer> jIterator = new BitIterator(s, 0);
				int h = 1;
				while (jIterator.hasNext()) {
					int j = jIterator.next();
					double[] arrDouble2 = currMap.get(s);
					arrDouble2[h] = minChoice(s, s ^ (1 << j), j);
					h++;
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
			double[] arrDouble = lastMap.get(set2);
			int k2 = getOneBitsOfKinS(k, set2);
			double v = arrDouble[k2] + distances[k][j];
			if (v < result)
				result = v;
		}

		return result;

	}

	static protected int getOneBitsOfKinS(int k, int s) {
		int mask = bitsOnes(k + 1);
		s = s & mask;
		int i = -1;
		while (s != 0) {
			if ((s & 1) == 1)
				i++;
			s = s >> 1;
		}
		return i;
	}

	private Map<Integer, double[]> crearInitialMap(int m) throws TSPException {
		Map<Integer, double[]> map = crearMap(m);
		initMap(map, m);
		return map;
	}

	private Map<Integer, double[]> crearMap(int m) {
		Map<Integer, double[]> map = new HashMap<Integer, double[]>();
		return map;
	}

	private void initMap(Map<Integer, double[]> map, int m) throws TSPException {
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
			double[] arrDouble = new double[m];
			arrDouble[0] = Double.POSITIVE_INFINITY;
			map.put(s, arrDouble);

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
		int s = bitsNOnes();
		return (int) minChoice(s, s, 0);
	}

	private int bitsNOnes() {
		return bitsOnes(n);
	}

	static private int bitsOnes(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			result = (result << 1) | 1;
		}
		return result;
	}
}

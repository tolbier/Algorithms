package com.tolbier.algorithms.course4.week2;

import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class App {

	public static void main(String[] args) {
		TSP tsp = null;
		try {
			tsp = new TSP("tsp.txt");
		} catch (TSPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TSP:" + tsp.getTourWeight());

	}

}

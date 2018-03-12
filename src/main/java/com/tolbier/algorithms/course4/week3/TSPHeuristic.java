package com.tolbier.algorithms.course4.week3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.tolbier.algorithms.commons.tsp.DoublePoint;

import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class TSPHeuristic {
	
	City[] cities; 
	Set<City> unexplored;
	double tourLength=0;

	public TSPHeuristic(String floatInputFileName) throws TSPException {
		DoublePoint[] points = PointsReader.readFloatPointsListFromFilePath(floatInputFileName);
		cities = generateCities(points);
		unexplored= generateUnexplored();
		
		City currentCity=cities[0];
		unexplored.remove(currentCity);
		while (! unexplored.isEmpty()) {
			City newCity=visitClosestCity(currentCity);
			tourLength+=currentCity.distanceTo(newCity);
			currentCity= newCity;
			unexplored.remove(currentCity);
		}
		tourLength+=currentCity.distanceTo(cities[0]);
	}





	private City[] generateCities(DoublePoint[] points) {
		int n =points.length;
		City[] cities = new City[n];
		for (int i = 0; i<n; i++) {
			cities[i] = new City(i,points[i]);
		}
		return cities;
	}





	private Set<City> generateUnexplored() {
		Set<City> unexplored= new HashSet<City>(Arrays.asList(cities));
		return unexplored;
	}





	private City visitClosestCity(City currentCity) {
		City closestCity=null;
		double minDistance=Double.POSITIVE_INFINITY;
		
		for (City city: unexplored) {
			double distance= currentCity.distanceTo(city);
			if (distance<minDistance ||
					(distance==minDistance &&
					(city.getIdx()<closestCity.getIdx()))) {
				minDistance=distance;
				closestCity = city;
			}
		}
		return closestCity;
		
	}





	public int getTourLength() {
		return (int)tourLength;
	}


}

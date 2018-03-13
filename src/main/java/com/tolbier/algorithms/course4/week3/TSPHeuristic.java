package com.tolbier.algorithms.course4.week3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.tolbier.algorithms.commons.tsp.DoublePoint;

import com.tolbier.algorithms.course4.week2.exceptions.TSPException;

public class TSPHeuristic {
	private class CityDistance{
		City city;
		double distance;
		public CityDistance(City city, double distance) {
			super();
			this.city = city;
			this.distance = distance;
		}
		
	}
	City[] cities; 
	Set<City> unexplored;
	double tourLength=0;

	public TSPHeuristic(String floatInputFileName) throws TSPException {
		DoublePoint[] points = PointsReader.readFloatPointsListFromFilePath(floatInputFileName);
		cities = generateCities(points);
		unexplored= generateUnexplored();

		CityDistance cityDistance=new CityDistance(cities[0],0);
		unexplored.remove(cityDistance.city);
		while (! unexplored.isEmpty()) {
			cityDistance=visitClosestCity(cityDistance.city);
			tourLength+=cityDistance.distance;
			unexplored.remove(cityDistance.city);
		}
		tourLength+=cityDistance.city.distanceTo(cities[0]);
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





	private CityDistance visitClosestCity(City currentCity) {
		City closestCity=null;
		double minEuclideanSquared=Double.POSITIVE_INFINITY;
		
		for (City city: unexplored) {
			double euclideanSquared= currentCity.euclideanSquared(city);

				if (euclideanSquared<minEuclideanSquared ||
						(euclideanSquared==minEuclideanSquared &&
						(city.getIdx()<closestCity.getIdx()))) {
					minEuclideanSquared=euclideanSquared;
					closestCity = city;
				}
		}
		return new CityDistance(closestCity, currentCity.distanceTo(closestCity));
		
	}





	public int getTourLength() {
		return (int)tourLength;
	}


}

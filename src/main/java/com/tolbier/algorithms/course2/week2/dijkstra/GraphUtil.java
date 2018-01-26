package com.tolbier.algorithms.course2.week2.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Vertex;
import com.tolbier.algorithms.commons.VertexDistanceComparator;

public class GraphUtil {

	static Graph<Integer> getWeightedGraph(String filePath) {
		Graph<Integer> wg = new Graph<Integer>(true);
		Scanner lineScanner = null;
		try {
			lineScanner = new Scanner(new File(filePath));
			while (lineScanner.hasNextLine()) {

				String line = lineScanner.nextLine();
				Scanner vertexScanner = new Scanner(line);
				int tail = vertexScanner.nextInt();
				Vertex<Integer> vertex1 = wg.addSingleVertex(tail);
				vertex1.setData(tail);

				vertexScanner.useDelimiter("\\s+");

				while (vertexScanner.hasNext()) {
					String pair = vertexScanner.next();
					Pattern pattern = Pattern.compile("^(\\d+),(\\d+)");
					Matcher matcher = pattern.matcher(pair);
					if (matcher.find()) {
						int head = Integer.parseInt(matcher.group(1));
						int weight = Integer.parseInt(matcher.group(2));
						wg.addEdge(tail, head, weight);
					}

				}
				vertexScanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			lineScanner.close();
		}
		return wg;
	}
}

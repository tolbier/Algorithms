package com.tolbier.algorithms.course2.week4.twoSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

	public int calculate(String fileName, int dimensions[]) {
		Map<Long, Long> hash = getMapFromFile(fileName);
		
		return calculate(hash,dimensions);
	}
	private int calculate(Map<Long, Long> hash, int dimensions[]) {
		
		
		Map<Long,Long> tMap = new Hashtable<Long,Long>();
		for (long t =dimensions[0]; t<=dimensions[1];t++) {
			tMap.put(t,t);
		}
		int origTMapSize= tMap.size();
		Iterator<Long> iteratorKey=hash.keySet().iterator();
		while (iteratorKey.hasNext()) {
			Long x = iteratorKey.next();
			Iterator<Long> iteratorT = tMap.keySet().iterator();
			while (iteratorT.hasNext()) {
				Long t= iteratorT.next();
				long y =t-x;
				if (y!=x && hash.containsKey(y)) {
					iteratorT.remove();
				}
				
			}
		}
		
		return  (origTMapSize - tMap.size());
	}
	private Map<Long, Long> getMapFromFile(String fileName) {
		Map<Long, Long> map = new Hashtable<Long,Long>();
		Scanner scanner=null;
		try {
			scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLong()) {
				long i = scanner.nextLong();
				map.put(i, i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			scanner.close();
		}
		return map;
	}

}

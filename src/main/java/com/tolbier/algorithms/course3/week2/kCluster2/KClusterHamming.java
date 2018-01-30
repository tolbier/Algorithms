package com.tolbier.algorithms.course3.week2.kCluster2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.tolbier.algorithms.commons.Edge;
import com.tolbier.algorithms.commons.UnionFind;
import com.tolbier.algorithms.course3.week2.kCluster1.IUnionFind;
import com.tolbier.algorithms.course3.week2.kCluster1.VertexUnionFind;

public class KClusterHamming {

	int nBits;
	Map<Integer, Integer> nodesHash;
	IUnionFind uf;
	List<Entry<Integer, Integer>> nodesEntryList ;

	
	
	public KClusterHamming(String filePath) {
		super();
		getNodesHash(filePath);
		uf = new UnionFind(nodesHash.size());
		nodesEntryList = new ArrayList<Entry<Integer, Integer>>( nodesHash.entrySet());
		initNodesValues();
		parseNodes(new OneBitVariationFactory(nBits));
		parseNodes(new TwoBitsVariationFactory(nBits));

	}

	public int getKForSpacing3UF() {
		return uf.numberOfSets();
	}

	void initNodesValues() {
		int i=0;
		for (Entry<Integer, Integer> nodeEntry: nodesEntryList) { 
			nodeEntry.setValue(i++);
		}
	}

	private void parseNodes(VariationFactory variationFactory) {
		for (Entry<Integer, Integer> nodeEntry: nodesEntryList) { 
			int nodeNumber = nodeEntry.getKey();
			Iterator<Integer> itVariation = variationFactory.getIterator(nodeNumber);
			while (itVariation.hasNext()) {
				int variation = itVariation.next();
				Integer variationFoundIdx = nodesHash.get(variation);
				if (null != variationFoundIdx) {
					uf.union(nodeEntry.getValue(), variationFoundIdx);
				}
			}
		}
	}

	private void getNodesHash(String filePath) {
		nodesHash = null;
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File(filePath));
			int n = intScanner.nextInt();
			nodesHash = new HashMap<Integer, Integer>();
			nBits = intScanner.nextInt();

			for (int i = 0; i < n; i++) {
				int node = 0;
				for (int j = 0; j < nBits; j++) {
					node <<= 1;
					int bit = intScanner.nextInt();
					node |= bit;
				}
				nodesHash.put(node, i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
	}

	protected int getnBits() {
		return nBits;
	}

	protected Map<Integer, Integer> getNodesMap() {
		return nodesHash;
	}

	protected int getNumberOfNodes() {
		return nodesHash.size();
	}

}

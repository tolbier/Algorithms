package com.tolbier.algorithms.course3.week2.kCluster2;

import java.io.File;
import java.io.FileNotFoundException;
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
	Map<Integer,Integer> nodesHash;


	public KClusterHamming(String filePath) {
		super();
		getNodesHash(filePath);

	}
	
	public int getKForSpacing3() {
		Iterator<Integer> itNodes = nodesHash.keySet().iterator();
		while (itNodes.hasNext()) {
			int node = itNodes.next();
			if (hashContainsNodeWithOneBitVariation(node) ||
					hashContainsNodeWithTwoBitsVariation(node)) {
				itNodes.remove();
			}
		}
		return nodesHash.size();
	}
	/*TO-DO :  -Limpiar codigo no usado como getKForSpacing3 o hashContainsNodeWithOneBitVariation , o hashContainsNodeWithTwoBitsVariation
	 *         -Cargar del archivo y encapsular el NODO en un objeto que sea ID, NUMERO
	 *         -Meter el objeto en un Array por ID
	 *         -Crear un Hash con clave NUMERO y valor NODO
	 *         
	 *        -Crear un algoritmo de "fuerza bruta" y compararlo con el resultado
	 *        -Puede que el fallo esté en los métodos findNodeWith... que encuentre sólo el primero,
	 *         y que haya más en la lista....  
	 */  
	
	public int getKForSpacing3UF() {
		IUnionFind uf =new UnionFind(nodesHash.size());
		Object[] nodesArr= nodesHash.entrySet().toArray();

		for(int i=0; i<nodesArr.length;i++) {
			Entry<Integer,Integer> entry  = (Entry<Integer,Integer>)nodesArr[i];
			entry.setValue(i);
		}
		for(int i=0; i<nodesArr.length;i++) {
			Entry<Integer,Integer> entry  = (Entry<Integer,Integer>)nodesArr[i];
			int node = entry.getKey();

			for (int j=0;j<nBits;j++) {
				int mask=1<<j;
				int node2Find = node ^ mask; 
				Integer nodeFoundIdx = nodesHash.get(node2Find);
				if (null!=nodeFoundIdx) {
					uf.union(entry.getValue(), nodeFoundIdx);
				}
			}
			
		}
		for(int i=0; i<nodesArr.length;i++) {
			Entry<Integer,Integer> entry  = (Entry<Integer,Integer>)nodesArr[i];
			int node = entry.getKey();
			for (int k=0;k<nBits-1;k++) {
				for (int j=k+1;j<nBits;j++) {
					int mask = (1<<k)|(1<<j);
					int node2Find = node ^ mask; 
					Integer nodeFoundIdx = nodesHash.get(node2Find);
					if (null!=nodeFoundIdx) {
						uf.union(entry.getValue(), nodeFoundIdx);
					}
					
					
				}
			}
		}
		return uf.numberOfSets();
	}
//	private Integer findNodeWithOneBitVariation(int node) {
//
//		for (int i=0;i<nBits;i++) {
//			int mask=1<<i;
//			int node2Find = node ^ mask; 
//			Integer nodeFoundIdx = nodesHash.get(node2Find);
//			if (null!=nodeFoundIdx) {
//				return nodeFoundIdx;
//			}
//		}
//		return null;
//		
//		
//	}
//	private Integer findNodeWithTwoBitsVariation(int node) {
//
//		for (int i=0;i<nBits-1;i++) {
//			for (int j=i+1;j<nBits;j++) {
//				int mask = (1<<i)|(1<<j);
//				int node2Find = node ^ mask; 
//				Integer nodeFoundIdx = nodesHash.get(node2Find);
//				if (null!=nodeFoundIdx) {
//					return nodeFoundIdx;
//				}
//				
//				
//			}
//			
//		}
//		return null;
//		
//		
//	}
	private boolean hashContainsNodeWithOneBitVariation(int node) {

		for (int i=0;i<nBits;i++) {
			int mask=1<<i;
			if (nodesHash.containsKey(node ^ mask )) {
				return true;
			}
		}
		return false;
		
		
	}
	private boolean hashContainsNodeWithTwoBitsVariation(int node) {

		for (int i=0;i<nBits-1;i++) {
			for (int j=i+1;j<nBits;j++) {
				int mask = (1<<i)|(1<<j);
				if (nodesHash.containsKey(node ^ mask )) {
					return true;
				}
				
			}
			
		}
		return false;
		
		
	}

	// private int une(IUnionFind vuf, Vertex<Integer> u, Vertex<Integer> v) {
	// return vuf.union((int)u.getId(),(int)v.getId());
	// }
	 private void getNodesHash(String filePath) {
		nodesHash=null;
		Scanner intScanner = null;
		try {
			intScanner = new Scanner(new File(filePath));
			int n = intScanner.nextInt();
			nodesHash=new HashMap<Integer,Integer>();
			nBits = intScanner.nextInt();

			for (int i = 0; i < n; i++) {
				int node = 0;
				for (int j = 0; j < nBits; j++) {
					node <<= 1;
					int bit = intScanner.nextInt();
					node |= bit;
				}
				nodesHash.put(node,i);
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

	protected Map<Integer,Integer> getNodesMap() {
		return nodesHash;
	}



	protected int getNumberOfNodes() {
		return nodesHash.size();
	}

}

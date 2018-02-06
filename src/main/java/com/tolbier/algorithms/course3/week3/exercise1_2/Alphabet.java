package com.tolbier.algorithms.course3.week3.exercise1_2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;
import com.tolbier.algorithms.commons.Vertex;

public class Alphabet<T extends Comparable<T>> {
	Queue<Node<T>> heap;
	NodeSequencer seq = new NodeSequencer();

	private Alphabet() {
		super();
		Comparator<Node<T>> comparator = new NodeWeightComparator<T>();
		this.heap = new PriorityQueue<Node<T>>(comparator);
	}

	public void add(Node<T> item) {
		heap.add(item);
	}

	public Node<T> poll() {
		return heap.poll();
	}

	@Override
	public String toString() {
		return heap.toString();
	}

	public void addNode(T weight) {
		heap.add(new Node<T>(seq.next(), weight));
	}

	public int size() {
		return heap.size();
	}

	protected NodeSequencer getSequencer() {
		return seq;
	}

	public static Alphabet<Long> createAlphabetFromGraph(Graph<Long> graph) {
		Alphabet<Long> sigma = new Alphabet<Long>();

		Iterator<Vertex<Long>> it = graph.getAllVertex().iterator();
		while (it.hasNext()) {
			sigma.add((Node<Long>) it.next());
		}
		return sigma;
	}

}

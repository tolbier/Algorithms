package com.tolbier.algorithms.course2.week1.kosaraju.utils;

import java.util.Iterator;
import java.util.Stack;

public class StackPopIterator<T> implements Iterator<T>{
	
	Stack<T> stack;
	public StackPopIterator(Stack<T> stack) {
		super();
		this.stack = stack;
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		return stack.pop();
	}

}

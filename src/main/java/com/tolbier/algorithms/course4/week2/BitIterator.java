package com.tolbier.algorithms.course4.week2;

import java.util.Iterator;

import com.tolbier.algorithms.course4.week2.exceptions.BinaryIteratorException;
import com.tolbier.algorithms.course4.week2.exceptions.KgreaterThanNException;

public class BitIterator implements Iterator<Integer>{
	int i;
	int v ;
	int except;
	
	public BitIterator(int v,int except)  {
		this.i=0;
		this.v = v;
		this.except=except;
		ifNot1ForwardTo1();
	}
	@Override
	public boolean hasNext() {
		return v!=0;
	}

	@Override
	public Integer next() {
		int result = i;
		forward();
		ifNot1ForwardTo1();
		
		return result;
	}
	private void ifNot1ForwardTo1() {
		//avanza hasta siguiente 1
		while (v!=0 && !((v&1)==1  && i!=except)) {
// mientras no elemento final Y !( v&1==1 && i!=except)			
			forward();
		}
	}
	private void forward() {
		v>>=1;
		i++;
	}
		
}

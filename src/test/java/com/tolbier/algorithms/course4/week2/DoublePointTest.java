package com.tolbier.algorithms.course4.week2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.tolbier.algorithms.commons.Graph;
import com.tolbier.algorithms.commons.Node;

public class DoublePointTest {
	private static final double DELTA = 1e-15;

	@Test
	public void testDoublePoint() {
		DoublePoint p1 = new DoublePoint(0.123454123, 0.41231232);
		DoublePoint p2 = new DoublePoint(2.12343454123, 0.41345231232);

		assertEquals(1.999980743128777, p1.distanceTo(p2),DELTA);
	}
	@Test
	public void testDoublePoint2() {
		DoublePoint p1 = new DoublePoint(0.145453454123, 0.234422);
		DoublePoint p2 = new DoublePoint(1.356743354, 0.234234);

		assertEquals(1.2112899144664058, p1.distanceTo(p2),DELTA);
	}


}

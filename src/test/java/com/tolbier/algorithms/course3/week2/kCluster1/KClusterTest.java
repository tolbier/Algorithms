package com.tolbier.algorithms.course3.week2.kCluster1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.tolbier.algorithms.course3.week2.kCluster1.KCluster;

public class KClusterTest {
	KCluster kCluster;

	@Test
	public void testMaximumSpacing_1_8() {
		kCluster = new KCluster(4, "resources/course3/week2/exercise1/input_completeRandom_1_8.txt");
		assertEquals(21, kCluster.getMaximumSpacing());
	}

	@Test
	public void testMaximumSpacing_2_8() {
		kCluster = new KCluster(4, "resources/course3/week2/exercise1/input_completeRandom_2_8.txt");
		assertEquals(6, kCluster.getMaximumSpacing());
	}
	//@Test
	public void testMaximumSpacing_clustering1() {
		kCluster = new KCluster(4, "resources/course3/week2/exercise1/clustering1.txt");
		assertEquals(106, kCluster.getMaximumSpacing());
	}

}

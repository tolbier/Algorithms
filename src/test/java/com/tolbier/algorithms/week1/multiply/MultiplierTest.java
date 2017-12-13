package com.tolbier.algorithms.week1.multiply;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiplierTest {
	@Test
	public void testRecursiveMultiply() {
		assertEquals(7006652, Multiplier.recursiveMultiply(1234, 5678));
	}

	@Test
	public void testIntMultiply() {
		assertEquals(7006652, Multiplier.karatsubaIntMultiply(1234, 5678));

	}

	@Test
	public void testStringMultiply() {


		assertEquals("672", Multiplier.multiply("12", "56"));
		assertEquals("33", Multiplier.multiply("3", "11"));
		assertEquals("2652", Multiplier.multiply("34", "78"));
		assertEquals("105", Multiplier.multiply("7", "15"));
		assertEquals("6164", Multiplier.multiply("46", "134"));
		assertEquals("1564", Multiplier.multiply("46", "34"));
		assertEquals("70", Multiplier.multiply("10", "7"));
		assertEquals("1610", Multiplier.multiply("46", "35"));
		assertEquals("80", Multiplier.multiply("10", "8"));
		assertEquals("7006652", Multiplier.multiply("1234", "5678"));
		
		assertEquals("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184", 
				 Multiplier.multiply("3141592653589793238462643383279502884197169399375105820974944592", 
						   "2718281828459045235360287471352662497757247093699959574966967627"));
	}

	@Test
	public void testOneCipherSum() {
		assertEquals("0", Multiplier.add("0", "0"));
		assertEquals("1", Multiplier.add("0", "1"));
		assertEquals("2", Multiplier.add("1", "1"));
		assertEquals("10", Multiplier.add("5", "5"));
		assertEquals("18", Multiplier.add("9", "9"));
	}
	@Test
	public void testZerosSum() {
		assertEquals("30", Multiplier.add("000", "30"));
	}
	@Test
	public void testRemoveZeros() {
		assertEquals("0", Multiplier.removeZeros("0"));
		assertEquals("0", Multiplier.removeZeros("0000"));
	}

	@Test
	public void testOnePlusTwoCiphersSum() {
		assertEquals("15", Multiplier.add("5", "10"));
		assertEquals("19", Multiplier.add("10", "9"));
	}

	@Test
	public void testTwoCiphersSum() {
		assertEquals("60", Multiplier.add("50", "10"));
		assertEquals("99", Multiplier.add("65", "34"));
		assertEquals("129", Multiplier.add("95", "34"));
	}

	@Test
	public void testOneCipherSubstract() {
		assertEquals("0", Multiplier.substract("0", "0"));
		assertEquals("1", Multiplier.substract("1", "0"));
		assertEquals("4", Multiplier.substract("9", "5"));
	}

	@Test
	public void testOneAndTwoCipherSubstract() {
		assertEquals("9", Multiplier.substract("10", "1"));
		assertEquals("1", Multiplier.substract("10", "9"));
		assertEquals("18", Multiplier.substract("19", "1"));
		assertEquals("10", Multiplier.substract("19", "9"));
	}

	@Test
	public void testTwoAndTwoCipherSubstract() {
		assertEquals("0", Multiplier.substract("10", "10"));
		assertEquals("9", Multiplier.substract("19", "10"));
		assertEquals("19", Multiplier.substract("29", "10"));
	}

	@Test
	public void testThreeAndTwoCipherSubstract() {
		assertEquals("300", Multiplier.substract("310", "10"));
		assertEquals("90", Multiplier.substract("100", "10"));
		assertEquals("100", Multiplier.substract("190", "90"));
		assertEquals("99", Multiplier.substract("190", "91"));
	}

	@Test
	public void testThreeAndOneCipherSubstract() {
		assertEquals("309", Multiplier.substract("310", "1"));
		assertEquals("91", Multiplier.substract("100", "9"));
		assertEquals("181", Multiplier.substract("190", "9"));
		assertEquals("189", Multiplier.substract("190", "1"));
	}

	@Test
	public void testPow10By() {
		assertEquals("1", Multiplier.pow10by(0, "1"));
		assertEquals("9", Multiplier.pow10by(0, "9"));
		assertEquals("10", Multiplier.pow10by(1, "1"));
		assertEquals("90", Multiplier.pow10by(1, "9"));
		assertEquals("1000", Multiplier.pow10by(3, "1"));
		assertEquals("9000", Multiplier.pow10by(3, "9"));
		assertEquals("100000000000000000000", Multiplier.pow10by(20, "1"));
		assertEquals("900000000000000000000", Multiplier.pow10by(20, "9"));
	}
	@Test
	public void testPadLeftZeros() {
		assertEquals("10", Multiplier.padLeftZeros(1, "10"));
		assertEquals("10", Multiplier.padLeftZeros(2, "10"));
		assertEquals("010", Multiplier.padLeftZeros(3, "10"));
		assertEquals("0010", Multiplier.padLeftZeros(4, "10"));
		assertEquals("31", Multiplier.padLeftZeros(1, "31"));
		assertEquals("31", Multiplier.padLeftZeros(2, "31"));
		assertEquals("031", Multiplier.padLeftZeros(3, "31"));
		assertEquals("0031", Multiplier.padLeftZeros(4, "31"));
	}
	
	
	@Test
	public void testNextPowerOf2() {
		assertEquals(1, Multiplier.nextPowerOf2(1));
		assertEquals(2, Multiplier.nextPowerOf2(2));
		assertEquals(4, Multiplier.nextPowerOf2(3));
		assertEquals(4, Multiplier.nextPowerOf2(4));
		assertEquals(8, Multiplier.nextPowerOf2(5));
		assertEquals(8, Multiplier.nextPowerOf2(6));
		assertEquals(8, Multiplier.nextPowerOf2(7));
		assertEquals(8, Multiplier.nextPowerOf2(8));
		assertEquals(16, Multiplier.nextPowerOf2(9));
		assertEquals(16, Multiplier.nextPowerOf2(10));
		assertEquals(16, Multiplier.nextPowerOf2(11));
	}
	@Test
	public void testGetN() {
		assertEquals(1, Multiplier.getN("1", "1"));
		assertEquals(2, Multiplier.getN("13", "1"));
		assertEquals(4, Multiplier.getN("13", "133"));
		assertEquals(4, Multiplier.getN("133", "133"));
		assertEquals(4, Multiplier.getN("1334", "133"));
		assertEquals(8, Multiplier.getN("1334", "11233"));
	}
}

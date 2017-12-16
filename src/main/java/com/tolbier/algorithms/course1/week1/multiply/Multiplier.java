package com.tolbier.algorithms.course1.week1.multiply;

public class Multiplier {

	public static int recursiveMultiply(int x, int y) {
		int n = getnumDigits(x);
		if (n == 1)
			return x * y;
		int tenPowHalfN = (int) Math.pow(10, n / 2);
		int a = (int) (x / tenPowHalfN);
		int b = (int) (x % tenPowHalfN);
		int c = (int) (y / tenPowHalfN);
		int d = (int) (y % tenPowHalfN);
		int ac = recursiveMultiply(a, c);
		int ad = recursiveMultiply(a, d);
		int bc = recursiveMultiply(b, c);
		int bd = recursiveMultiply(b, d);

		return tenPowHalfN * tenPowHalfN * ac + tenPowHalfN * (ad + bc) + bd;
	}

	public static int karatsubaIntMultiply(int x, int y) {
		int n = getnumDigits(x);
		if (n == 1)
			return x * y;
		int tenPowHalfN = (int) Math.pow(10, n / 2);
		int a = (int) (x / tenPowHalfN);
		int b = (int) (x % tenPowHalfN);
		int c = (int) (y / tenPowHalfN);
		int d = (int) (y % tenPowHalfN);
		int ac = karatsubaIntMultiply(a, c);
		int bd = karatsubaIntMultiply(b, d);
		int ad_cb = karatsubaIntMultiply(a + b, c + d) - ac - bd;

		return tenPowHalfN * tenPowHalfN * ac + tenPowHalfN * (ad_cb) + bd;
	}

	private static int getnumDigits(int x) {
		if (x == 0)
			return 1;
		return (int) (Math.log10(x) + 1);
	}

	public static String multiply(String x, String y) {

		int n = getN(x, y);
		x = padLeftZeros(n, x);
		y = padLeftZeros(n, y);
		if (n <= 4)
			return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
		String a = (String) x.substring(0, n / 2);
		String b = (String) x.substring(n / 2, n);
		String c = (String) y.substring(0, n / 2);
		String d = (String) y.substring(n / 2, n);
		String ac = multiply(a, c);
		String bd = multiply(b, d);
		String p = add(a, b);
		String q = add(c, d);
		String pq = multiply(p, q);
		String ad_cb = substract(substract(pq, ac), bd);
		return add(
					add(
						pow10by(n, ac), 
						pow10by(n / 2, ad_cb)), 
					bd);
	}

	protected static int getN(String x, String y) {
		return nextPowerOf2(Math.max(x.length(), y.length()));
	}
	protected static int nextPowerOf2(final int a)
    {
        int b = 1;
        while (b < a)
        {
            b = b << 1;
        }
        return b;
    }
	public static String add(String aStr, String bStr) {
		char[] a = aStr.toCharArray();
		char[] b = bStr.toCharArray();
		int idxA = a.length - 1;
		int idxB = b.length - 1;
		StringBuilder addString = new StringBuilder();

		int carry = 0;
		while (idxA >= 0 || idxB >= 0) {
			int dA = 0;
			int dB = 0;

			if (idxA >= 0)
				dA = a[idxA--] - '0';
			if (idxB >= 0)
				dB = b[idxB--] - '0';

			int sum = dA + dB + carry;
			carry = 0;
			if (sum >= 10) {
				carry = sum / 10;
				sum = sum % 10;
			}

			addString.insert(0, sum);
		}
		if (carry > 0)
			addString.insert(0, carry);

		return removeZeros(addString.toString());

	}

	public static String substract(String aStr, String bStr) {
		char[] a = aStr.toCharArray();
		char[] b = bStr.toCharArray();
		int idxA = a.length - 1;
		int idxB = b.length - 1;
		StringBuilder substractString = new StringBuilder();

		int carry = 0;
		while (idxA >= 0 || idxB >= 0) {
			int dA = 0;
			int dB = 0;

			if (idxA >= 0)
				dA = a[idxA--] - '0';
			if (idxB >= 0)
				dB = b[idxB--] - '0';

			int result = dA - dB - carry;
			carry = 0;
			if (result < 0) {
				carry = 1;
				result += 10;
			}

			if (substractString.length() == 0 || result != 0 || idxA >= 0 || idxB >= 0)
				substractString.insert(0, result);
		}
		if (carry > 0)
			substractString.insert(0, carry);

		return  removeZeros(substractString.toString());

	}

	public static String pow10by(int n, String a) {
		StringBuilder result = new StringBuilder(a);
		if (n > 0)
			result.append(String.format("%0" + n + "d", 0));
		return removeZeros(result.toString());
	}

	protected static String padLeftZeros(int n, String a) {
		int numZeroes = n - a.length();
		if (numZeroes <= 0)
			return a;
		return String.format("%0" + numZeroes + "d", 0)+a;
	}
	protected static String removeZeros(String str) {
		 return str.replaceFirst("^0+(?!$)", ""); 
	}
}

package com.tolbier.algorithms.week2.countInv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File("resources/week2/countInv/IntegerArray.txt"));
			int[] tall = new int[100000];
			int i = 0;
			while (scanner.hasNextInt()) {
				tall[i++] = scanner.nextInt();
			}
			long inv= CountInv.countInv(tall);
			System.out.println(inv);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

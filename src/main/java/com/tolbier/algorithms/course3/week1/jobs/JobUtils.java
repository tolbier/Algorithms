package com.tolbier.algorithms.course3.week1.jobs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class JobUtils {
	static Job[] getJobsFromFile(String filePath) {
		Scanner intScanner = null;
		Job[] jobs = null;
		try {
			intScanner = new Scanner(new File(filePath));
			int n = intScanner.nextInt();
			jobs = new Job[n];

			for (int i = 0; i < n; i++) {
				int weight = intScanner.nextInt();
				int length = intScanner.nextInt();

				jobs[i] = new Job(weight, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			intScanner.close();
		}
		return jobs;
	}

	public static void sort(Job[] jobs, JobComparator jc) {
		Arrays.sort(jobs,jc);
	}

	public static long getScheduleTime(Job[] jobs) {
		long completionTime =0;
		long scheduleTime=0;
		for (Job job:jobs) {
			completionTime += job.getLength();
			scheduleTime+= job.getWeight() * completionTime; 
		}
		return scheduleTime ;
		
	}
}

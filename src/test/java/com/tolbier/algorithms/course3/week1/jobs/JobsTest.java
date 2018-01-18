package com.tolbier.algorithms.course3.week1.jobs;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class JobsTest {
	Jobs1 jobs1;

	@Before
	public void init() {
		jobs1 = new Jobs1();
	}

	@Test
	public void testJobs1() {
		assertNotNull(jobs1);
	}
	
	@Test
	public void test1_10() {
		Job[] jobs = JobUtils.getJobsFromFile("resources/course3/week1/jobs_test1_10.txt");
		assertEquals("[[w:43, l:62], [w:95, l:39], [w:3, l:29], [w:25, l:38], [w:47, l:10], [w:63, l:31], [w:79, l:13], [w:93, l:44], [w:87, l:89], [w:11, l:81]]",
				Arrays.asList(jobs).toString());
		JobUtils.sort(jobs,new JobSubstractComparator());
		long scheduleTime =JobUtils.getScheduleTime(jobs);
		assertEquals(74649,scheduleTime);
		JobUtils.sort(jobs,new JobDivideComparator());
		scheduleTime =JobUtils.getScheduleTime(jobs);
		assertEquals(72468,scheduleTime);

		
	}
	
	@Test
	public void test9_40() {
		Job[] jobs = JobUtils.getJobsFromFile("resources/course3/week1/jobs_test9_40.txt");
		JobUtils.sort(jobs,new JobSubstractComparator());
		long scheduleTime =JobUtils.getScheduleTime(jobs);
		assertEquals(1041278,scheduleTime);
		jobs = JobUtils.getJobsFromFile("resources/course3/week1/jobs_test9_40.txt");
		JobUtils.sort(jobs,new JobDivideComparator());
		scheduleTime =JobUtils.getScheduleTime(jobs);
		assertEquals(1008301,scheduleTime);
	}

	@Test
	public void testJobs() {
		Job[] jobs = JobUtils.getJobsFromFile("resources/course3/week1/jobs.txt");
		JobUtils.sort(jobs,new JobSubstractComparator());
		long scheduleTime =JobUtils.getScheduleTime(jobs);

		assertEquals(69119377652l,scheduleTime);
		
		jobs = JobUtils.getJobsFromFile("resources/course3/week1/jobs.txt");
		JobUtils.sort(jobs,new JobDivideComparator());
		scheduleTime =JobUtils.getScheduleTime(jobs);
		assertEquals(67311454237l,scheduleTime);
	}


}

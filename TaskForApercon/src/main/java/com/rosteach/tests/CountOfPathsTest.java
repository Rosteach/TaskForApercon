package com.rosteach.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rosteach.models.CountOfPaths;

public class CountOfPathsTest {
	
	CountOfPaths count = new CountOfPaths();
	
	String firstRes = count.countOfPath(3, 3);
	String testFirstRes = "6";
	
	String secondRes = count.countOfPath(2, 8);
	String testSecondRes = "8";
	
	@Test
	public void testResult(){
		assertEquals(firstRes,testFirstRes);
		assertEquals(secondRes,testSecondRes);
	}
}

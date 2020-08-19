package com.uhg.testng;

import org.testng.annotations.Test;

public class TestClassOne extends InitTest{
	
	@Test
	public void testClassOneMethod1() {
		//extent.createTest("testClassOneMethod1");
		System.out.println("testClassOneMethod1");
	}
	
	
	@Test
	public void testClassOneMethod2() {
		//extent.createTest("testClassOneMethod2");
		System.out.println("testClassOneMethod2");
	}
}

package com.uhg.testng;

import org.testng.annotations.Test;

public class TestClassTwo extends InitTest {
	
	@Test
	public void testClassTwoMethod1() {
		//extent.createTest("testClassTwoMethod1");
		System.out.println("testClassTwoMethod1");
	}
	
	
	@Test
	public void testClassTwoethod2() {
		//extent.createTest("testClassTwoethod2");
		System.out.println("testClassTwoMethod2");
	}
}

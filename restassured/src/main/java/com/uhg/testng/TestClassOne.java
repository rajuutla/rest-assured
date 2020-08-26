package com.uhg.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassOne extends InitTest {

	@Test(groups="smoke")
	public void testClassOneMethod1() {
		System.out.println("testClassOneMethod1");
		
		System.out.println("env var = "+System.getProperty("env"));
		Assert.assertTrue(verifyPageTitle("Google"));
		
		

	}

	@Test
	public void testClassOneMethod2() { 
		System.out.println("testClassOneMethod2");
		System.out.println(getDriver1().getCurrentUrl());
	}

}

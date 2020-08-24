package com.uhg.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassOne extends InitTest {

	@Test
	public void testClassOneMethod1() {
		System.out.println("testClassOneMethod1");
		Assert.assertTrue(verifyPageTitle("google.co.in"));

	}

	@Test
	public void testClassOneMethod2() { 
		System.out.println("testClassOneMethod2");
		System.out.println(getDriver1().getCurrentUrl());
	}

}

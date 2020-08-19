package com.uhg.testng;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InitTest {
	
	public static ExtentReports extent;
	ExtentSparkReporter htmlReporter ;
	ExtentTest logger;
	
	
	
	  @BeforeMethod 
	  public void beforeMethod(Method method) {
	  System.out.println("Executing the method : "+method.getName());
	  System.out.println("extent object = "+extent.toString());
	  logger = extent.createTest(method.getName()+" MyFirstTest"); 
	  }
	 
	
	@BeforeSuite
	public  void beforeTest() {
		
		htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir") +"/target/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case FAILED due to below issues:",
					ExtentColor.RED));
			logger.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case PASSED", ExtentColor.GREEN));
		} else {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "Test Case SKIPPED", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}

	}

}
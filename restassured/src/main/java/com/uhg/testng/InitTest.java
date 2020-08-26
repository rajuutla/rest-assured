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
import com.uhg.base.ElementUtils;

public class InitTest extends ElementUtils {
	
	//public static ThreadLocal<ExtentReports> extent = new ThreadLocal<>();

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest logger;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		System.out.println("Executing the method : " + method.getName());
		//System.out.println("extent object = " + extent.get().toString());
		logger = extent.createTest(method.getName() + " MyFirstTest");

		getDriver();
		launchApp();

	}

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/testReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extent.flush();
	}

	@AfterMethod(alwaysRun = true)
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

		quitBrowser();

	}

}

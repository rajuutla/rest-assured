package com.uhg.selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBrowser {
	 
	@Test
	public void testChromeBrowser() {
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://google.com");
		String url = "http://www.facebook.com";
		
		JavascriptExecutor test = (JavascriptExecutor) driver;
		test.executeScript("window.open()");
		
		System.out.println("windows size = "+driver.getWindowHandles().size());
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
	
		String newTab = Keys.chord(Keys.CONTROL, "t");
		driver.findElement(By.tagName("body")).sendKeys(newTab);
		
		System.out.println("page title = "+driver.getTitle());
		
		
		//Javascript example
		//1. click on the element
		WebElement loginBtn = driver.findElement(By.id("login"));
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);
		
		//get the title of the page
		js.executeScript("return document.title");
		
		//scroll to down
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		//Browser refresh
		js.executeAsyncScript("history.get(0)");
		js.executeScript("arguments[0].scrollIntoView(true)", loginBtn);
		
		//set the background color attribute to green for an element
		loginBtn.getCssValue("backgroundColor");
		js.executeScript("argument[0].style.backgroundColor = 'rgb(0,200,0)'", loginBtn);
		
		/*
		 * Actions action = new Actions(driver);
		 * action.keyDown(Keys.CONTROL).sendKeys(String.valueOf("t")).build().perform();
		 */
		
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 30); By test = By.id("test");
		 * wait.until(new ExpectedCondition<Boolean>() {
		 * 
		 * public Boolean apply(WebDriver input) { return null; } });
		 */		
	}

}

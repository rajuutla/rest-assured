package com.uhg.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleDynamicSearchResult {
	
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://google.co.in");
		
		driver.findElement(By.name("q")).sendKeys("testing");
		
		List<WebElement> dynamic = driver.findElement(By.className("erkvQe")).findElements(By.tagName("li"));
		
		for(WebElement ele : dynamic) {
			System.out.println("text = "+ele.getText());
		}
	}

}

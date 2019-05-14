package com.uhg.selenium.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SikuiTest {

	public static void main(String[] args) throws FindFailed {

		
		String url = "https://www.youtube.com/watch?v=p7-U1_E_j3w";
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		Screen s = new Screen();
		Pattern pat= new Pattern();
		s.wait(pat, 2000);
		s.click();
	}

}

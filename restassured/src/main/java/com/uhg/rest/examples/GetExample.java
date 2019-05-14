package com.uhg.rest.examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetExample {
	
	@Test
	public void testGetRest(){ 		
		given().
			get("http://jsonplaceholder.typicode.com/posts/3").
		then().statusCode(200).log().all();
		 
	}
	
	@Test
	public void verifyTheBody() {
		given().
		  get("http://services.groupkt.com/country/get/iso2code/US").
		 then().
		 	root("RestResponse.result").
		  body("name", equalTo("United States of America")).
		  detachRoot("result").
		  body("result.alpha2_code", equalTo("US")).
		  log().all();
	}
	
	@Test
	public void testExtractTheDataFromJson() {
		
		
		Response response = given().
				get("https://jsonplaceholder.typicode.com/users/1").
				then().
					contentType(ContentType.JSON).and().
					body("username", is("Bret")).extract().response();

		System.out.println("Hurray = "+response.getStatusCode());
		System.out.println("Hurray = "+response.contentType());
		System.out.println("Hurray = "+response.path("company.name"));
		
		
		String test = given().
				get("https://jsonplaceholder.typicode.com/users/1").
			then().
				contentType(ContentType.JSON).and().
				body("username", is("Bret")).extract().path("company.name");
			
	}
	
	@Test
	public void verifyTheList() {
		given().
		  get("http://services.groupkt.com/country/get/all").
		 then().
		  statusCode(200).and(). // and () is not required here.. for readability
		  body("RestResponse.result.name", hasItems("United States of America", "Argentina")).
		  log().all();
	}
	
	//@Test
	public void launchChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
				
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
	}
	
	@Test
	public void testAdvanceGroovy() {
	  	String res = given().
	  		get("http://services.groupkt.com/country/search?text=lands").asString();
	  	
	  	//from(res).asList() -- Try to check where is this from statich method
	}

}

package com.uhg.rest.examples;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;

public class QueryFormParameters {
	
	@Test
	public void testQueryParam() {
		given().
			queryParam("text", "lands").
		get("http://services.groupkt.com/country/search").then().log().all();
	}
	
	//For the POST request ==> Use formParam method
	// The recommended method is 'param' method
	
	@Test
	public void testPathParam() {
		given().
			pathParam("role", "cv").
		get("https://services.groupkt.com/{role}").then().log().all();
		
	}
	
	@Test
	public void setCookiesExample() {
		given().
			cookie("test", "value")
			.get("http://url").then().log().all();
		
		Cookie test = new Cookie.Builder("test", "vaulue").setComment("test").setMaxAge(10).build();
	}

}

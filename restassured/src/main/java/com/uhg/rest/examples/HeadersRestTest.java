package com.uhg.rest.examples;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersRestTest {
	
	@Test
	public void testGetRest(){ 		
		Response response = given().get("http://jsonplaceholder.typicode.com/posts/3");
		
		Headers headerslist = response.getHeaders();
		
		Map<String, String> cookies = response.getCookies();
		Cookie a = response.getDetailedCookie("test");
		
		
		for(Header header: headerslist) {
			System.out.println("Header : "+header.getName()+" , Value : "+header.getValue());
		}
		 
	} 

}

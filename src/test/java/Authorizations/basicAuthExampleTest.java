package Authorizations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class basicAuthExampleTest {

	
	
	@Test
	public void NonPreEmptiveExample() {
		
	//	https://httpbin.org/basic-auth/raghu/testing
			
			
			RequestSpecification reqspec=RestAssured.given();
			reqspec.baseUri("https://httpbin.org");
			reqspec.basePath("basic-auth/raghu/testing");
			
			//Basic Non Preemptive
			//Credentials can't be shared with Server initialy, only shared if Server request
			reqspec.auth().basic("raghu", "testing");
			Response res=reqspec.get();
			System.out.println(res.getStatusLine());
			ResponseBody resbody=res.getBody();
			System.out.println(resbody.toString());
			
	}
	

	@Test
	public void preEmptiveExample() {
		
	//	https://httpbin.org/basic-auth/raghu/testing
			
			
			RequestSpecification reqspec=RestAssured.given();
			reqspec.baseUri("https://httpbin.org");
			reqspec.basePath("basic-auth/raghu/testing");
			
			//Basic Preemptive
			//Credentials will be shared with Server initially
			reqspec.auth().preemptive().basic("raghu", "testing");
			Response res=reqspec.get();
			System.out.println(res.asPrettyString());
			System.out.println(res.getStatusCode());
			
			
	}
	
	
	
	
}

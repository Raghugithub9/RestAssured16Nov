package Authorizations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class bearerTokenExampleTest {
	@Test
	public void bearerTokenAuthTest() {
		
	
			RequestSpecification reqspec=RestAssured.given();
			reqspec.baseUri("https://api-m.sandbox.paypal.com");
			reqspec.basePath("v1/invoicing/invoices?page=3&page_size=4&total_count_required=true");
			
			String token="Bearer A21AAJHV512hXKS8Tt8lPK8CpKFU7qI6B32q5LgRTvwow1_1i0cefHOY2ttyIus00fERA1PqWyUeAD5kaO5Z2Y8lp6aimneSA";
			
			Response res=reqspec.header("Authorization", token).get();
			
			System.out.println(res.asPrettyString());
	}
}

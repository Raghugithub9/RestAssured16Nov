package Authorizations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class digestAuthExampleTest {

	@Test
	public void digestAuthTest() {
		
	
			RequestSpecification reqspec=RestAssured.given();
			reqspec.baseUri("https://httpbin.org");
			reqspec.basePath("digest-auth/undefined/sdet/testing");
			
			reqspec.auth().digest("sdet", "testing");
			Response res=reqspec.get();
			
			System.out.println(res.asPrettyString());
			System.out.println("Digest method executed");
	}
	
}

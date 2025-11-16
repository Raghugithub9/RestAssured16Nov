package APITest;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPiTest {

	
	@Test
	public void getAPIExample() {
		
		
		//Response response=RestAssured.get("https://api.restful-api.dev/objects");
		
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://api.restful-api.dev");
		reqspec.basePath("/objects");
		Response response=reqspec.get();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("Connection"));
		System.out.println(response.getSessionId());
		
		Headers header=response.getHeaders();
		
		for(Header h:header) {
			System.out.println("Key is "+h.getName()+"     "+"Value is "+h.getValue());
		}
		
		//Validate Status Code
		int act_code=response.getStatusCode();
		int exp_code=200;
		Assert.assertEquals(act_code, exp_code);
		
		//Validate Header Connection
		String act_con=response.getHeader("Connection");
		String exp_con="keep-alive";
		Assert.assertEquals(exp_con, act_con);
	}
	
	
}

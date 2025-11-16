package APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class getTest {
	
	@Test
	public void getTestMethod() {
		
		Response response=RestAssured.get("https://api.restful-api.dev/objects");
	
		
		System.out.println("Status Code is "+response.getStatusCode());
		System.out.println("Status Line is "+response.getStatusLine());
		System.out.println(response.getBody());
		System.out.println(response.getTime());
		System.out.println(response.getHeader("Content-Type"));
		
		int exp_code=200;
		int act_code=response.getStatusCode();
		
		Assert.assertEquals(exp_code, act_code);
		
		Headers header=response.getHeaders();
		
		for(Header h:header) {
			System.out.println("Key is "+h.getName()+"     "+"Value is "+h.getValue());
		}
		
		
	/*	if(exp_code==act_code) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED");
		}
		*/
	}
	
	

}

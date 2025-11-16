package APITest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class getMethodTest {

	@Test
	public void GETMethodTesting() {
		
RequestSpecification reqspec=RestAssured.given();
		
		reqspec.baseUri("https://api.restful-api.dev/");
		reqspec.basePath("/objects");
		
		Response response=reqspec.get();
		
		System.out.println(response.asPrettyString());
		
		
		ResponseBody resbody=response.getBody();
		
		JsonPath jsonpath=resbody.jsonPath();
		
		int year=jsonpath.get("[6].data.year");
		String name=jsonpath.get("[2].name");
		String color=jsonpath.get("[4].data.color");
		
		System.out.println("Year is "+year);
		System.out.println("Name is "+name);
		System.out.println("Color is "+color);
		
		//System.out.println(response.getSessionId());
		//System.out.println(response.getStatusLine());
		
		
	}
	
}

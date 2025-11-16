package APIMethods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class POSTExampleTest {

	@Test
	public void testPOSTMethod1() {
		
		baseURI="https://api.restful-api.dev/objects";
		
		JSONObject jsondata1=new JSONObject();
		jsondata1.put("year", 2025);
		jsondata1.put("price", 12345);
		jsondata1.put("CPU model", "Intel");
		jsondata1.put("Hard disk size", "1 TB");
		
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Apple MacBook SDET");
		jsondata.put("data", jsondata1);
		
	given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
	.when()
		.post()
	.then()
		.statusCode(200)
		.log();
	}
		
	
	
	
	@Test
	public void testPOSTMethod2() {
		
		baseURI="https://reqres.in/api/users";
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "SDET");
		jsondata.put("job", "Trainer");
	
	given()
		.header("Content-Type", "application/json")
		.header("x-api-key","reqres-free-v1")
		.contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
	.when()
		.post()
	.then()
		.statusCode(201);
	
	System.out.println("POST Method Executed");
	}
	
	
	
}

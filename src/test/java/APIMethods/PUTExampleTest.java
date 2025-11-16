package APIMethods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PUTExampleTest {

	@Test
	public void testPUTMethod1() {
		
		baseURI="https://api.restful-api.dev/objects/ff8081819782e69e0197e07cd3b52c59";
		
		JSONObject jsondata1=new JSONObject();
		jsondata1.put("year", 2027);
		jsondata1.put("price", 1234225);
		jsondata1.put("CPU model", "Intel");
		jsondata1.put("Hard disk size", "3 TB");
		
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Apple MacBook SDET-PUT");
		jsondata.put("data", jsondata1);
		
	given()
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsondata.toJSONString())
	.when()
		.put()
	.then()
		.statusCode(200)
		.log()
		.all();
	}
		
	
	@Test
	public void testPOSTMethod2() {
		
		baseURI="https://api.restful-api.dev/objects";
		
		JSONObject jsondata1=new JSONObject();
		jsondata1.put("year", 2027);
		jsondata1.put("price", 1234225);
		jsondata1.put("CPU model", "Intel");
		jsondata1.put("Hard disk size", "3 TB");
		
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Apple MacBook SDET-PUT");
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
	
	
}

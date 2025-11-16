package APITest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;;

public class cucumberTest {

	
	
	
	@Test
	public void testAPI() {
		
		baseURI="https://api.restful-api.dev/objects";
		
		given().
		when().
			get().
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void testAPIwithQueryParam() {
		
		baseURI="https://api.restful-api.dev/objects";
		
		given().
			queryParam("page", 2).
		when().
			get().
		then().
			statusCode(200);
		
		
	}
	
}

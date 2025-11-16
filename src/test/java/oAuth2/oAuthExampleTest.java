package oAuth2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class oAuthExampleTest {

	String atoken;
	
	@Test
	public void generateToken() {
		
		String client_id="AQjbOYUOFCqAVkftquouQn7KP1rRRpmp2_2RMYp2W8_hXqGjwTRA2iuly11yMjWaYdEUrv_J6WhbKr9Y";
		String secret_id="EMe81AJ9dVdQq8Jx23vNaqvyuKEdHgkptX9kqiBbdxbl-gJ8ulbiquBiT9s4lbc5exR-AKTCCNbWKRiV";
		
		RequestSpecification reqspec=RestAssured.given();
		reqspec.baseUri("https://api-m.sandbox.paypal.com");
		reqspec.basePath("v1/oauth2/token");
		
		reqspec.auth().preemptive().basic(client_id, secret_id).param("grant_type", "client_credentials");
		Response res=reqspec.post();
		
		System.out.println(res.asPrettyString());
		
		 atoken=res.getBody().path("access_token");
		System.out.println(atoken);
		;
	}
	
	
	@Test(dependsOnMethods= {"generateToken"})
	public void getInvoice() {
		
		RequestSpecification reqspec=RestAssured.given();
		Response res=reqspec
						.auth()
							.oauth2(atoken)
							.queryParam("page","2")
							.queryParam("page_size", "4")
							.queryParam("total_count_required", "true")
						.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");	
		
		System.out.println(res.asPrettyString());
	
	}
	
}

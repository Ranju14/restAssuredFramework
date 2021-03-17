package serviceRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import io.restassured.RestAssured;
//import io.restassured.RestAssured.http.ContentType;

import static io.restassured.RestAssured.given;

import static com.jayway.restassured.RestAssured.*;


public class GetRequest {
	
	@Test
	
	public void getRequestWithDaysAndPostalCode( int days, int postcode ) {
		
		RestAssured.baseURI = "https://api.weatherbit.io/v2.0/forecast/daily";
		RestAssured.basePath = "/postal_code=2026&country=AU&days=90&key=5a55d544a7eb4bb18016cdcc2bb7b895";
		
//		Response res = given().contentType(ContentType.JSON).log().all().get();
		
		
//		Response resp = given().contentType(ContentType.JSON).log().all().get();
	}
	 

}

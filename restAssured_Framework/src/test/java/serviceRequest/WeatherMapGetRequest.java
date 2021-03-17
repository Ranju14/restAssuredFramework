package serviceRequest;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class WeatherMapGetRequest {

//		@Test
	public void getRequestByCityName() {
		Response res = when().
				get("http://api.openweathermap.org/data/2.5/weather?q=Sydney&cnt=7&appid=2faa21997490f6c6a49a3b41bc05bda8");
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		int Temp = res.then().contentType(ContentType.JSON).extract().path("sys.type");
		System.out.println(Temp);

	}

		@Test
	public void getRequestByPassingParameters() {
		given().
		param("q","Sydney").
		param("appid","2faa21997490f6c6a49a3b41bc05bda8").
		when().get("http://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().
		statusCode(200);

	}
	@Test
	public void getRequestByPassingPostalCode() {

		given().
		parameter("postal_code","2026").
		parameter("key","5a55d544a7eb4bb18016cdcc2bb7b895").
		when().
		get("https://api.weatherbit.io/v2.0/forecast/daily").then().assertThat().statusCode(200);



		Response res = given().
				parameter("postal_code","2026").
				parameter("country","AU").
				parameter("days","90").
				parameter("key","5a55d544a7eb4bb18016cdcc2bb7b895").
				when().
				get("http://api.weatherbit.io/v2.0/forecast/daily").then().contentType(ContentType.JSON).
				extract().response();
//		res.prettyPrint();

		String lat = given().
				parameter("postal_code","2026").
				parameter("country","AU").
				parameter("days","90").
				parameter("key","5a55d544a7eb4bb18016cdcc2bb7b895").
				when().
				get("http://api.weatherbit.io/v2.0/forecast/daily").
				then().
				contentType(ContentType.JSON).
				extract().path("lat");
		
		String lat1 = res.then().contentType(ContentType.JSON).extract().path("lat");


		System.out.println(lat);
		System.out.println(lat1);
		
		com.jayway.restassured.path.json.JsonPath extractor = res.jsonPath();
		String lat2 = extractor.get("lat");
		
		System.out.println(lat2);
		
		//extract parameters uv from all the array
		ArrayList<Float> uv = extractor.get("data.uv");
		for (Float m : uv) {
			System.out.println(m);
		}

		//extract parameters validDate from all the array
				ArrayList<String> date = extractor.get("data.valid_date");
				for (String m: date) {
					System.out.println(m);
				}



	}


}

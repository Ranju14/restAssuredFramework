package serviceRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void getResposeData()
	{
	Response resp= RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
	int code = resp.getStatusCode();
	String data = resp.asString();
	System.out.println("The status code is "+code);
	Assert.assertEquals(code, 200);
	System.out.println("The data is"+data);
	System.out.println("The response time is "+resp.getTime());
	}

}

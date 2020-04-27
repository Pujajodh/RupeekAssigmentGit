package org.RupeekAssign.Assignment;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.rupeekAssign.generic.BaseClassLib;
import org.rupeekAssign.generic.EndPonits;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rupeek_01 extends BaseClassLib {

	@Test
	public void getToken() {
		// Response Object
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", "rupeek");
		requestParams.put("password", "password");

		request.contentType(ContentType.JSON);
		request.body(requestParams.toJSONString());

		Response response = request.post("/authenticate");
		String token = response.path("token");
		// verification
		Assert.assertEquals(response.getStatusCode(), 200);

		// GET request for get all the records of customer
		Response response1 = given().auth().oauth2(token).get(EndPonits.GET_ALL_USERS);
		System.out.println(response1.getStatusCode());

		// GET request to get PHONE NUMBER of customers
		String phone = (String) requestParams.get("phone");
		String path = EndPonits.GET_USER_WITH_PHONENO + phone;

		Response response2 = given().auth().oauth2(token).get(path);
		// verification
		Assert.assertEquals(response2.getStatusCode(), 200);

	}
}

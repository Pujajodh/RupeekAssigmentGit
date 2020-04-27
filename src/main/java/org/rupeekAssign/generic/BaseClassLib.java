package org.rupeekAssign.generic;

import static io.restassured.RestAssured.baseURI;

import org.testng.annotations.BeforeSuite;

/**
 * @author PUJA
 */
public class BaseClassLib {
	/*
	 * to initialize the base URI and authentication
	 */

	@BeforeSuite
	public void baseURL() {

		baseURI = "http://13.126.80.194:8080";

	}
	
}

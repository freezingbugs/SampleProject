package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {

	String url = RestAssured.baseURI = "https://reqres.in/api/users/2";
	RequestSpecification httpRequest = RestAssured.given();	
	Response response = httpRequest.get("");
	int statusCode = response.getStatusCode();

	@Test(priority = 2)
	void getUsers() {

		given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
	Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "InCorrect status code returned");
	}

	@Test(priority = 1)
	void createUser() {

		HashMap data = new HashMap();
		data.put("name", "Issac");
		data.put("job", "Scientist");

		given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").then()
				.statusCode(201).log().all();
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "InCorrect status code returned");
 
	}

}

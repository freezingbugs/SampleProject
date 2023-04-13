package apiTesting;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {

	@Test(priority=1)
	void getUsers() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority=2)
	void createUser() {
		
		HashMap data = new HashMap();
		data.put("name","Issac");
		data.put("Issac","Scientist");
		
		given()
		.contentType("application/json")
		.body(data)
		.when().post("https://reqres.in/api/users")				
		.then().statusCode(201).log().all();

	}

}

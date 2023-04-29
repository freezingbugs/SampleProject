package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Steps {

	String url = RestAssured.baseURI = "https://reqres.in/api/users/2";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.get("");
	int statusCode = response.getStatusCode();

	@Given("Get Users By Id")
	@Test(priority = 2)
	public void get_users_by_id() {
		// Write code here that turns the phrase above into concrete actions
		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "InCorrect status code returned");
	}

	@Then("Create Users")
	@Test(priority = 1)
	public void create_users() {
		// Write code here that turns the phrase above into concrete actions
		HashMap<Object, Object> data = new HashMap<Object, Object>();
		data.put("name", "Issac");
		data.put("job", "Scientist");

		given().contentType("application/json").body(data).when().post("https://reqres.in/api/users").then()
				.statusCode(201).log().all();
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "InCorrect status code returned");

	}
}

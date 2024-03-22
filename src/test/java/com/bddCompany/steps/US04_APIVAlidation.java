package com.bddCompany.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class US04_APIVAlidation {
    Response response;
    String URL;
    @Given("API sends the request to this {string} end point")
    public void api_sends_the_request_to_this_end_point(String URL) {
        this.URL = URL;
        response = given().accept(ContentType.JSON).get(URL);
        //System.out.println("Connection " + response.header("Connection"));
        System.out.println("Content-type " + response.header("Content-type"));
        Assertions.assertEquals("application/json; charset=utf-8", response.header("Content-type"));
        Object id = response.path("id");
        System.out.println(id);
    }

    @When("API sends a request you expect the status code to be {int}")
    public void api_sends_a_request_you_expect_the_status_code_to_be(Integer int1) {
        int statusCode = response.statusCode();
        Assertions.assertEquals(int1, statusCode );
    }

    @When("Retrieve all the data from path id={int}")
    public void retrieve_all_the_data_from_path_id(Integer ID) {
        JsonPath jsonPath = given().
                accept(ContentType.JSON)
                .and()
                .pathParam("id", ID)
                .when().get(URL + "/{id}").then().extract().jsonPath();
        jsonPath.prettyPeek();
        System.out.println("id = " + jsonPath.getString("id"));
    }
}

package com.bddCompany.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.devtools.v117.fetch.model.AuthChallengeResponse;

public class US02 {
    @Given("status code needs to be {int}")
    public void status_code_needs_to_be(Integer int1) {
        Response response = RestAssured.given().get("http://swapi.dev/api/planets/1")
                .prettyPeek().then().statusCode(200).extract().response();

        JsonPath jsonPath = response.jsonPath();
        String diameterValue = jsonPath.getString("diameter");
        System.out.println(diameterValue);

        System.out.println(jsonPath.getString("residents[6]"));



    }
}

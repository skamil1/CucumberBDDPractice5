package com.bddCompany.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class US05_Pokeman {
    @Given("user get some data from pokeman website")
    public void user_get_some_data_from_pokeman_website() {
        Response response = RestAssured.given().accept(ContentType.JSON)

                .when().get("https://pokeapi.co/api/v2/pokemon/ditto");

        response.statusCode();

        int firstGameIndex = response.path("game_indices[0].game_index");
        System.out.println(firstGameIndex);

        String firstGameVersionName = response.path("game_indices[0].version.name");
        System.out.println(firstGameVersionName);


        Object path = response.path("held_items[1]");
        System.out.println(path);
    }
}

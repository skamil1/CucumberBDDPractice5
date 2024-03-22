package com.bddCompany.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class US06_Token {
    @Given("a user login with auth")
    public void a_user_login_with_auth() {
        String accessToken = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhdHVueTAiLCJlbWFpbCI6ImF0dW55MEBzb2h1LmNvbSIsImZpcnN0TmFtZSI6IlRlcnJ5IiwibGFzdE5hbWUiOiJNZWRodXJzdCIsImdlbmRlciI6Im1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vcm9ib2hhc2gub3JnL1RlcnJ5LnBuZz9zZXQ9c2V0NCIsImlhdCI6MTcxMDUxMzM2MywiZXhwIjoxNzEwNTE2OTYzfQ.KfSPcXH1TSvdhJCWlDCx2iurro2R_XGhG1vl3NKnTVs";

        RestAssured.given().header("Authorization", accessToken)
                .when().get("https://dummyjson.com/auth/me").prettyPeek()
                .then().statusCode(200);
    }
}

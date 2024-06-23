package starter.admin.ManageUser;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetUser {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjNkZTc3ZDNhLTA1NDItNDY0My04N2ZkLTcxNWNhZmEzYzExNyIsIlVzZXJuYW1lIjoiYWRtaW50b3VyZWFzZSIsIlJvbGUiOiJhZG1pbiIsImV4cCI6MTcxOTE1NzI3MCwiaWF0IjoxNzE5MTU2MDcwLCJuYmYiOjE3MTkxNTYwNzB9.JdtgZ25Fr_1Z3-oaOHjbkX1DWwGsiLiqrAxxAuoTEgY";

    @Step("I set API endpoint for get all user detail")
    public String setGetAllUserApiEndpoint() {
        return url + "/users";
    }

    @Step("I send a GET request for get all user detail")
    public void sendGetAllUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetAllUserApiEndpoint());
    }

    @Step("I received a valid data from all user")
    public void receivedAllUserData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_USER_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'no_telepon'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'jenis_kelamin'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'provinsi'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'total'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'per_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'current_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'last_page'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get user detail by ID")
    public String setGetIDUserApiEndpoint() {
        return url + "/users/00bddbb8-8e7d-46ab-acfc-aab981c1ada1";
    }

    @Step("I send a GET request with valid user ID")
    public void sendGetIDUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetIDUserApiEndpoint());
    }

    @Step("I received a valid data from selected user")
    public void receivedSelectedUserData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ID_USER_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'nama_lengkap'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'bio'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'no_telepon'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'foto_profil'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'jenis_kelamin'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'provinsi'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get user detail by invalid ID")
    public String setFailedGetIDUserApiEndpoint() {
        return url + "/users/0483c5ae-046a-403a-a656-db920635396b";
    }

    @Step("I send a GET request with invalid user ID")
    public void sendFailedGetIDUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setFailedGetIDUserApiEndpoint());
    }

    @Step("I receive status code 404")
    public void receiveStatusCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I received a failed get user message")
    public void receivedFailedGetUserMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

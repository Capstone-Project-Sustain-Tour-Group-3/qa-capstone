package starter.admin.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class Authentication {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjQ5Y2FmNDBhLWY4N2MtNDU1Ni1hZjU5LTBjNWVmYTNlMzhmMCIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTgwMDkwNTMsImlhdCI6MTcxODAwNTQ1MywibmJmIjoxNzE4MDA1NDUzfQ.lUxiUoXw-0Njn9xD5TtAsOGZGKlI373TKbfy87ue6tA";

    @Step("I set API endpoint for login")
    public String setLoginApiEndpoint() {
        return url + "/auth/login";
    }

    @Step("I send a POST request with valid user credentials")
    public void sendLoginRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("username", "admin");
        requestBody.put("password", "admintourease123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setLoginApiEndpoint());
    }

    @Step("I receive status code 200")
    public void receiveStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I successfully logged in to the account")
    public void successfullyLoggedIn() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_LOGIN_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'profile_image'", nullValue()));
        restAssuredThat(response -> response.body("'data'.'role'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'access_token'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request with invalid username")
    public void sendInvalidUsernameLoginRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("username", "notadmin");
        requestBody.put("password", "admintourease123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setLoginApiEndpoint());
    }

    @Step("I receive status code 401")
    public void receiveStatusCode401() {
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("I received a failed admin login message")
    public void unsuccessfullyLoggedIn() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request with invalid password")
    public void sendInvalidPasswordLoginRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("username", "admin");
        requestBody.put("password", "wrongpass");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setLoginApiEndpoint());
    }

    @Step("I set API endpoint for logout")
    public String setLogoutApiEndpoint() {
        return url + "/auth/logout";
    }

    @Step("I send a DELETE request for logout")
    public void sendLogoutRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setLogoutApiEndpoint());
    }

    @Step("I successfully logged out from the account")
    public void successfullyLoggedOut() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGOUT_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

package starter.admin.ManageUser;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteUser {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjQ5Y2FmNDBhLWY4N2MtNDU1Ni1hZjU5LTBjNWVmYTNlMzhmMCIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTg4NzE4NDAsImlhdCI6MTcxODg2ODI0MCwibmJmIjoxNzE4ODY4MjQwfQ.zAXfj5bicpinTQ8Lnj_8JEfRfTKYviJFL1RB1duN9sQ";

    @Step("I set API endpoint for delete user data")
    public String setDeleteUserApiEndpoint() {
        return url + "/users/142a3f9f-146c-4719-83cb-95b06e200af6";
    }

    @Step("I send a DELETE request for delete user data")
    public void sendDeleteUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setDeleteUserApiEndpoint());
    }

    @Step("I received a success delete user message")
    public void receivedSuccessDeleteUserMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for delete user data with invalid ID")
    public String setInvalidDeleteUserApiEndpoint() {
        return url + "/users/0483c5ae-046a-403a-a656-db920635396b";
    }

    @Step("I send a DELETE request with invalid user ID")
    public void sendInvalidDeleteUserRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setInvalidDeleteUserApiEndpoint());
    }
}

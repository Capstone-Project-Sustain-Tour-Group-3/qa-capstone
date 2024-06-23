package starter.admin.ManageContent;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteContent {
    private static String url = "https://api.tourease.my.id/v1";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6ImU1NTNkMWFiLTliOTItNDQyNS1hMzU3LWI3ZWQ0OTgwMWYxMyIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTc1OTczNjcsImlhdCI6MTcxNzU5NzA2NywibmJmIjoxNzE3NTk3MDY3fQ.w_xEpnbFYEsyQ_HRRfccnaNCWrUqn2vu6wbCplnO_DM";

    @Step("I set API endpoint for delete content")
    public String setDeleteContentApiEndpoint() {
        return url + "/admin/destination-media/1bde58e3-ef19-4daa-9df7-084ba5d3e941";
    }

    @Step("I send a DELETE request for delete content")
    public void sendDeleteContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setDeleteContentApiEndpoint());
    }

    @Step("I received a success delete content message")
    public void receivedSuccessDeleteContentMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for delete content with invalid ID")
    public String setInvalidDeleteContentApiEndpoint() {
        return url + "/admin/destination-media/1bde58e3-ef19-4daa-9df7-084ba5d3e941";
    }

    @Step("I send a DELETE request with invalid content ID")
    public void sendInvalidDeleteContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setInvalidDeleteContentApiEndpoint());
    }
}

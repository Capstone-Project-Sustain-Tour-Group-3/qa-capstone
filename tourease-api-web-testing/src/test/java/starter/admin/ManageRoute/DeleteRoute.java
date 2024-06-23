package starter.admin.ManageRoute;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class DeleteRoute {
    private static String url = "https://api.tourease.my.id/v1";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6ImU1NTNkMWFiLTliOTItNDQyNS1hMzU3LWI3ZWQ0OTgwMWYxMyIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTc1OTczNjcsImlhdCI6MTcxNzU5NzA2NywibmJmIjoxNzE3NTk3MDY3fQ.w_xEpnbFYEsyQ_HRRfccnaNCWrUqn2vu6wbCplnO_DM";

    @Step("I set API endpoint for delete route")
    public String setDeleteRouteApiEndpoint() {
        return url + "/admin/routes/e55eac90-521d-4cc5-879a-d208870f0275";
    }

    @Step("I send a DELETE request for delete route")
    public void sendDeleteRouteRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setDeleteRouteApiEndpoint());
    }

    @Step("I received a success delete route message")
    public void receivedSuccessDeleteRouteMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for delete route with invalid ID")
    public String setInvalidDeleteUserApiEndpoint() {
        return url + "/admin/routes/e55eac90-521d-4cc5-879a-d208870f0275";
    }

    @Step("I send a DELETE request with invalid route ID")
    public void sendInvalidDeleteRouteRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setInvalidDeleteUserApiEndpoint());
    }

    @Step("I received a route not found message")
    public void receivedFailedDeleteRouteMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

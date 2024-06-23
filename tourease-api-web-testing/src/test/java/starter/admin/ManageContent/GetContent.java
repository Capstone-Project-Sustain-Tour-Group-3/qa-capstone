package starter.admin.ManageContent;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetContent {
    private static String url = "https://api.tourease.my.id/v1";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjQ5Y2FmNDBhLWY4N2MtNDU1Ni1hZjU5LTBjNWVmYTNlMzhmMCIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTgxMzUxNTksImlhdCI6MTcxODEzMTU1OSwibmJmIjoxNzE4MTMxNTU5fQ.NMqDNNbtRvzcGtw5Wb0w8Lg8OMRwCk1Ezw9kiT-67zc";

    @Step("I set API endpoint for get all content")
    public String setGetAllContentApiEndpoint() {
        return url + "/admin/destination-media";
    }

    @Step("I send a GET request for get all content")
    public void sendGetAllContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetAllContentApiEndpoint());
    }

    @Step("I received a valid data from all content")
    public void receivedAllContent() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CONTENT_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destination_id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'url'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'type'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'title'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destination'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destination'.'name'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get content by ID")
    public String setGetIDContentApiEndpoint() {
        return url + "/admin/destination-media";
    }

    @Step("I send a GET request with valid content ID")
    public void sendGetIDContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetIDContentApiEndpoint());
    }

    @Step("I received a valid data from selected content")
    public void receivedSelectedContent() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ID_CONTENT_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destination_id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'url'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'type'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'title'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destination'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destination'.'name'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get content by invalid ID")
    public String setFailedGetIDContentApiEndpoint() {
        return url + "/admin/destination-media/00288a35-9e58-4fb5-8e1d-894c3e0ca43b";
    }

    @Step("I send a GET request with invalid content ID")
    public void sendFailedGetIDContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setFailedGetIDContentApiEndpoint());
    }

    @Step("I received a failed get content message")
    public void receivedFailedGetContentMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

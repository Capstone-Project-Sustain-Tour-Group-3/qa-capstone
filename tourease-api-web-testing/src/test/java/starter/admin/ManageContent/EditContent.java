package starter.admin.ManageContent;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class EditContent {
    private static String url = "https://api.tourease.my.id/v1";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6ImU1NTNkMWFiLTliOTItNDQyNS1hMzU3LWI3ZWQ0OTgwMWYxMyIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTc1OTcxNDgsImlhdCI6MTcxNzU5Njg0OCwibmJmIjoxNzE3NTk2ODQ4fQ.eygz5sLIjFb1iPQQ3TXJ33ejUDj2FoFr056vLp7KlbU";

    @Step("I set API endpoint for edit content")
    public String setEditContentApiEndpoint() {
        return url + "/admin/destination-media/00288a35-9e58-4fb5-8e1d-894c3e0ca43a";
    }

    @Step("I send a PUT request for edit content")
    public void sendEditContentRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("destination_id", "306d305e-3359-4884-8d38-89c04e8adec2");
        requestBody.put("url", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.video");
        requestBody.put("nama_lengkap", "nama_lengkap");
        requestBody.put("type", "video");
        requestBody.put("title", "We Are Going On Bullrun 3");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setEditContentApiEndpoint());
    }
    @Step("I send a PUT request for edit content without body data")
    public void sendInvalidEditContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .put(setEditContentApiEndpoint());
    }

    @Step("I received a failed edit content message")
    public void receivedFailedEditContent() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_EDIT_CONTENT_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'errors'.'field'", nullValue()));
        restAssuredThat(response -> response.body("'errors'.'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a PUT request for edit content with invalid url format")
    public void sendFailedEditContentUrlRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("destination_id", "306d305e-3359-4884-8d38-89c04e8adec2");
        requestBody.put("url", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.png");
        requestBody.put("nama_lengkap", "nama_lengkap");
        requestBody.put("type", "video");
        requestBody.put("title", "We Are Going On Bullrun 3");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setEditContentApiEndpoint());
    }

    @Step("I set API endpoint for edit content by invalid ID")
    public String setFailedEditIDContentApiEndpoint() {
        return url + "/admin/destination-media/00288a35-9e58-4fb5-8e1d-894c3e0ca43b";
    }

    @Step("I send a PUT request with invalid content ID")
    public void sendFailedEditIDContentRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("destination_id", "306d305e-3359-4884-8d38-89c04e8adec2");
        requestBody.put("url", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.video");
        requestBody.put("nama_lengkap", "nama_lengkap");
        requestBody.put("type", "video");
        requestBody.put("title", "We Are Going On Bullrun 3");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .put(setFailedEditIDContentApiEndpoint());
    }

    @Step("I received a content not found message")
    public void receivedFailedEditContentMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

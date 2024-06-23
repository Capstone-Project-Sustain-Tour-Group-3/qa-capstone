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

public class AddContent {
    private static String url = "https://api.tourease.my.id/v1";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjQ5Y2FmNDBhLWY4N2MtNDU1Ni1hZjU5LTBjNWVmYTNlMzhmMCIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTgwMDg3ODcsImlhdCI6MTcxODAwNTE4NywibmJmIjoxNzE4MDA1MTg3fQ.mBDUeBzMCRpE_VOU85RuOQLFZFlUE3gGQdQNlMPn-L8";

    @Step("I set API endpoint for add content")
    public String setAddContentApiEndpoint() {
        return url + "/admin/destination-media";
    }

    @Step("I send a POST request for add content")
    public void sendAddContentRequest() {
        JSONObject requestBody = new JSONObject();

        requestBody.put("destination_id", "306d305e-3359-4884-8d38-89c04e8adec2");
        requestBody.put("url", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.video");
        requestBody.put("type", "video");
        requestBody.put("title", "We Are Going On Bullrun 3");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAddContentApiEndpoint());
    }

    @Step("I received a valid data from new content")
    public void receivedNewContentData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ADD_CONTENT_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request for add content without body data")
    public void sendInvalidAddContentRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .post(setAddContentApiEndpoint());
    }

    @Step("I received a failed add content message")
    public void receivedFailedAddContent() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_ADD_CONTENT_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'errors'.'field'", nullValue()));
        restAssuredThat(response -> response.body("'errors'.'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a POST request for add content with invalid url format")
    public void sendInvalidAddContentUrlRequest() {
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
                .post(setAddContentApiEndpoint());
    }
}

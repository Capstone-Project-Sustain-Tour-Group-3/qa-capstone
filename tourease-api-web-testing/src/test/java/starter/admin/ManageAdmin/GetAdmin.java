package starter.admin.ManageAdmin;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAdmin {
    private static String url = "https://api.tourease.my.id/v1/admin";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6ImU1NTNkMWFiLTliOTItNDQyNS1hMzU3LWI3ZWQ0OTgwMWYxMyIsIlVzZXJuYW1lIjoic3VwZXJhZG1pbiIsIlJvbGUiOiJzdXBlcmFkbWluIiwiZXhwIjoxNzE5MjA4MTkwLCJpYXQiOjE3MTkyMDY5OTAsIm5iZiI6MTcxOTIwNjk5MH0.LGVpRkciPjYSmGAgOZOuNf9W1K2nDDCBVW115iwphsQ";

    @Step("I set API endpoint for get all admin detail")
    public String setGetAllAdminApiEndpoint() {
        return url + "/admins";
    }

    @Step("I send a GET request for get all admin detail")
    public void sendGetAllAdminRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetAllAdminApiEndpoint());
    }

    @Step("I received a valid data from all admin")
    public void receivedAllAdminData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ADMIN_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'tanggal_pembuatan'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'total'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'per_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'current_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'last_page'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get admin detail by ID")
    public String setGetIDAdminApiEndpoint() {
        return url + "/admins/53920f5b-f8dd-4bc5-9b3d-58c5fdfe9354";
    }

    @Step("I send a GET request with valid admin ID")
    public void sendGetIDAdminRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetIDAdminApiEndpoint());
    }

    @Step("I received a valid data from selected admin")
    public void receivedSelectedUserData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ID_ADMIN_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'foto_profil'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'tanggal_pembuatan'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get admin detail by invalid ID")
    public String setFailedGetIDAdminApiEndpoint() {
        return url + "/admins/49caf40a-f87c-4556-af59-0c5efa3e38f1";
    }

    @Step("I send a GET request with invalid admin ID")
    public void sendFailedGetIDAdminRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setFailedGetIDAdminApiEndpoint());
    }

    @Step("I received a failed get admin message")
    public void receivedFailedGetAdminMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

package starter.admin.ManageRoute;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetRoute {
    private static String url = "https://api.tourease.my.id/v1";
    private static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjQ5Y2FmNDBhLWY4N2MtNDU1Ni1hZjU5LTBjNWVmYTNlMzhmMCIsIlVzZXJuYW1lIjoiYWRtaW4iLCJSb2xlIjoiYWRtaW4iLCJleHAiOjE3MTgxMjQzNDksImlhdCI6MTcxODEyMDc0OSwibmJmIjoxNzE4MTIwNzQ5fQ.5ug9zPEp_L25mgSbAH4OSFucYyF_f8j7XB6BEaFYa8c";

    @Step("I set API endpoint for get all route")
    public String setGetAllRouteApiEndpoint() {
        return url + "/admin/routes/";
    }

    @Step("I send a GET request for get all route")
    public void sendGetAllRouteRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetAllRouteApiEndpoint());
    }

    @Step("I received a valid data from all route")
    public void receivedAllRouteData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ROUTE_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'nama_rute'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destinasi'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destinasi'.'nama_destinasi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'estimasi_biaya'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'total'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'per_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'current_page'", notNullValue()));
        restAssuredThat(response -> response.body("'pagination'.'last_page'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get user route by ID")
    public String setGetIDRouteApiEndpoint() {
        return url + "/admin/routes/179665db-dfba-4d10-8371-29d2ce169cc2";
    }

    @Step("I send a GET request with valid route ID")
    public void sendGetIDRouteRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setGetIDRouteApiEndpoint());
    }

    @Step("I received a valid data from selected route")
    public void receivedSelectedRouteData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ID_ROUTE_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'username'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'kota'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destinasi'.'id'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'destinasi'.'nama_destinasi'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'estimasi_biaya'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set API endpoint for get route by invalid ID")
    public String setFailedGetIDRouteApiEndpoint() {
        return url + "/admin/routes/e55eac90-521d-4cc5-879a-d208870f0275";
    }

    @Step("I send a GET request with invalid route ID")
    public void sendFailedGetIDRouteRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setFailedGetIDRouteApiEndpoint());
    }

    @Step("I received a failed get route message")
    public void receivedFailedGetRouteMessage() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.FAILED_SCHEMA);

        restAssuredThat(response -> response.body("'status'", notNullValue()));
        restAssuredThat(response -> response.body("'message'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

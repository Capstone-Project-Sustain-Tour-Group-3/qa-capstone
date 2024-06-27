package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Register {

    private String URL = "https://api.tourease.my.id/v1/mobile/auth/register";

    public String IsetOnTheRegisterPoint() {
        return URL;
    }

    @Step
    public void ISendToServerRegisterPostWithValidInput() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "Paijo12345");
        requestBody.put("nama_lengkap", "John Doe");
        requestBody.put("email", "Paijo123450@example.com");
        requestBody.put("no_telepon", "081234567891");
        requestBody.put("password", "11111111");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheRegisterPoint())
                .then()
                .log().all(); ;


    }


    @Step
    public void CheckThatIGetAppropriateResponseForValidRegisterRequest() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JSON_Schema.REGISTER_SCHEMA);

        restAssuredThat(response ->  response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step
    public void ISendToServerRegisterPostWithConflictUsername() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "Babababab");
        requestBody.put("nama_lengkap", "John Doe");
        requestBody.put("email", "Nausicaa3@example.com");
        requestBody.put("no_telepon", "081234567891");
        requestBody.put("password", "11111111");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheRegisterPoint());;
    }

    @Step
    public void ISendToServerRegisterPostWithWrongEmailFormat() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "Babababab");
        requestBody.put("nama_lengkap", "John Doe");
        requestBody.put("email", "Nausicaa3example.com");
        requestBody.put("no_telepon", "081234567891");
        requestBody.put("password", "11111111");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheRegisterPoint());;
    }

    @Step
    public void ISendToServerRegisterPostWithConflictEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "Babababab");
        requestBody.put("nama_lengkap", "John Doe");
        requestBody.put("email", "Nausicaa3@example.com");
        requestBody.put("no_telepon", "081234567891");
        requestBody.put("password", "11111111");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetOnTheRegisterPoint());;
    }


    @Step
    public void CheckThatIGetAppropriateResponseForConflictRegisterRequest() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.REGISTER_SCHEMA);
        restAssuredThat(response ->  response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }









}

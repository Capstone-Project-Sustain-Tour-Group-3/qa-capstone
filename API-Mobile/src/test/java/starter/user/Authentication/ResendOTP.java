package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ResendOTP {
    private final String URL = "https://api.tourease.my.id/v1/mobile/auth/resend-otp";

    @Step
    public String IsetResendAPIEndPoint(){
        return URL;
    }

    @Step
    public void IsendPostRequestToServerWithValidEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Nausicaa9@example.com");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetResendAPIEndPoint())
                .then()
                .log().all(); ;

    }

    @Step
    public void IsendPostRequestToServerWithInvalidEmailFormat(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Nausicaa9example.com");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetResendAPIEndPoint())
                .then()
                .log().all(); ;

    }

    @Step
    public void IsendPostRequestToServerWithAnUnRegisteredEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Unregistered9@example.com");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetResendAPIEndPoint())
                .then()
                .log().all(); ;

    }


    @Step
    public void CheckThatIReceiveReferenceid(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.RESEND_OTP_VALID_EMAIL_SCHEMA);
        restAssuredThat(response ->  response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.reference_id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }

    @Step
    public void CheckThatIdontReceiveReferenceid(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.RESEND_OTP_INVALID_EMAIL_SCHEMA);
        restAssuredThat(response ->  response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }


}

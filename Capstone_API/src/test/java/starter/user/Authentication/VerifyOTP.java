package starter.user.Authentication;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class VerifyOTP {
    private final String URL = "https://api.tourease.my.id/v1/mobile/auth/resend-otp";

    @Step
    public String IsetVerifyAPIEndPoint(){
        return URL;
    }

    @Step
    public void IsendPostRequestToServerWithMatchReferenceIDAndOTP(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("reference_id", "WCTp17O4Uu2CZ88O");
        requestBody.put("otp", "7523");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetVerifyAPIEndPoint())
                .then()
                .log().all(); ;
    }

    @Step
    public void IreceiveAnOTPAndAMessagThatSayThatImSucceed(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.VERIFY_OTP_SCHEMA);
        restAssuredThat(response ->  response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }

    // Negative Testing

    @Step
    public void IsendPostRequestToServerWithUnmatchReferenceIDAndOTP(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("reference_id", "WCTp17O4Uu2CZ88O");
        requestBody.put("otp", "7523");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(IsetVerifyAPIEndPoint())
                .then()
                .log().all(); ;
    }

    @Step
    public void IReceiveAMessageSaysThatRefIDAndOTPUnmatch(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.VERIFY_OTP_SCHEMA);
        restAssuredThat(response ->  response.body("status", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("message", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }



}

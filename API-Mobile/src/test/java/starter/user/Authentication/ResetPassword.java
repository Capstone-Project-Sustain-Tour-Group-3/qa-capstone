package starter.user.Authentication;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JSON_Schema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ResetPassword {
    private final String URL = "https://api.tourease.my.id/v1/mobile/auth/forgot-password";

    @Step
    public String IsetOnResetPasswordAPIEndpoint(){
        return URL;
    }

    @Step
    public void IsendPOSTrequesToServerWithMatchValidReference_idAndMatchPasswordAndConfirmPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("ref_id", "gCGBw4IB8boTMG5B");
        requestBody.put("password", "password");
        requestBody.put("konfirmasi_password", "password");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(IsetOnResetPasswordAPIEndpoint())
                .then()
                .log().all(); ;
    }

    @Step
    public void IreceiveAmessageThatSayThatImSucceedAtResettingPasswordAndMyPasswordIsChanged(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String Schema = helper.getResponseSchema(JSON_Schema.RESEND_OTP_VALID_EMAIL_SCHEMA);
        restAssuredThat(response ->  response.body("ref_id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("password", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("konfirmasi_password", Matchers.notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(Schema)));
    }



}

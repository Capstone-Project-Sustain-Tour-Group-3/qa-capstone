package starter.stepdefinitions.Authentication;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.VerifyOTP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.HTTPResponses.HTTPResponse;

public class P_VerifyOTP {
    @Steps
    VerifyOTP verifyOTP;

    @Steps
    HTTPResponse httpResponse;

    @Given("I set on VerifyOTP API endpoint")
    public void i_set_on_verify_OTP_end_point(){
        verifyOTP.IsetVerifyAPIEndPoint();
    }

    @When("I send POST request to server with match reference_id and OTP")
    public void i_send_post_request_to_server_with_match_reference_id_and_OTP(){
        verifyOTP.IsendPostRequestToServerWithMatchReferenceIDAndOTP();
    }

    @Then("I receive an OTP and a message that say that i m succeed")
    public void i_receive_an_OTP_and_a_messgae_that_say_that_i_m_succed(){
        verifyOTP.IreceiveAnOTPAndAMessagThatSayThatImSucceed();
    }

    // Negative Test

    @When("I send POST request to server with unmatch reference_id and OTP")
    public void i_send_POST_request_to_server_with_unmatch_ref_id_and_OTP(){
        verifyOTP.IsendPostRequestToServerWithUnmatchReferenceIDAndOTP();
    }

    @Then("I dont receive an OTP and receive a message that say that i m succeed")
    public void i_dont_receive_an_OTP_and_receive_a_email_says_that_i_m_succeed(){
        verifyOTP.IReceiveAMessageSaysThatRefIDAndOTPUnmatch();
    }

}

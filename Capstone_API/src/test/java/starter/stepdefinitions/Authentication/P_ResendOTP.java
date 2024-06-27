package starter.stepdefinitions.Authentication;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.ResendOTP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.HTTPResponses.HTTPResponse;


public class P_ResendOTP {

    @Steps
    ResendOTP resendOTP;

    @Given("I set on ResendOTP API endpoint")
    public void i_set_on_resendOTP_API_endpoint(){
        resendOTP.IsetResendAPIEndPoint();
    }

    // Positive Test Case
    @When("I send POST request to server with valid email")
    public void i_send_POST_request_to_server_with_valid_email(){
        resendOTP.IsendPostRequestToServerWithValidEmail();
    }

    @Then("I receive the reference id and an appropriate message")
    public void i_receive_the_reference_id_and_an_appripriate_message(){
        resendOTP.CheckThatIReceiveReferenceid();
    }

    // Negative Test case

    // Wrong Email Format

    @When("I send POST request to server with invalid email format")
    public void i_send_POST_request_to_server_withResend_invalid_email_format(){
        resendOTP.IsendPostRequestToServerWithInvalidEmailFormat();
    }

    @Then("I dont receive the reference id and i receive an appropriate message")
    public void i_dont_receive_the_reference_id_and_receive_an_appropriate_message(){
        resendOTP.CheckThatIdontReceiveReferenceid();
    }

    // Unregistered Email

    @When("I send POST request to server with Unregistered Email")
    public void i_send_post_request_to_server_with_unregistered_email(){
        resendOTP.IsendPostRequestToServerWithAnUnRegisteredEmail();
    }





}

package starter.stepdefinitions.Authentication;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.ResetPassword;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.HTTPResponses.HTTPResponse;

public class P_ResetPassword {
    @Steps
    ResetPassword resetPasswordSteps;



    @Given("I set on ResetPassword OTP API endpoint")
    public void i_set_on_ResetPassword_OTP_API_endpoint() {
            resetPasswordSteps.IsetOnResetPasswordAPIEndpoint();
    }


    @When("I send POST request to server with match valid reference_id and match password and confirm password")
    public void i_send_post_request_to_server_with_match_password_and_confirmPassword() {
        resetPasswordSteps.IsendPOSTrequesToServerWithMatchValidReference_idAndMatchPasswordAndConfirmPassword();
    }

    @Then("I receive a message that say that i m succeed at resetting password and my password is changed")
    public void i_receive_a_message_that_say_that_i_m_succeed_at_resetting_password() {
        resetPasswordSteps.IreceiveAmessageThatSayThatImSucceedAtResettingPasswordAndMyPasswordIsChanged();
    }


}

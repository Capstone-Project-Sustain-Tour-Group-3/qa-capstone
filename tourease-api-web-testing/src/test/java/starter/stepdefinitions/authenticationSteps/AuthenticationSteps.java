package starter.stepdefinitions.authenticationSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.authentication.Authentication;

public class AuthenticationSteps {
    @Steps
    Authentication authentication;

    @Given("I set API endpoint for login")
    public void setLoginApiEndpoint() {
        authentication.setLoginApiEndpoint();
    }

    @When("I send a POST request with valid user credentials")
    public void sendLoginRequest() {
        authentication.sendLoginRequest();
    }

    @Then("I receive status code 200")
    public void receiveStatusCode200() {
        authentication.receiveStatusCode200();
    }

    @And("I successfully logged in to the account")
    public void successfullyLoggedIn() {
        authentication.successfullyLoggedIn();
    }

    @When("I send a POST request with invalid username")
    public void sendInvalidUsernameLoginRequest() {
        authentication.sendInvalidUsernameLoginRequest();
    }

    @Then("I receive status code 401")
    public void receiveStatusCode401() {
        authentication.receiveStatusCode401();
    }

    @And("I received a failed admin login message")
    public void unsuccessfullyLoggedIn() {
        authentication.unsuccessfullyLoggedIn();
    }

    @When("I send a POST request with invalid password")
    public void sendInvalidPasswordLoginRequest() {
        authentication.sendInvalidPasswordLoginRequest();
    }

    @Given("I set API endpoint for logout")
    public void setLogoutApiEndpoint() {
        authentication.setLogoutApiEndpoint();
    }

    @When("I send a DELETE request for logout")
    public void sendLogoutRequest() {
        authentication.sendLogoutRequest();
    }

    @And("I successfully logged out from the account")
    public void successfullyLoggedOut() {
        authentication.successfullyLoggedOut();
    }
}

package starter.stepdefinitions.ManageUserSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageUser.GetUser;

public class GetUserSteps {
    @Steps
    GetUser getUser;

    @Given("I set API endpoint for get all user detail")
    public void setGetAllUserApiEndpoint() {
        getUser.setGetAllUserApiEndpoint();
    }

    @When("I send a GET request for get all user detail")
    public void sendGetAllUserRequest() {
        getUser.sendGetAllUserRequest();
    }

    @And("I received a valid data from all user")
    public void receivedAllUserData() {
        getUser.receivedAllUserData();
    }

    @Given("I set API endpoint for get user detail by ID")
    public void setGetIDUserApiEndpoint() {
        getUser.setGetIDUserApiEndpoint();
    }

    @When("I send a GET request with valid user ID")
    public void sendGetIDUserRequest() {
        getUser.sendGetIDUserRequest();
    }

    @And("I received a valid data from selected user")
    public void receivedSelectedUserData() {
        getUser.receivedSelectedUserData();
    }

    @Given("I set API endpoint for get user detail by invalid ID")
    public void setFailedGetIDUserApiEndpoint() {
        getUser.setFailedGetIDUserApiEndpoint();
    }

    @When("I send a GET request with invalid user ID")
    public void sendFailedGetIDUserRequest() {
        getUser.sendFailedGetIDUserRequest();
    }

    @Then("I receive status code 404")
    public void receiveStatusCode404() {
        getUser.receiveStatusCode404();
    }

    @And("I received a failed get user message")
    public void receivedFailedGetUserMessage() {
        getUser.receivedFailedGetUserMessage();
    }
}

package starter.stepdefinitions.ManageUserSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageUser.AddUser;

public class AddUserSteps {
    @Steps
    AddUser addUser;

    @Given("I set API endpoint for add user data")
    public void setAddUserApiEndpoint() {
        addUser.setAddUserApiEndpoint();
    }

    @When("I send a POST request for add user data")
    public void sendAddUserRequest() {
        addUser.sendAddUserRequest();
    }

    @Then("I receive status code 201")
    public void receiveStatusCode201() {
        addUser.receiveStatusCode201();
    }

    @And("I received a valid data from new user")
    public void receivedNewUserData() {
        addUser.receivedNewUserData();
    }

    @When("I send a POST request for add user data without body data")
    public void sendInvalidAddUserRequest() {
        addUser.sendInvalidAddUserRequest();
    }

    @Then("I receive status code 400")
    public void receiveStatusCode400() {
        addUser.receiveStatusCode400();
    }

    @And("I received a failed add user message")
    public void receivedFailedAddUser() {
        addUser.receivedFailedAddUser();
    }

    @When("I send a POST request for add user data with invalid profile picture format")
    public void sendInvalidAddUserProfileRequest() {
        addUser.sendInvalidAddUserProfileRequest();
    }

    @When("I send a POST request for add user data with an already registered username")
    public void sendAddRegisteredUsernameRequest() {
        addUser.sendAddRegisteredUsernameRequest();
    }

    @Then("I receive status code 409")
    public void receiveStatusCode409() {
        addUser.receiveStatusCode409();
    }

    @And("I received a failed username or email already in use message")
    public void receivedFailedNewUserData() {
        addUser.receivedFailedNewUserData();
    }

    @When("I send a POST request for add user data with an already registered email")
    public void sendAddRegisteredEmailRequest() {
        addUser.sendAddRegisteredEmailRequest();
    }
}

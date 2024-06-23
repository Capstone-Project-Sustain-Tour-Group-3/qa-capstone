package starter.stepdefinitions.ManageUserSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageUser.DeleteUser;

public class DeleteUserSteps {
    @Steps
    DeleteUser deleteUser;

    @Given("I set API endpoint for delete user data")
    public void setDeleteUserApiEndpoint() {
        deleteUser.setDeleteUserApiEndpoint();
    }

    @When("I send a DELETE request for delete user data")
    public void sendDeleteUserRequest() {
        deleteUser.sendDeleteUserRequest();
    }

    @And("I received a success delete user message")
    public void receivedSuccessDeleteUserMessage() {
        deleteUser.receivedSuccessDeleteUserMessage();
    }

    @Given("I set API endpoint for delete user data with invalid ID")
    public void setInvalidDeleteUserApiEndpoint() {
        deleteUser.setInvalidDeleteUserApiEndpoint();
    }

    @When("I send a DELETE request with invalid user ID")
    public void sendInvalidDeleteUserRequest() {
        deleteUser.sendInvalidDeleteUserRequest();
    }
}

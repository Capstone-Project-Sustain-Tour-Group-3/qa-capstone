package starter.stepdefinitions.ManageUserSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageUser.EditUser;

public class EditUserSteps {
    @Steps
    EditUser editUser;

    @Given("I set API endpoint for edit user data")
    public void setEditUserApiEndpoint() {
        editUser.setEditUserApiEndpoint();
    }

    @When("I send a PUT request for edit user data")
    public void sendEditUserRequest() {
        editUser.sendEditUserRequest();
    }

    @And("I received a success edit message")
    public void receivedSuccessEdit() {
        editUser.receivedSuccessEdit();
    }

    @When("I send a PUT request for edit user data without body data")
    public void sendInvalidEditUserRequest() {
        editUser.sendInvalidEditUserRequest();
    }

    @And("I received a failed edit user message")
    public void receivedFailedEdit() {
        editUser.receivedFailedEdit();
    }

    @When("I send a PUT request for edit user data with invalid profile picture format")
    public void sendInvalidEditUserProfileRequest() {
        editUser.sendInvalidEditUserProfileRequest();
    }

    @When("I send a PUT request for edit user data with an already registered username")
    public void sendEditRegisteredUsernameRequest() {
        editUser.sendEditRegisteredUsernameRequest();
    }

    @When("I send a PUT request for edit user data with an already registered email")
    public void sendEditRegisteredEmailRequest() {
        editUser.sendEditRegisteredEmailRequest();
    }

    @Given("I set API endpoint for edit user detail by invalid ID")
    public void setFailedEditIDUserApiEndpoint() {
        editUser.setFailedEditIDUserApiEndpoint();
    }

    @When("I send a PUT request with invalid user ID")
    public void sendFailedEditIDUserRequest() {
        editUser.sendFailedEditIDUserRequest();
    }

    @And("I received an account not found message")
    public void receivedFailedEditUserMessage() {
        editUser.receivedFailedEditUserMessage();
    }
}

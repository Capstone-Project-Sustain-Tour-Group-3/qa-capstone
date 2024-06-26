package starter.stepdefinitions.ManageAdminSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageAdmin.GetAdmin;

public class GetAdminSteps {
    @Steps
    GetAdmin getAdmin;

    @Given("I set API endpoint for get all admin detail")
    public void setGetAllAdminApiEndpoint() {
        getAdmin.setGetAllAdminApiEndpoint();
    }

    @When("I send a GET request for get all admin detail")
    public void sendGetAllAdminRequest() {
        getAdmin.sendGetAllAdminRequest();
    }

    @And("I received a valid data from all admin")
    public void receivedAllAdminData() {
        getAdmin.receivedAllAdminData();
    }

    @Given("I set API endpoint for get admin detail by ID")
    public void setGetIDAdminApiEndpoint() {
        getAdmin.setGetIDAdminApiEndpoint();
    }

    @When("I send a GET request with valid admin ID")
    public void sendGetIDAdminRequest() {
        getAdmin.sendGetIDAdminRequest();
    }

    @And("I received a valid data from selected admin")
    public void receivedSelectedUserData() {
        getAdmin.receivedSelectedUserData();
    }

    @Given("I set API endpoint for get admin detail by invalid ID")
    public void setFailedGetIDAdminApiEndpoint() {
        getAdmin.setFailedGetIDAdminApiEndpoint();
    }

    @When("I send a GET request with invalid admin ID")
    public void sendFailedGetIDAdminRequest() {
        getAdmin.sendFailedGetIDAdminRequest();
    }

    @And("I received a failed get admin message")
    public void receivedFailedGetAdminMessage() {
        getAdmin.receivedFailedGetAdminMessage();
    }
}

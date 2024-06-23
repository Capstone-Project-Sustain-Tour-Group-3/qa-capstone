package starter.stepdefinitions.ManageRouteSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageRoute.DeleteRoute;

public class DeleteRouteSteps {
    @Steps
    DeleteRoute deleteRoute;

    @Given("I set API endpoint for delete route")
    public void setDeleteRouteApiEndpoint() {
        deleteRoute.setDeleteRouteApiEndpoint();
    }

    @When("I send a DELETE request for delete route")
    public void sendDeleteRouteRequest() {
        deleteRoute.sendDeleteRouteRequest();
    }

    @And("I received a success delete route message")
    public void receivedSuccessDeleteRouteMessage() {
        deleteRoute.receivedSuccessDeleteRouteMessage();
    }

    @Given("I set API endpoint for delete route with invalid ID")
    public void setInvalidDeleteUserApiEndpoint() {
        deleteRoute.setInvalidDeleteUserApiEndpoint();
    }

    @When("I send a DELETE request with invalid route ID")
    public void sendInvalidDeleteRouteRequest() {
        deleteRoute.sendInvalidDeleteRouteRequest();
    }

    @And("I received a route not found message")
    public void receivedFailedDeleteRouteMessage() {
        deleteRoute.receivedFailedDeleteRouteMessage();
    }
}

package starter.stepdefinitions.ManageRouteSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageRoute.GetRoute;

public class GetRouteSteps {
    @Steps
    GetRoute getRoute;

    @Given("I set API endpoint for get all route")
    public void setGetAllRouteApiEndpoint() {
        getRoute.setGetAllRouteApiEndpoint();
    }

    @When("I send a GET request for get all route")
    public void sendGetAllRouteRequest() {
        getRoute.sendGetAllRouteRequest();
    }

    @And("I received a valid data from all route")
    public void receivedAllRouteData() {
        getRoute.receivedAllRouteData();
    }

    @Given("I set API endpoint for get user route by ID")
    public void setGetIDRouteApiEndpoint() {
        getRoute.setGetIDRouteApiEndpoint();
    }

    @When("I send a GET request with valid route ID")
    public void sendGetIDRouteRequest() {
        getRoute.sendGetIDRouteRequest();
    }

    @And("I received a valid data from selected route")
    public void receivedSelectedRouteData() {
        getRoute.receivedSelectedRouteData();
    }

    @Given("I set API endpoint for get route by invalid ID")
    public void setFailedGetIDRouteApiEndpoint() {
        getRoute.setFailedGetIDRouteApiEndpoint();
    }

    @When("I send a GET request with invalid route ID")
    public void sendFailedGetIDRouteRequest() {
        getRoute.sendFailedGetIDRouteRequest();
    }

    @And("I received a failed get route message")
    public void receivedFailedGetRouteMessage() {
        getRoute.receivedFailedGetRouteMessage();
    }
}

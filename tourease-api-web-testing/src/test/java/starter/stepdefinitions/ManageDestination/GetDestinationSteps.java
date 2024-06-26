package starter.stepdefinitions.ManageDestination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageDestination.GetDestination;

public class GetDestinationSteps {
    @Steps
    GetDestination getDestination;

    @Given("I set API endpoint for get all destination")
    public void setGetAllDestinationApiEndpoint() {
        getDestination.setGetAllDestinationApiEndpoint();
    }

    @When("I send a GET request for get all destination")
    public void sendGetAllDestinationRequest() {
        getDestination.sendGetAllDestinationRequest();
    }

    @And("I received a valid data from all destination")
    public void receivedAllDestinationData() {
        getDestination.receivedAllDestinationData();
    }

    @Given("I set API endpoint for get destination by ID")
    public void setGetIDDestinationApiEndpoint() {
        getDestination.setGetIDDestinationApiEndpoint();
    }

    @When("I send a GET request with valid destination ID")
    public void sendGetIDDestinationRequest() {
        getDestination.sendGetIDDestinationRequest();
    }

    @And("I received a valid data from selected destination")
    public void receivedSelectedDestinationData() {
        getDestination.receivedSelectedDestinationData();
    }

    @Given("I set API endpoint for get destination by invalid ID")
    public void setFailedGetIDDestinationApiEndpoint() {
        getDestination.setFailedGetIDDestinationApiEndpoint();
    }

    @When("I send a GET request with invalid destination ID")
    public void sendFailedGetIDDestinationRequest() {
        getDestination.sendFailedGetIDDestinationRequest();
    }

    @And("I received a failed get destination message")
    public void receivedFailedGetDestinationMessage() {
        getDestination.receivedFailedGetDestinationMessage();
    }
}

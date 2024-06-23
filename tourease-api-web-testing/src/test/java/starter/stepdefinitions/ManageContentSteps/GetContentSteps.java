package starter.stepdefinitions.ManageContentSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageContent.GetContent;

public class GetContentSteps {
    @Steps
    GetContent getContent;

    @Given("I set API endpoint for get all content")
    public void setGetAllContentApiEndpoint() {
        getContent.setGetAllContentApiEndpoint();
    }

    @When("I send a GET request for get all content")
    public void sendGetAllContentRequest() {
        getContent.sendGetAllContentRequest();
    }

    @And("I received a valid data from all content")
    public void receivedAllContent() {
        getContent.receivedAllContent();
    }

    @Given("I set API endpoint for get content by ID")
    public void setGetIDContentApiEndpoint() {
        getContent.setGetIDContentApiEndpoint();
    }

    @When("I send a GET request with valid content ID")
    public void sendGetIDContentRequest() {
        getContent.sendGetIDContentRequest();
    }

    @And("I received a valid data from selected content")
    public void receivedSelectedContent() {
        getContent.receivedSelectedContent();
    }

    @Given("I set API endpoint for get content by invalid ID")
    public void setFailedGetIDContentApiEndpoint() {
        getContent.setFailedGetIDContentApiEndpoint();
    }

    @When("I send a GET request with invalid content ID")
    public void sendFailedGetIDContentRequest() {
        getContent.sendFailedGetIDContentRequest();
    }

    @And("I received a failed get content message")
    public void receivedFailedGetContentMessage() {
        getContent.receivedFailedGetContentMessage();
    }
}

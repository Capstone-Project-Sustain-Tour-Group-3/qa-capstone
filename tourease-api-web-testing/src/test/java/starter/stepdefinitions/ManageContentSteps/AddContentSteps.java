package starter.stepdefinitions.ManageContentSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageContent.AddContent;

public class AddContentSteps {
    @Steps
    AddContent addContent;

    @Given("I set API endpoint for add content")
    public void setAddContentApiEndpoint() {
        addContent.setAddContentApiEndpoint();
    }

    @When("I send a POST request for add content")
    public void sendAddContentRequest() {
        addContent.sendAddContentRequest();
    }

    @And("I received a valid data from new content")
    public void receivedNewContentData() {
        addContent.receivedNewContentData();
    }

    @When("I send a POST request for add content without body data")
    public void sendInvalidAddContentRequest() {
        addContent.sendInvalidAddContentRequest();
    }

    @And("I received a failed add content message")
    public void receivedFailedAddContent() {
        addContent.receivedFailedAddContent();
    }

    @When("I send a POST request for add content with invalid url format")
    public void sendInvalidAddContentUrlRequest() {
        addContent.sendInvalidAddContentUrlRequest();
    }
}

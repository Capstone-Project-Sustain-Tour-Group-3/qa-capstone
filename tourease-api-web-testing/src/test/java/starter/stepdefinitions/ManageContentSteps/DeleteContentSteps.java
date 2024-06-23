package starter.stepdefinitions.ManageContentSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageContent.DeleteContent;

public class DeleteContentSteps {
    @Steps
    DeleteContent deleteContent;

    @Given("I set API endpoint for delete content")
    public void setDeleteContentApiEndpoint() {
        deleteContent.setDeleteContentApiEndpoint();
    }

    @When("I send a DELETE request for delete content")
    public void sendDeleteContentRequest() {
        deleteContent.sendDeleteContentRequest();
    }

    @And("I received a success delete content message")
    public void receivedSuccessDeleteContentMessage() {
        deleteContent.receivedSuccessDeleteContentMessage();
    }

    @Given("I set API endpoint for delete content with invalid ID")
    public void setInvalidDeleteContentApiEndpoint() {
        deleteContent.setInvalidDeleteContentApiEndpoint();
    }

    @When("I send a DELETE request with invalid content ID")
    public void sendInvalidDeleteContentRequest() {
        deleteContent.sendInvalidDeleteContentRequest();
    }
}

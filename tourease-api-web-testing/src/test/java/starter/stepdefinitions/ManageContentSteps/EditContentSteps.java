package starter.stepdefinitions.ManageContentSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.admin.ManageContent.EditContent;

public class EditContentSteps {
    @Steps
    EditContent editContent;

    @Given("I set API endpoint for edit content")
    public void setEditContentApiEndpoint() {
        editContent.setEditContentApiEndpoint();
    }

    @When("I send a PUT request for edit content")
    public void sendEditContentRequest() {
        editContent.sendEditContentRequest();
    }

    @When("I send a PUT request for edit content without body data")
    public void sendInvalidEditContentRequest() {
        editContent.sendInvalidEditContentRequest();
    }

    @And("I received a failed edit content message")
    public void receivedFailedEditContent() {
        editContent.receivedFailedEditContent();
    }

    @When("I send a PUT request for edit content with invalid url format")
    public void sendFailedEditContentUrlRequest() {
        editContent.sendFailedEditContentUrlRequest();
    }

    @Given("I set API endpoint for edit content by invalid ID")
    public void setFailedEditIDContentApiEndpoint() {
        editContent.setFailedEditIDContentApiEndpoint();
    }

    @When("I send a PUT request with invalid content ID")
    public void sendFailedEditIDContentRequest() {
        editContent.sendFailedEditIDContentRequest();
    }

    @And("I received a content not found message")
    public void receivedFailedEditContentMessage() {
        editContent.receivedFailedEditContentMessage();
    }
}

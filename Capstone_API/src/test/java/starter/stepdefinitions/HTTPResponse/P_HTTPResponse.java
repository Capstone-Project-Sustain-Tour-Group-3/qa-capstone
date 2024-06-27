package starter.stepdefinitions.HTTPResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Login;
import starter.user.HTTPResponses.HTTPResponse;
public class P_HTTPResponse {

    @Steps
    HTTPResponse httpResponse;;


    @Then("I receive status code 400")
    public void i_receive_status_code_400() {
        httpResponse.ReceiveResponse400();
    }

    @Then("I receive status code 409")
    public void i_receive_status_code_409() {
        httpResponse.ReceiveResponse409();
    }

    @Then("I receive status code 201")
    public void i_receive_status_code_201() {
        httpResponse.ReceiveResponse201();
    }

    @Then("I receive status code 200")
    public void i_receive_status_code_200() {
        httpResponse.ReceiveResponse200();
    }
}





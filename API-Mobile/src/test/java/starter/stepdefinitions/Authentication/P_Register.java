    package starter.stepdefinitions.Authentication;
    import net.serenitybdd.annotations.Steps;
    import starter.user.Authentication.Register;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import starter.user.HTTPResponses.HTTPResponse;


    public class P_Register {
        @Steps
        Register register;

        // Positive Test Case
        @Given("I set on the register endpoint")
        public void ISetOnTheRegisterEndpoint() {
            register.ISendToServerRegisterPostWithValidInput();
        }

        @When("I send valid email and valid input and valid input")
        public void ISendValidEmailAndValidInputAndValidFullname() {
            register.ISendToServerRegisterPostWithValidInput();
        }
        @Then("Check that I receive appropriate data for valid register request")
        public void IReceiveAppropriateDataForValidRegisterRequest() {
            register.CheckThatIGetAppropriateResponseForValidRegisterRequest();
        }
        // Negative Test Case

        @Given("I send valid with valid input but the email has conflict")
        public void ISendValidWithValidInputButTheEmailHasConflict() {
            register.ISendToServerRegisterPostWithConflictEmail();
        }

        @Then("My account is not registered")
        public void MyAccountIsNotRegistered() {
            register.CheckThatIGetAppropriateResponseForConflictRegisterRequest();
        }

        @Given("I send valid with valid input but the username has conflict")
        public void ISendValidWithValidInputButTheUsernameHasConflict(){
            register.ISendToServerRegisterPostWithConflictUsername();
        }

        @When("I send valid with valid with wrong email format")
        public void ISendValidWithValidWithWrongEmailFormat() {
            register.ISendToServerRegisterPostWithWrongEmailFormat();
        }
    }





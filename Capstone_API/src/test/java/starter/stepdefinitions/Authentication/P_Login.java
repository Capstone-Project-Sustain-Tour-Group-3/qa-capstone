//package starter.stepdefinitions.Authentication;
//import net.serenitybdd.annotations.Steps;
//import starter.user.Authentication.Login;
//import starter.user.Authentication.Register;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import starter.user.HTTPResponses.HTTPResponse;
//
//
//public class P_Login {
//    @Steps
//    Login login;
//
//    @Steps
//    HTTPResponse httpResponse;
//    @Steps
//    Register register;
//
//    @Given("I set on the Login endpoint")
//    public void ISetOnTheLoginEndpoint() {
//        login.IsetOnTheLoginPoint();
//    }
//    @When("I send valid email and valid input")
//    public void ISendValidEmailAndValidInput() {
//        login.ISendToServerLoginPostWithValidPassword();
//    }
//
//
//    @Then("My account is Logged")
//    public void MyAccountIsLogged() {
//        login.CheckThatMyLoginSuccedSoIgetAuthenticationCode();
//    }
//
//}
//
//
//
//

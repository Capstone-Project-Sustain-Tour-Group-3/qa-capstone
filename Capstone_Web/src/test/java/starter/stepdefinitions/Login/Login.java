package starter.stepdefinitions.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.LoginPage.LoginPage;
import starter.pages.MainPage.MainPage;

public class Login {

    @Steps
    LoginPage login;

    @Steps
    MainPage mainPage;

    @Given("I am on the login page")
    public void givenIAmOnTheLoginPage() {
        login.openUrl("https://capstone-theta-tan.vercel.app/");
        Assertions.assertTrue(login.verifyThatImOnLoginPage());
    }

    @When("I enter a valid username")
    public void whenIEnterTheUsername() {
        login.writeUsername("superadmin");
    }

    @And("I enter a valid password")
    public void whenIEnterThePassword() {
        login.writePassword("SAtourease123");
    }

    @And("I click the enter button")
    public void whenIClickTheEnterButton() {
        login.clickEnterButton();
    }

    @Then("I should see the homepage")
    public void thenIShouldSeeTheHomepage() {
        Assertions.assertTrue(mainPage.verifyThatImOnHomePage());
    }

    // NEGATIVE TESTING

    @When("I enter a wrong username")
    public void whenIEnterAWrongUsername() {
        login.writeUsername("Almaya");
    }

    @Then("I should not see the homepage")
    public void thenIShouldNotSeeTheHomepage() {
        Assertions.assertTrue(login.verifyThatImOnLoginPage());
    }

    @And("I enter a wrong password")
    public void whenIEnterAWrongPassword() {
        login.writePassword("Yitgadal");
    }
}

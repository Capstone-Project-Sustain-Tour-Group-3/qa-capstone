package starter.stepdefinitions.Route;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.pages.RoutePage.DetailRoutePage;
import starter.pages.MainPage.MainPage;
import starter.pages.LoginPage.LoginPage;
import starter.pages.RoutePage.RoutePage
        ;

public class ManageDetailRoute {
    @Steps
    LoginPage login;

    @Steps
    MainPage mainPage;

    @Steps
    DetailRoutePage detailRoutePage;

    @Steps
    RoutePage routePage;

    @When("I click Manage detail route Page button")
    public void goToManageDetailPage() {
        mainPage.clickManageRouteButton();
    }

    @And("I click detail route button")
    public void userDetailPage() {
        routePage.clickDetailRoutepage();
    }

    @When("I click wrong Manage detail route Page button")
    public void ClickWrongDetailPage() {
        mainPage.clickManageRouteButton();
    }

    @Then("I should see the homepage detail route")
    public void VerifyhatIamOnDetailRougePage() {
        detailRoutePage.VerifyhatIamOnDetailRougePage();
    }






}

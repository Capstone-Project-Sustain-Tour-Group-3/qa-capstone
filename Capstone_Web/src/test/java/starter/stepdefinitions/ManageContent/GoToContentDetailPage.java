package starter.stepdefinitions.ManageContent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.MainPage.MainPage;
import starter.pages.ManageContent.ContentDetailPage;
import starter.pages.ManageContent.ManageContentPage;

public class GoToContentDetailPage {
    MainPage mainPage;
    ManageContentPage manageContentPage;
    ContentDetailPage contentDetailPage;

    @And("I click Manage Content Page button")
    public void iClickManageContentPageButton() {
        mainPage.ClickContentPageButtonPath();
    }

    @And("I click content detail button")
    public void iClickContentDetailButton() {
        manageContentPage.clickContentDetailPage();
    }

    @Then("I should see the content detail page")
    public void iShouldSeeTheContentDetailPage() {
        contentDetailPage.verifyContentDetailPage();
    }

    // Negative Testing

    @And("I click wrong content detail page")
    public void iClickWrongContentDetailPage() {
        mainPage.ClickContentPageButtonPath();
    }

    @Then("I should not see content detail page")
    public void iShouldNotSeeContentDetailPage() {
        mainPage.verifyThatImOnHomePage();
    }
}

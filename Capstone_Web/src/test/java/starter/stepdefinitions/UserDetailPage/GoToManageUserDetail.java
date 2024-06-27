package starter.stepdefinitions.UserDetailPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.pages.MainPage.MainPage;
import starter.pages.UserDetailPage.ManageUserPage;
import starter.pages.UserDetailPage.UserDetailPage;


public class GoToManageUserDetail {
    @Steps
    MainPage mainPage;
    @Steps
    ManageUserPage manageUserPage;
    @Steps
    UserDetailPage userDetailPage;

    @And("I click Manage User detail Page button")
    public void iClickManageUserDetailPageButton() {
        mainPage.clickManageUserDetailButton();
    }

    @And("I click user detail button")
    public void goToUserDetailPage() {
         manageUserPage.clickUserDetailButton();
    }

    @Then("I should see the homepage user detail")
    public void iShouldSeeTheHomepageUserDetail() {
        userDetailPage.verifyUserDetailPage();
    }

    @And("I click wrong user detail button")
    public void iClickWrongUserDetailButton() {
        mainPage.clickManageUserDetailButton();
    }

    @Then("I should not see the user detail")
    public void iShouldNotSeeTheHomepageUserDetail() {
        mainPage.verifyThatImOnHomePage();
    }

    @Then("I should not see the homepage detail route")
    public void iShouldNotSeeTheHomepageDetailRoute() {
        mainPage.verifyThatImOnHomePage();
    }






}

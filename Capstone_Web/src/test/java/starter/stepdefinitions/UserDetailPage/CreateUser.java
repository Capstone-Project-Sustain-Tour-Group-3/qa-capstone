package starter.stepdefinitions.UserDetailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import starter.pages.MainPage.MainPage;
import starter.pages.UserDetailPage.CreateUserPage;
import starter.pages.UserDetailPage.DeletePopUp;
import starter.pages.UserDetailPage.ManageUserPage;
import starter.pages.UserDetailPage.UserDetailPage;

public class CreateUser {
    ManageUserPage manageUserPage;

    CreateUserPage createUserPage;

    @And("I click create Button")
    public void iClickCreateButton() {
        manageUserPage.ManageUserPage_clickCreateUserButton();
    }

    @And("I write valid male input")
    public void iWriteValidMaleInput() {
        createUserPage.CreateUserWithValidInput("Wladek","Wladek Szpilman","paijo@mail.com", "hahaha12345", "082231300679","Banyuurip","Madura");
    }

}

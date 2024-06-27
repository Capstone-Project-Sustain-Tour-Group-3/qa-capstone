package starter.pages.UserDetailPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;

public class ManageUserPage extends PageObject {
    // Halaman 
    private By ManageUserPageId() {
        return By.id("root");
    }

    @Step
    public boolean verifyManageUserPage() {
        return $(ManageUserPageId()).isDisplayed();
    }


    // Tombol User Detail
    private By UserDetailButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[3]");
    }

    @Step
    public void clickUserDetailButton() {
        $(UserDetailButton()).click();
    }


    // Edit Button
    private By ManageUserPage_EditButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[1]/img");
    }

    @Step
    public void ManageUserPage_clickEditButton() {
        $(ManageUserPage_EditButton()).click();
    }

    // Delete Button

    private By ManageUserPage_DeleteButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[2]/svg");
    }

    @Step
    public void ManageUserPage_clickDeleteButton() {
        $(ManageUserPage_DeleteButton()).click();
    }

    // Create User Button

    public By ManageUserPage_CreateUserButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[1]/div/a");
    }

    @Step
    public void ManageUserPage_clickCreateUserButton() {
        $(ManageUserPage_CreateUserButton()).click();
    }


    //  Scrollbar

    private By ManageUseraPage_Scrollbar() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[1]/div/div/input");
    }

    @Step
    public void ManageUserPage_clickScrollbar() {
        $(ManageUseraPage_Scrollbar()).click();
    }


}

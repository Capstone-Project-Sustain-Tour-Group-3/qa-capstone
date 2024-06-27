package starter.pages.Manage_Admin;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;



public class ManageAdminPage extends PageObject{
    // Halaman
    private By ManageAdminPageId(){
        return By.id("root");
    }

    @Step
    public boolean verifyManageAdminPage(){
        return $(ManageAdminPageId()).isDisplayed();
    }


    // Tombol Content Detail
    private By AdminDetailButton(){
        return By.id("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[3]");
    }

    @Step
    public void AdminDeteail_ClickButton(){
        $(AdminDetailButton()).click();
    }


    // Edit Button
    private By ManageAdmin_EditButton(){
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[2]/svg");
    }

    @Step
    public void ManageAdmin_clickEditButton(){
        $(ManageAdmin_EditButton()).click();
    }
    // Delete Button

    private By ManageAdmin_DeleteButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[2]/svg");
    }

    @Step
    public void ManageAdmin_clickDeleteButton(){
        $(ManageAdmin_DeleteButton()).click();
    }

    // Create User Button

    private By ManageAdmin_CreateUserButton(){
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[3]");
    }

    @Step
    public void ManageAdmin_clickCreateUserButton(){
        $(ManageAdmin_CreateUserButton()).click();
    }


    //  Scrollbar

    private By ManageAdmin_Scrollbar(){
        return By.xpath("//*[@id=\"root\"]/div/main/main/div/div[1]/div[1]/div/div/input");
    }

    @Step
    public void ManageAdmin_clickScrollbar(){
        $(ManageAdmin_Scrollbar()).click();
    }
}
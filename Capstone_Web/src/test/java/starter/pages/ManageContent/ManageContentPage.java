package starter.pages.ManageContent;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ManageContentPage extends PageObject {


    // Halaman
    private By ManageContentPageId() {
        return By.id("root");
    }

    @Step
    public boolean verifyManageContentPage() {
        return $(ManageContentPageId()).isDisplayed();
    }


    // Tombol Content Detail
    private By ContentDetailButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/main/div/div[2]/div[1]/table/tbody/tr[2]/td[2]");
    }

    @Step
    public void clickContentDetailPage() {
        $(ContentDetailButton()).click();
    }


    // Edit Button
    private By ContentPage_EditButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[2]/svg");
    }

    @Step
    public void ContentPage_clickEditButton() {
        $(ContentPage_EditButton()).click();
    }
    // Delete Button

    private By ContentPage_DeleteButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[2]/svg");
    }

    @Step
    public void ContentPage_clickDeleteButton() {
        $(ContentPage_DeleteButton()).click();
    }

    // Create User Button

    public By ContentPage_CreateUserButton() {
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[3]");
    }

    @Step
    public void ContentPage_clickCreateUserButton() {
        $(ContentPage_CreateUserButton()).click();
    }


    //  Scrollbar

    private By ContentaPage_Scrollbar() {
        return By.xpath("//*[@id=\"root\"]/div/main/main/div/div[1]/div[1]/div/div/input");
    }

    @Step
    public void ContentPage_clickScrollbar() {
        $(ContentaPage_Scrollbar()).click();
    }





}

package starter.pages.MainPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class MainPage extends PageObject {

    private By HomePageId() {
        return By.id("root");
    }

    private By ManageUserDetailButtonPath() {
        return By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/div/a[2]");
    }

    private By ManageRouteButtonPath() {
        return By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/div/a[3]");
    }


    @Step
    public boolean verifyThatImOnHomePage() {
        return $(HomePageId()).isDisplayed(); // Ensure this step checks for an element present on the homepage
    }

    //==================================================================================================================
    //                                             MENAGE USER DETAIL
    //==================================================================================================================
    @Step public void clickManageUserDetailButton(){
        $(ManageUserDetailButtonPath()).click();
    }

    @Step public void clickManageRouteButton(){
        $(ManageRouteButtonPath()).click();
    }

    // Content Page Button
    private By ContentPageButtonPath(){
        return By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/div/a[4]");
    }

    @Step public void ClickContentPageButtonPath(){
        $(ContentPageButtonPath()).click();
    }


}


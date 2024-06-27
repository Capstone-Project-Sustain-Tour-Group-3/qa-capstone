package starter.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By loginPageId() {
        return By.id("clip0_494_651");
    }

    private By usernameInput() {
        return By.xpath("//*[@id=\":r0:-form-item\"]/input");
    }

    private By passwordInput() {
        return By.xpath("//*[@id=\":r1:-form-item\"]/input");
    }

    private By enterButton() {
        return By.xpath("//*[@id=\"root\"]/div/div[1]/div/form/button");
    }

    private By homePageId() {
        return By.id("some_homepage_element_id"); // Replace with an actual element on the homepage
    }

    @Step
    public boolean verifyThatImOnLoginPage() {
        return $(loginPageId()).isDisplayed();
    }

    @Step
    public void writeUsername(String Username) {
        $(usernameInput()).type(Username);
    }

    @Step
    public void writePassword(String Password) {
        $(passwordInput()).type(Password);
    }

    @Step
    public void clickEnterButton() {
        $(enterButton()).click();
    }

    // Negative Test
    @Step
    private By LoginPageWrongInputMessage(){
        return By.xpath("//div[@class='group-[.toast]:text-muted-foreground']");
    }

    @Step
    public void CheckThatErrorNotificatioNDisplayed() {

    }

}


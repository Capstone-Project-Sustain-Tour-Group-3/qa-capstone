package starter.pages.UserDetailPage;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class UserDetailPage extends PageObject {
    // User Detail Page
    private By UserDetail(){
        return By.id("email");
    }

    public boolean verifyUserDetailPage(){
        return $(UserDetail()).isDisplayed();
    }


}

package starter.pages.RoutePage;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class DetailRoutePage extends PageObject{
    private By DetailRoutepageId(){
        return By.id("kota");
    }

    public boolean VerifyhatIamOnDetailRougePage(){
        return $(DetailRoutepageId()).isDisplayed();
    }

}

package starter.pages.ManageContent;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ContentDetailPage extends PageObject {
    private By ContentDetailPageId(){
        return By.id("destinationName");
    }

    public boolean verifyContentDetailPage(){
        return $(ContentDetailPageId()).isDisplayed();
    }
}

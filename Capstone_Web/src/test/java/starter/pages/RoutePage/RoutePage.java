package starter.pages.RoutePage;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class RoutePage extends PageObject {
    private By DetailRoutepageId(){
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/div/table/tbody/tr[1]/td[3]");
    }

    public void clickDetailRoutepage(){
        $(DetailRoutepageId()).click();
    }

    //==================================================================================================================
    //==================================================================================================================


}

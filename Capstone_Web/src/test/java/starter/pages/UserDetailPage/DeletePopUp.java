package starter.pages.UserDetailPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;


public class DeletePopUp extends PageObject {

    // Hapus Button
    private By HapusButtonId(){
        return By.xpath("//*[@id=\"root\"]/div/main/div/div[2]/div/table/tbody/tr[1]/td[8]/div/button[2]/svg/g");
    }

    @Step
    public void ClickHapusButton(){
        $(HapusButtonId()).click();
    }
    // Back button
}

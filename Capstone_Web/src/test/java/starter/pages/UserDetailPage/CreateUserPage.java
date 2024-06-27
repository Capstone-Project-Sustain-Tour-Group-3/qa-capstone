package starter.pages.UserDetailPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.By;

public class CreateUserPage extends PageObject{


    // Username
   private By UsernameId(){
       return By.xpath("//*[@id=\"username\"]");
   }
    // Nama Lengkap
    private By NamaLengkapId(){
        return By.xpath("//*[@id=\"nama_lengkap\"]");
    }

    // Email
    private By emailId(){
        return By.xpath("//*[@id=\"email\"]");
    }

    // Password
    private By PasswordId(){
        return By.xpath("//*[@id=\"password\"]");
    }

    // Nomor Telepon
    private By TeleponId(){
        return By.id("//*[@id=\"no_telepon\"]");
    }

    // Kota/Kabupaten

    private By KotaId(){
        return By.xpath("//*[@id=\"kota\"]");
    }

    // Provinsi

    private By ProvinsiId(){
        return By.xpath("//*[@id=\"provinsi\"]");
    }

    // Centang Male/Female

    // Male
    private By MaleId(){
       return By.xpath("//*[@id=\"male\"]/span/svg/circle");
    }
    // Female
    private By FemaleId(){
        return By.xpath("//*[@id=\"female\"]");
    }

    @Step
    public void CreateUserWithValidInput(String Name, String Nama_Lengkap, String email, String password, String no_telp, String Kota, String provinsi){
       $(UsernameId()).sendKeys(Nama_Lengkap);
       $(NamaLengkapId()).type(Name);
       $(emailId()).type(email);
       $(PasswordId()).type(password);
       $(TeleponId()).type(no_telp);
       $(KotaId()).type(Kota);
       $(ProvinsiId()).type(provinsi);
       $(MaleId()).click();
    }


}

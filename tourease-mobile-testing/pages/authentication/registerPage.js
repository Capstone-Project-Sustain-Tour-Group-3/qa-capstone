import BasePage from "../basePage.js";
//import { getVerificationCodeFromEmail } from "../emailHelper.js";

export default class RegisterPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getRegisterTitle() {
        const registerTitleComponent = await this.find(
            '//android.view.View[@content-desc="Buat akun baru"]'
        );

        const registerTitle = await registerTitleComponent.getAttribute("content-desc");
        return registerTitle;
    }

    async insertUsername(username) {
        const usernameContentElement =
          '//android.widget.EditText[1]';
    
        await this.click(usernameContentElement);
    
        await this.type(usernameContentElement, username);
    }

    async insertFullname(fullname) {
        const fullnameContentElement =
          '//android.widget.EditText[2]';
        
        await this.click(fullnameContentElement);
    
        await this.type(fullnameContentElement, fullname);
    }

    async insertEmail(email) {
        const emailContentElement =
          '//android.widget.EditText[3]';
    
        await this.click(emailContentElement);
    
        await this.type(emailContentElement, email);
    }

    async insertNumber(number) {
        const numberContentElement =
          '//android.widget.EditText[4]';
    
        await this.click(numberContentElement);
    
        await this.type(numberContentElement, number);
    }

    async insertPassword(password) {
        const passwordContentElement =
          '//android.widget.EditText[5]';
    
        await this.click(passwordContentElement);
    
        await this.type(passwordContentElement, password);
    }

    async checkSnK() {
        await this.click('//android.widget.CheckBox');
    }

    async clickDaftarAkunButton() {
        await this.click('//android.widget.Button[@content-desc="Daftar"]');
    }

    async clickLanjutkanButton() {
        await this.click('//android.widget.Button[@content-desc="Lanjutkan"]');
    }

    async clickKirimButton() {
        await this.click('//android.widget.Button[@content-desc="Kirim"]');
    }

    async clickMulaiAppButton() {
        await this.click('//android.widget.Button[@content-desc="Mulai"]');
    }

    async cannotClickDaftar() {
        await this.click('//android.widget.Button[@content-desc="Daftar"]');
    }

    async getFailedRegisterTitle() {
        const failedRegisterTitleComponent = await this.find(
            '//android.view.View[@content-desc="Maaf, pembuatan akun gagal."]'
        );

        const failedRegisterTitle = await failedRegisterTitleComponent.getAttribute("content-desc");
        return failedRegisterTitle;
    }

    async insertFirstOtp(otp) {
        const firstOtpElement =
          '//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[1]';
    
        await this.click(firstOtpElement);
    
        await this.type(firstOtpElement, otp);
    }

    async insertSecondOtp(otp) {
        const secondOtpElement =
          '//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[2]';
    
        await this.click(secondOtpElement);
    
        await this.type(secondOtpElement, otp);
    }

    async insertThirdOtp(otp) {
        const thirdOtpElement =
          '//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[3]';
    
        await this.click(thirdOtpElement);
    
        await this.type(thirdOtpElement, otp);
    }

    async insertFourthOtp(otp) {
        const fourthtOtpElement =
          '//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.EditText[4]';
    
        await this.click(fourthtOtpElement);
    
        await this.type(fourthtOtpElement, otp);
    }

    async clicKirimButton() {
        await this.click('//android.widget.Button[@content-desc="Kirim"]');
    }
}
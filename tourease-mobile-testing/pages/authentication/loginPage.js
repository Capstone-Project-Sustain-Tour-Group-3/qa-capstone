import BasePage from "../basePage.js";

export default class LoginPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getLoginTitle() {
        const loginTitleComponent = await this.find(
            '//android.view.View[@content-desc="Masuk Akun"]'
        );

        const loginTitle = await loginTitleComponent.getAttribute("content-desc");
        return loginTitle;
    }

    async insertEmailLogin(email) {
        const emailLoginContentElement =
          '//android.widget.EditText[1]';
    
        await this.click(emailLoginContentElement);
    
        await this.type(emailLoginContentElement, email);
    }

    async insertPasswordLogin(password) {
        const passwordLoginContentElement =
          '//android.widget.EditText[2]';
    
        await this.click(passwordLoginContentElement);
    
        await this.type(passwordLoginContentElement, password);
    }

    async clickMasukAkunButton() {
        await this.click('//android.widget.Button[@content-desc="Masuk"]');
    }

    async cannotClickMasukAkunButton() {
        await this.click('//android.widget.Button[@content-desc="Masuk"]');
    }

    async insertInvalidEmailLogin(email) {
        const invalidEmailLoginContentElement =
          '//android.widget.EditText[1]';
    
        await this.click(invalidEmailLoginContentElement);
    
        await this.type(invalidEmailLoginContentElement, email);
    }

    // async getErrorLoginMessage() {
    //     const errorLoginMessageComponent = await this.find(
    //         '//android.view.View[@content-desc="Masuk Akun"]'
    //     );

    //     const errorLoginMessage = await errorLoginMessageComponent.getAttribute("content-desc");
    //     return errorLoginMessage;
    // }

    async insertInvalidPasswordLogin(password) {
        const invalidPasswordLoginContentElement =
          '//android.widget.EditText[2]';
    
        await this.click(invalidPasswordLoginContentElement);
    
        await this.type(invalidPasswordLoginContentElement, password);
    }

    async clickForgotPassword() {
        await this.click('//android.view.View[@content-desc="Lupa kata sandi?"]');
    }

    async getForgotPasswordTitle() {
        const forgotPasswordTitleComponent = await this.find(
            '//android.view.View[@content-desc="Pemulihan Akun"]'
        );

        const forgotPasswordTitle = await forgotPasswordTitleComponent.getAttribute("content-desc");
        return forgotPasswordTitle;
    }

    async clickProfileButton() {
        await this.click(`//android.widget.ImageView[@content-desc="Profil
Tab 4 of 4"]`);
    }

    async clickKeluar() {
        await this.click('//android.widget.ImageView[@content-desc="Keluar"]');
    }

    async clickKeluarButton() {
        await this.click('(//android.view.View[@content-desc="Keluar"])[2]');
    }

    async clickBatalButton() {
        await this.click('//android.view.View[@content-desc="Batal"]');
    }

    async getProfileTitle() {
        const profileTitleComponent = await this.find(
            '//android.view.View[@content-desc="Profil"]'
        );

        const profileTitle = await profileTitleComponent.getAttribute("content-desc");
        return profileTitle;
    }
}
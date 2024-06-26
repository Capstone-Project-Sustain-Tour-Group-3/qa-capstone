import BasePage from "../basePage.js";

export default class SplashPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getSplashTitle() {
        const splashTitleComponent = await this.find(
            `//android.widget.ImageView[@content-desc="Temukan Destinasi Impianmu!
Jelajahi destinasi wisata tersembunyi di indonesia, temukan tempat-tempat yang belum pernah kamu bayangkan sebelumnya."]`
        );

        const splashTitle = await splashTitleComponent.getAttribute("content-desc");
        return splashTitle;
    }

    async clickSkipButton() {
        await this.click(
            '//android.widget.Button[@content-desc="Skip"]'
        );
    }

    async clickMulaiButton() {
        await this.click(
            '//android.widget.Button[@content-desc="Mulai"]'
        );
    }

    async clickDaftarButton() {
        await this.click(
            '//android.widget.Button[@content-desc="Daftar"]'
        );
    }

    async clicMasukButton() {
        await this.click(
            '//android.widget.Button[@content-desc="Masuk"]'
        );
    }
}
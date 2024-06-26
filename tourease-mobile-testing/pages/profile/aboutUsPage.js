import BasePage from "../basePage.js";

export default class AboutUsPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async clickAboutUsSection() {
        await this.click('//android.view.View[@content-desc="Tentang Kami"]');
    }

    async getAboutUsTitle() {
        const aboutUsTitleComponent = await this.find(
            '//android.view.View[@content-desc="Tentang Kami"]'
        );  

        const aboutUsTitle = await aboutUsTitleComponent.getAttribute("content-desc");
        return aboutUsTitle;
    }
}
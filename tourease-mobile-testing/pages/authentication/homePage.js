import BasePage from "../basePage.js";

export default class HomePage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getHomeTitle() {
        const homeTitleComponent = await this.find(
            '//android.view.View[@content-desc="Hi, "]'
        );

        const homeTitle = await homeTitleComponent.getAttribute("content-desc");
        return homeTitle;
    }

    async getHomeLoginTitle() {
        const homeLoginTitleComponent = await this.find(
            '//android.view.View[@content-desc="Mau kemana hari ini?"]'
        );

        const homeLoginTitle = await homeLoginTitleComponent.getAttribute("content-desc");
        return homeLoginTitle;
    }
}
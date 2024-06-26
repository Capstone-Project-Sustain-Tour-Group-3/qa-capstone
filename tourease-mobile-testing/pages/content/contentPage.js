import BasePage from "../basePage.js";

export default class ContentPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getVideoContentTitle() {
        const videoContentTitleComponent = await this.find(
            '//android.view.View[@content-desc="Curug Pelangi"]'
        );  

        const videoContentTitle = await videoContentTitleComponent.getAttribute("content-desc");
        return videoContentTitle;
    }
}
import BasePage from "../basePage.js";

export default class RoutePage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async clickSavedRouteSection() {
        await this.click('//android.view.View[@content-desc="Rute Tersimpan"]');
    }

    async getSavedRouteTitle() {
        const savedRouteTitleComponent = await this.find(
            '//android.view.View[@content-desc="Rute Tersimpan"]'
        );  

        const savedRouteTitle = await savedRouteTitleComponent.getAttribute("content-desc");
        return savedRouteTitle;
    }
}
import BasePage from "../basePage.js";

export default class DestinationPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async clickDestinationButton() {
        await this.click(`//android.widget.ImageView[@content-desc="Destinasi
Tab 2 of 4"]`);
    }

    async getDestinationTitle() {
        const destinationTitleComponent = await this.find(
            '//android.view.View[@content-desc="Destinasi"]'
        );

        const destinationTitle = await destinationTitleComponent.getAttribute("content-desc");
        return destinationTitle;
    }

    // async clickSearchSection() {
    //     await this.click('//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]');
    // }

    // async insertDestination(search) {
    //     const searchContentElement =
    //       '//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]';
    
    //     await this.click(searchContentElement);
    
    //     await this.type(searchContentElement, search);
    // }

    async clickSearchSection() {
        await this.click('//android.view.View[@content-desc="Oops, belum ada hasil nih!"]');
//         await this.click(`//android.widget.ImageView[@content-desc="295
// Curug Pelangi
// Kab. Bandung Barat, Jawa Barat
// Alam"]`);
    }
}
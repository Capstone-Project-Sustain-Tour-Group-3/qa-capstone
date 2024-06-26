import BasePage from "../basePage.js";

export default class EditPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getProfileTitle() {
        const profileTitleComponent = await this.find(
            '//android.view.View[@content-desc="Profil"]'
        );

        const profileTitle = await profileTitleComponent.getAttribute("content-desc");
        return profileTitle;
    }

    async clicEditSection() {
        await this.click('//android.view.View[@content-desc="Edit Akun"]');
    }

    async getEditTitle() {
        const editTitleComponent = await this.find(
            '//android.view.View[@content-desc="Edit Profil"]'
        );  

        const editTitle = await editTitleComponent.getAttribute("content-desc");
        return editTitle;
    }
}
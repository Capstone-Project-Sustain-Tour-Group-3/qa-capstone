import BasePage from "../basePage.js";

export default class PersonalizedPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async insertUsernamePersonalized(username) {
        const usernamePersonalizedContentElement =
          '//android.widget.EditText[1]';
    
        await this.click(usernamePersonalizedContentElement);
    
        await this.type(usernamePersonalizedContentElement, username);
    }

    async insertEmailPersonalized(email) {
        const emailPersonalizedContentElement =
          '//android.widget.EditText[1]';
    
        await this.click(emailPersonalizedContentElement);
    
        await this.type(emailPersonalizedContentElement, email);
    }
}
import { Given, When, Then, Before, After } from "@cucumber/cucumber";
import assert from "assert";

import initDriver from "../../configs/driver.js";
import SplashPage from "../../pages/authentication/splashPage.js";
import RegisterPage from "../../pages/authentication/registerPage.js";
import HomePage from "../../pages/authentication/homePage.js";
import LoginPage from "../../pages/authentication/loginPage.js";
import BasePage from "../../pages/basePage.js";
import EditPage from "../../pages/profile/editPage.js";
import RoutePage from "../../pages/profile/routePage.js";
import AboutUsPage from "../../pages/profile/aboutUsPage.js";
import DestinationPage from "../../pages/destination/destinationPage.js";
import PersonalizedPage from "../../pages/personalized/personalizedPage.js";
import ContentPage from "../../pages/content/contentPage.js";

let driver;
let splashPage;
let registerPage;
let homePage;
let loginPage;
let basePage;
let editPage;
let routePage;
let destinationPage;
let personalizedPage;
let aboutUsPage;
let contentPage;

Before({ timeout: 6000 * 10000 }, async () => {
  try {
    driver = await initDriver();
    splashPage = new SplashPage(driver);
    homePage = new HomePage(driver);
    registerPage = new RegisterPage(driver);
    loginPage = new LoginPage(driver);
    basePage = new BasePage(driver);
    editPage = new EditPage(driver);
    routePage = new RoutePage(driver);
    aboutUsPage = new AboutUsPage(driver);
    destinationPage = new DestinationPage(driver);
    personalizedPage = new PersonalizedPage(driver);
    contentPage = new ContentPage(driver);
  } catch (error) {
    console.error(error);
  }
});


//======================================== AUTHENTICATION - REGISTER ========================================

Given("I am on the splash screen page", { timeout: 20 * 1000 }, async () => {
    const splashPageTitle = await splashPage.getSplashTitle();
    const normalizedSplashTitle = splashPageTitle.replace(/\n/g, ' ');
    const expectedTitle = "Temukan Destinasi Impianmu! Jelajahi destinasi wisata tersembunyi di indonesia, temukan tempat-tempat yang belum pernah kamu bayangkan sebelumnya.";
    assert.equal(normalizedSplashTitle, expectedTitle);
});


When("I click Skip button", async () => {
    await splashPage.clickSkipButton();
});

Then("I click Mulai button", async () => {
    await splashPage.clickMulaiButton();
});

Then("I click Daftar button", async () => {
    await splashPage.clickDaftarButton();
});

Then("I am on the register page", async () => {
    const regisPageTitle = await registerPage.getRegisterTitle();
    assert.equal(regisPageTitle, "Buat akun baru");
});

Then("I input a valid username", async () => {
    const username = "anindya";
    await registerPage.insertUsername(username);
});

Then("I input a valid full name", async () => {
    const fullname = "anindyaearly";
    await registerPage.insertFullname(fullname);
});

Then("I input a valid email address", async () => {
    const email = "anindyaearly@gmail.com";
    await registerPage.insertEmail(email);
});

Then("I input a valid phone number", async () => {
    const number = "08189923845";
    await registerPage.insertNumber(number);
});

Then("I input a valid password", async () => {
    await basePage.hideKeyboard();
    const password = "toureaseanindya";
    await registerPage.insertPassword(password);
});

Then("I check on S&K option", async () => {
    await basePage.hideKeyboard();
    await registerPage.checkSnK();
});

Then("I click Daftar Akun button", async () => {
    await registerPage.clickDaftarAkunButton();
});

Then("I click Lanjutkan button", { timeout: 20 * 1000 }, async () => {
    await registerPage.clickLanjutkanButton();
});

Then("I cannot click Daftar Akun button", async () => {
    await registerPage.cannotClickDaftar();
});

Then("I redirected to failed register page", async () => {
    const failedRegisPageTitle = await registerPage.getFailedRegisterTitle();
    assert.equal(failedRegisPageTitle, "Maaf, pembuatan akun gagal.");
});

Then("I input a valid username for otp", async () => {
    const username = "dindawati";
    await registerPage.insertOtpUsername(username);
});

Then("I input a valid email address for otp", async () => {
    const email = "dindawatinur@gmail.com";
    await registerPage.insertOtpEmail(email);
});

Then("I input first OTP", async () => {
    const otp = "1";
    await registerPage.insertFirstOtp(otp);
});

Then("I input second OTP", async () => {
    const otp = "2";
    await registerPage.insertSecondOtp(otp);
});

Then("I input third OTP", async () => {
    const otp = "2";
    await registerPage.insertThirdOtp(otp);
});

Then("I input fourth OTP", async () => {
    const otp = "2";
    await registerPage.insertFourthOtp(otp);
});

Then("I click Kirim button", async () => {
    await registerPage.clicKirimButton();
});


//======================================== AUTHENTICATION - LOGIN ========================================

Then("I click Masuk button", async () => {
    await splashPage.clicMasukButton();
});

Then("I am on the login page", async () => {
    const loginPageTitle = await loginPage.getLoginTitle();
    assert.equal(loginPageTitle, "Masuk Akun");
});

Then("I input a valid email address for login", async () => {
    const email = "amandawayan32@gmail.com";
    await loginPage.insertEmailLogin(email);
});

Then("I input a valid password for login", async () => {
    const password = "amandatourease";
    await loginPage.insertPasswordLogin(password);
});

Then("I click Masuk Akun button", async () => {
    await basePage.hideKeyboard();
    await loginPage.clickMasukAkunButton();
});

Then("I redirected to the home page", { timeout: 20 * 1000 }, async () => {
    const homePageLoginTitle = await homePage.getHomeLoginTitle();
    assert.equal(homePageLoginTitle, "Mau kemana hari ini?");
});

Then("I cannot click Masuk Akun button", async () => {
    await basePage.hideKeyboard();
    await loginPage.cannotClickMasukAkunButton();
});

Then("I input a invalid email address for login", async () => {
    const email = "invalidemail@gmail.com";
    await loginPage.insertInvalidEmailLogin(email);
});

Then("I input a invalid password for login", async () => {
    const password = "invalidpassword";
    await loginPage.insertInvalidPasswordLogin(password);
});

Then("I click forgot password", async () => {
    await loginPage.clickForgotPassword();
});

Then("I redirected to forgot password page", async () => {
    const forgotPasswordTitle = await loginPage.getForgotPasswordTitle();
    assert.equal(forgotPasswordTitle, "Pemulihan Akun");
});

Then("I click Profil button", async () => {
    await loginPage.clickProfileButton();
});

Then("I click Keluar", async () => {
    await loginPage.clickKeluar();
});

Then("I click Keluar Button", async () => {
    await loginPage.clickKeluarButton();
});

Then("I redirected to login page", async () => {
    const redirectedLoginPage = await loginPage.getLoginTitle();
    assert.equal(redirectedLoginPage, "Masuk Akun");
});

Then("I click Batal Button", async () => {
    await loginPage.clickBatalButton();
});

Then("I returned to the profile page", async () => {
    const returnedProfilePage = await loginPage.getProfileTitle();
    assert.equal(returnedProfilePage, "Profil");
});


//======================================== PROFILE - EDIT ========================================

Then("I redirected to the profile page", async () => {
    const redirectedProfilePage = await editPage.getProfileTitle();
    assert.equal(redirectedProfilePage, "Profil");
});

Then("I click Edit Akun section", async () => {
    await editPage.clicEditSection();
});

Then("I redirected to the edit page", async () => {
    const redirectedEditPage = await editPage.getEditTitle();
    assert.equal(redirectedEditPage, "Edit Profil");
});


//======================================== PROFILE - SAVED ROUTE ========================================

Then("I click Rute Tersimpan section", async () => {
    await routePage.clickSavedRouteSection();
});

Then("I redirected to the saved route page", async () => {
    const redirectedSavedRoutePage = await routePage.getSavedRouteTitle();
    assert.equal(redirectedSavedRoutePage, "Rute Tersimpan");
});


//======================================== PROFILE - ABOUT US ========================================

Then("I click Tentang Kami section", async () => {
    await aboutUsPage.clickAboutUsSection();
});

Then("I redirected to the about us page", async () => {
    const redirectedAboutUsPage = await aboutUsPage.getAboutUsTitle();
    assert.equal(redirectedAboutUsPage, "Tentang Kami");
});


//======================================== DESTINATION ========================================

Then("I click Destinasi button", async () => {
    await destinationPage.clickDestinationButton();
});

Then("I redirected to the destination page", async () => {
    const redirectedDestinationPage = await destinationPage.getDestinationTitle();
    assert.equal(redirectedDestinationPage, "Destinasi");
});

Then("I select the desired destination", async () => {
    await destinationPage.clickDestinationButton();
});


//======================================== PERSONALIZED RECOMMENDATION ========================================

Then("I input a valid username for personalized recommendation", async () => {
    const email = "diani";
    await personalizedPage.insertUsernamePersonalized(email);
});

Then("I input a valid email address for personalized recommendation", async () => {
    const email = "diahdiani@gmail.com";
    await personalizedPage.insertEmailPersonalized(email);
});


//======================================== VIDEO CONTENT - FROM DESTINATION ========================================

Then("I see video content from the destination", async () => {
    const redirectedVideoContentPage = await contentPage.getVideoContentTitle();
    assert.equal(redirectedVideoContentPage, "Curug Pelangi");
});

After(async () => {
    await driver.deleteSession();
});
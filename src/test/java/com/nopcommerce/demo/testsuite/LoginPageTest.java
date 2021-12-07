package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inIt1() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPage() {
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyErrorMessageWithInvalidCredentialsNoEmailNoPassword() {
        homePage.clickOnLoginLink();
        loginPage.noEmailNoPassword();
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyErrorMessageWithInvalidCredentialsNoPassword() {
        homePage.clickOnLoginLink();
        loginPage.noPasswordError("test1@gmail.com");
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyErrorMessageWithInvalidCredentialsNoEmail() {
        homePage.clickOnLoginLink();
        loginPage.onlyPasswordError("test@567");
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyErrorMessageWithInvalidCredentialsInvalidEmailFormat() {
        homePage.clickOnLoginLink();
        loginPage.invalidEMailFormat("@gmail.com","test@749");
    }
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() throws InterruptedException {
        homePage.clickOnRegisterLink();
        Thread.sleep(2000);
        registerPage.verifyRegisterText();
        registerPage.enterFirstName("Anand");
        registerPage.enterLastName("Tripathi");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String email = "jamesbond" + timeStamp + "@gmail.com";
        registerPage.enterRegisterEmailId(email);
        registerPage.setPassword("JamesBond@123");
        registerPage.setConfirmPassword("JamesBond@123");
        registerPage.clickOnRegisterButtonOnRegisterPage();
        registerPage.verifyRegisterText();
        registerPage.clickOnContinueAfterRegistration();
        homePage.clickOnLogOutLink();
        homePage.clickOnLoginLink();
        loginPage.enterEmailId(email);
        loginPage.enterPassword("JamesBond@123");
        loginPage.clickOnLoginButton();
        homePage.verifyLogoutLinkIsDisplayedAfterLogin();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserShouldLogoutSuccessfully() throws InterruptedException {
        verifyThatUserShouldLogInSuccessFullyWithValidCredentials();
        homePage.clickOnLogOutLink();
        homePage.verifyLogInLinkIsDisplayedAfterLogout();
    }
}

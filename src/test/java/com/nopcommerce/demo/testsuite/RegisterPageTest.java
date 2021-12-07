package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(groups = {"regression", "smoke", "sanity"})
    public void inIt2() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String expectedMessage = "Register";
        String actualMessage = registerPage.getRegisterText();
        Assert.assertEquals(expectedMessage, actualMessage, "Register text is not displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        verifyUserShouldNavigateToRegisterPageSuccessfully();
        registerPage.clickOnRegisterButtonOnRegisterPage();
        registerPage.verifyMandatoryFieldsWithErrorMessageOnRegisterPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() {
        registerPage.newUserRegistration();
    }

}

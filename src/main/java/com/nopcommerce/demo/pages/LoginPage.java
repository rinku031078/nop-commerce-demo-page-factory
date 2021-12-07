package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(name = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement invalidLoginError;
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailError;


    public String getWelcomeText() {
        Reporter.log("Getting welcome text from : " + welcomeText.toString() + "<br>");
        //CustomListeners.test.log(Status.PASS,"Get welcomeText");
        return getTextFromElement(welcomeText);
    }

    public void ivEmailIvPW(String email, String password) {
        sendTextToElement(emailField, email);
        sendTextToElement(passwordField, password);
        verifyTestMethod("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found", invalidLoginError, "Invalid email and invalid password");
    }

    public void invalidEMailFormat(String email, String password) {
        sendTextToElement(emailField, email);
        sendTextToElement(passwordField, password);
        clickOnLoginButton();
        verifyTestMethod("Wrong email", emailError, "Wrong email format error not displayed");
    }

    public void onlyPasswordError(String password) {
        sendTextToElement(passwordField, password);
        clickOnLoginButton();
        verifyTestMethod("", emailError, "No email error is not displayed");
    }

    public void noPasswordError(String email) {
        sendTextToElement(emailField, email);

        clickOnLoginButton();
        verifyTestMethod("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found", invalidLoginError, "No password error is not displayed");
    }

    public void noEmailNoPassword() {
        clickOnLoginButton();
        verifyTestMethod("Please enter your email", emailError, "No email no pw error not displayed");
    }


    public void enterEmailId(String email) {
        Reporter.log("Entering email address : " + email + " to email field : " + emailField.toString() + "<br>");
        sendTextToElement(emailField, email);
    }

    public void enterPassword(String password) {
        Reporter.log("Entering password : " + password + " to password field : " + passwordField.toString() + "<br>");
        sendTextToElement(passwordField, password);
    }


    public void clickOnLoginButton() {
        Reporter.log("Clicking on login button : " + loginButton.toString() + "<br>");
        clickOnElement(loginButton);
    }


}
